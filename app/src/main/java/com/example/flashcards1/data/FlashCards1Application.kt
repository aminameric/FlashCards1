package com.example.flashcards1.data

import android.app.Application

class FlashCards1Application: Application() {
    val database: MyDatabase by lazy{MyDatabase.getInstance(this)}
}