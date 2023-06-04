package com.example.flashcards1.data


import androidx.room.*


@Dao
interface SetDao {
    @Insert
    fun insert(set:Set)

    @Update
    fun update(set:Set)

    @Delete
    fun delete(set: Set)

    @Query("SELECT * FROM sets WHERE setId = :setId")
    fun getSetById(setId : Int): Set?

    @Query("SELECT * FROM sets WHERE folderId = :folderId")
    fun getSetByFolderId(folderId : Int): List<Set>

    @Query("SELECT * FROM sets WHERE userId = :userId")
    fun getSetByUser(userId: Int): List<Set>

}