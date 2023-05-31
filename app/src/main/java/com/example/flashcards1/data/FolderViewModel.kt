package com.example.flashcards1.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory

class FolderViewModel (private val folderDao : FolderDao): ViewModel(){

    fun getFolderById(folderId : Int): Folder? = folderDao.getFolderById(folderId = folderId)

    fun insert(folder:Folder)= folderDao.insert(folder)

    fun delete (folder:Folder)= folderDao.delete(folder)

    fun update (folder:Folder)= folderDao.update(folder)
    companion object{
        val factory: ViewModelProvider.Factory= viewModelFactory {
            initializer {
                val application =(this[APPLICATION_KEY] as FlashCards1Application)
                UserViewModel(application.database.userDao())
            }
        }
    }
}