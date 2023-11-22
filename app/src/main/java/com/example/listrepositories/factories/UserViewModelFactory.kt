package com.example.listrepositories.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.listrepositories.repositories.UserRepository
import com.example.listrepositories.viewmodels.UserRepositoryViewModel

class UserViewModelFactory constructor(private val repository: UserRepository) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(UserRepositoryViewModel::class.java)){
            UserRepositoryViewModel(this.repository) as T
        }else{
            throw IllegalArgumentException("viewmodel not found")
        }
    }
}