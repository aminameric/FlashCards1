package com.example.flashcards1.data


import androidx.room.*


@Dao
interface CardDao {
    @Insert
    fun insert(card: Card)

    @Update
    fun update(card: Card)

    @Delete
    fun delete(card: Card)

    @Query("SELECT * FROM cards WHERE cardId = :cardId")
    fun getCardById(cardId : Int): Card?

    @Query("SELECT * FROM cards WHERE deckId = :deckId")
    fun getCardByDeckId(deckId : Int): List<Card>?

}