package com.example.flashcards1.data

import androidx.room.*


@Dao
interface QuizDao {
    @Insert
    fun insert(quiz: Quiz)

    @Update
    fun update(quiz: Quiz)

    @Delete
    fun delete(quiz: Quiz)

    @Query("SELECT * FROM quizzes WHERE quizId = :quizId")
    fun getQuizById(quizId : Int): Quiz?

    @Query("SELECT * FROM quizzes WHERE setId = :setId")
    fun getQuizBySetId(setId : Int): List<Quiz>?

}