package com.example.flashcards1.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory


class QuestionViewModel (private val questionDao : QuestionDao): ViewModel(){

    fun getQuestionById(questionId:Int): Question? = questionDao.getQuestionById(questionId= questionId)

    fun getQuestionByQuizId(quizId:Int): List<Question>? = questionDao.getQuestionByQuizId(quizId= quizId)

    fun insert(question: Question)= questionDao.insert(question)

    fun delete (question: Question)= questionDao.delete(question)

    fun update (question: Question)= questionDao.update(question)
    companion object{
        val factory: ViewModelProvider.Factory= viewModelFactory {
            initializer {
                val application =(this[APPLICATION_KEY] as FlashCards1Application)
                UserViewModel(application.database.userDao())
            }
        }
    }
}