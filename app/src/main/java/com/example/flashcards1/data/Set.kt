package com.example.flashcards1.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "sets")
data class Set(
    @PrimaryKey(autoGenerate = true) val setId: Int = 0,
    var privacy: Boolean,
    var name: String,
    var folderId: Int
)