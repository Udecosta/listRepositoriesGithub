package com.example.listrepositories.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listrepositories.models.Pulls
import com.example.listrepositories.models.Repositories
import com.example.listrepositories.repositories.UserRepository
import kotlinx.coroutines.launch

class UserRepositoryViewModel(private val userRepository: UserRepository) : ViewModel() {

    private val _repositories = MutableLiveData<List<Repositories>>()
    val repositories: LiveData<List<Repositories>> get() = _repositories

    private val _pulls = MutableLiveData<List<Pulls>>()
    val pulls: LiveData<List<Pulls>> get() = _pulls

    fun getAllRepositories() = viewModelScope.launch {
        val repositories = userRepository.getAllRepositories()

        val listRepositories = arrayListOf<Repositories>()
        listRepositories.add(repositories)

        if (listRepositories.isNotEmpty()) {
            _repositories.value = listRepositories
        }
    }



}
