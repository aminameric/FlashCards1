package com.example.flashcards1.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "questions")
data class Question(
    @PrimaryKey(autoGenerate = true) val questionId: Int = 0,
    var quizId: Int,
    var question: String,
    var answer1: String,
    var answer2: String,
    var answer3: String,

)