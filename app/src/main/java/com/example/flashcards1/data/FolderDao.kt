package com.example.flashcards1.data

import androidx.room.*


@Dao
interface FolderDao {
    @Insert
    fun insert(folder: Folder)

    @Update
    fun update(folder: Folder)

    @Delete
    fun delete(folder: Folder)

    @Query("SELECT * FROM folders WHERE folderId = :folderId")  //only one folder since every folder has unique key
    fun getFolderById(folderId : Int): Folder?

    @Query("SELECT * FROM folders WHERE userId = :userId")   //returns list of folders
    fun getFolderByUserId(userId : Int): List<Folder>
}