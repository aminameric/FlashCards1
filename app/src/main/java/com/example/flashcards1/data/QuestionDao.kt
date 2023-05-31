package com.example.flashcards1.data

import androidx.room.*


@Dao
interface QuestionDao {
    @Insert
    fun insert(question: Question)

    @Update
    fun update(question: Question)

    @Delete
    fun delete(question: Question)

    @Query("SELECT * FROM questions WHERE questionId = :questionId")
    fun getQuestionById(questionId : Int): Question?

    @Query("SELECT * FROM questions WHERE quizId = :quizId")
    fun getQuestionByQuizId(quizId : Int): List<Question>?


}