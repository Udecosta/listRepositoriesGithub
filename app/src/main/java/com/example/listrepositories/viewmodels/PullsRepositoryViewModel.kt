package com.example.listrepositories.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listrepositories.models.Owner
import com.example.listrepositories.models.Pulls
import com.example.listrepositories.models.PullsItem
import com.example.listrepositories.models.Repositories
import com.example.listrepositories.repositories.PullsRepository
import com.example.listrepositories.repositories.UserRepository
import kotlinx.coroutines.launch

class PullsRepositoryViewModel(private val pullsRepository: PullsRepository): ViewModel() {

    private val _pulls = MutableLiveData<List<PullsItem>>()
    val pulls: LiveData<List<PullsItem>> get() = _pulls

    fun gelAllPulls(owner: String, repo: String) = viewModelScope.launch {
        val pulls = pullsRepository.getAllPulls(owner = owner, repo = repo)

        val listPulls = arrayListOf<PullsItem>()
        pulls.map { pullItem ->
            listPulls.add(pullItem)
        }

        if (listPulls.isNotEmpty()) {
            _pulls.value = listPulls
        }
    }


}