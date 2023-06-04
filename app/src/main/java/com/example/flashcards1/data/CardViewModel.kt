package com.example.flashcards1.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory


class CardViewModel (private val cardDao : CardDao): ViewModel(){

    fun getCardById(cardId:Int): Card? = cardDao.getCardById(cardId= cardId)

    fun getCardBySetId(setId:Int): List<Card> = cardDao.getCardBySetId(setId= setId)

    fun insert(card:Card)= cardDao.insert(card)

    fun delete (card:Card)= cardDao.delete(card)

    fun update (card:Card)= cardDao.update(card)
    companion object{
        val factory: ViewModelProvider.Factory= viewModelFactory {
            initializer {
                val application =(this[APPLICATION_KEY] as FlashCards1Application)
                UserViewModel(application.database.userDao())
            }
        }
    }
}