package com.example.flashcards1.data


import androidx.room.*


@Dao
interface UserDao {
    @Insert
    fun insert(user: User)

    @Update
    fun update(user: User)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM users WHERE email = :email AND password = :password")
    fun getUserById(email: String, password: String): User?


}