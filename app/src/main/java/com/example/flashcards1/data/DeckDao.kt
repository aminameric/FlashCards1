package com.example.flashcards1.data

import androidx.room.*
import kotlin.collections.Set


@Dao
interface DeckDao {
    @Insert
    fun insert(deck: Deck)

    @Update
    fun update(deck: Deck)

    @Delete
    fun delete(deck: Deck)

    @Query("SELECT * FROM decks WHERE deckId = :deckId")
    fun getDeckById(deckId : Int): Deck?

    @Query("SELECT * FROM decks WHERE setId = :setId")
    fun getDeckBySetId(setId : Int): List<Deck>?

}