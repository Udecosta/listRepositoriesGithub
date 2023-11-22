package com.example.listrepositories.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.listrepositories.repositories.PullsRepository
import com.example.listrepositories.viewmodels.PullsRepositoryViewModel

class PullViewModelFactory(private val  pullsRepository: PullsRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(PullsRepositoryViewModel::class.java)){
            PullsRepositoryViewModel(this.pullsRepository) as T
        }else{
            throw IllegalArgumentException("viewmodel not found")
        }
    }
}