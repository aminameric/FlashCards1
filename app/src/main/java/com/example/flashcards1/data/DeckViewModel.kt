package com.example.flashcards1.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory


class DeckViewModel (private val deckDao : DeckDao): ViewModel(){

    fun getDeckById(deckId:Int): Deck? = deckDao.getDeckById(deckId= deckId)

    fun getDeckBySetId(setId:Int): List<Deck>? = deckDao.getDeckBySetId(setId= setId)

    fun insert(deck: Deck)= deckDao.insert(deck)

    fun delete (deck: Deck)= deckDao.delete(deck)

    fun update (deck: Deck)= deckDao.update(deck)
    companion object{
        val factory: ViewModelProvider.Factory= viewModelFactory {
            initializer {
                val application =(this[APPLICATION_KEY] as FlashCards1Application)
                UserViewModel(application.database.userDao())
            }
        }
    }
}