package com.example.flashcards1.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory

class SetViewModel (private val setDao : SetDao): ViewModel(){

    fun getSetById(setId:Int): Set? = setDao.getSetById(setId= setId)

    fun getSetByFolderId(folderId:Int): List<Set>? = setDao.getSetByFolderId(folderId=folderId)

    fun insert(set:Set)= setDao.insert(set)

    fun delete (set: Set)= setDao.delete(set)

    fun update (set: Set)= setDao.update(set)
    companion object{
        val factory: ViewModelProvider.Factory= viewModelFactory {
            initializer {
                val application =(this[APPLICATION_KEY] as FlashCards1Application)
                UserViewModel(application.database.userDao())
            }
        }
    }
}