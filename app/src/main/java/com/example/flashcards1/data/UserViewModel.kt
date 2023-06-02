package com.example.flashcards1.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory

class UserViewModel(private val userDao: UserDao): ViewModel(){


    fun getUserById(email: String, password: String): User? = userDao.getUserById(email=email, password=password)
    fun insert(user:User)= userDao.insert(user)

    fun delete (user: User)= userDao.delete(user)

    fun update (user: User)= userDao.update(user)
    companion object{
        val factory: ViewModelProvider.Factory= viewModelFactory {
            initializer {
                val application =(this[APPLICATION_KEY] as FlashCards1Application)
                UserViewModel(application.database.userDao())
            }
        }
    }
}
