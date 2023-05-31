package com.example.flashcards1.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "folders")
data class Folder(
    @PrimaryKey(autoGenerate = true) val folderId: Int = 0,
    var name: String,
    var userId: Int
)