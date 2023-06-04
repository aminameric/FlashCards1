package com.example.flashcards1.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "cards")
data class Card(
    @PrimaryKey(autoGenerate = true) val cardId: Int = 0,
    var setId: Int,
    var question: String,
    var answer: String
)