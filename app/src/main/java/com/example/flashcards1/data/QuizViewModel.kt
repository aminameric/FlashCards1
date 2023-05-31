package com.example.flashcards1.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory


class QuizViewModel (private val quizDao : QuizDao): ViewModel(){

    fun getQuizById(quizId:Int): Quiz? = quizDao.getQuizById(quizId= quizId)

    fun getQuizBySetId(setId:Int): List<Quiz>? = quizDao.getQuizBySetId(setId= setId)

    fun insert(quiz: Quiz)= quizDao.insert(quiz)

    fun delete (quiz: Quiz)= quizDao.delete(quiz)

    fun update (quiz: Quiz)= quizDao.update(quiz)
    companion object{
        val factory: ViewModelProvider.Factory= viewModelFactory {
            initializer {
                val application =(this[APPLICATION_KEY] as FlashCards1Application)
                UserViewModel(application.database.userDao())
            }
        }
    }
}