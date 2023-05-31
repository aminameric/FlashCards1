package com.example.flashcards1.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "quizzes")
data class Quiz(
    @PrimaryKey(autoGenerate = true) val quizId: Int = 0,
    var name: String,
    var setId: Int
)