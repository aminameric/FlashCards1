package com.example.flashcards1.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "decks")
data class Deck(
    @PrimaryKey(autoGenerate = true) val deckId: Int = 0,
    var name: String,
    var setId: Int
)