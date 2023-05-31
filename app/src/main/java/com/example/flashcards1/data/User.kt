package com.example.flashcards1.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) val userId: Int = 0,
    var firstName: String,
    var lastName: String,
    var location : String,
    var email: String,
    var password: String,
    var icon: Int
)