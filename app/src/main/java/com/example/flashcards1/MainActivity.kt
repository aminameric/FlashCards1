package com.example.flashcards1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.flashcards1.data.CardViewModel
import com.example.flashcards1.data.FolderViewModel
import com.example.flashcards1.data.MyDatabase
import com.example.flashcards1.data.SetViewModel
import com.example.flashcards1.data.UserViewModel
import com.example.flashcards1.ui.theme.FlashCards1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //val app: FlashCards1Application = FlashCards1Application()
            //val db: MyDatabase = app.database
            val db: MyDatabase = MyDatabase.getInstance(applicationContext)

            FlashCards1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen(db = db)
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier, db: MyDatabase) {

    //val userViewModel=db.userDao()
    val userViewModel=UserViewModel(db.userDao())
    val setViewModel = SetViewModel(db.setDao())
    val folderViewModel= FolderViewModel(db.folderDao())
    val cardViewModel = CardViewModel(db.cardDao())
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Login"){
        composable("Login"){ LoginScreen(navController = navController, userViewModel = userViewModel)}
        composable("Signup"){ SignupScreen(navController = navController, userViewModel = userViewModel)}
        composable("Add"){ Add(navController = navController, folderViewModel = folderViewModel, setViewModel = setViewModel, cardViewModel = cardViewModel)}
        composable("Cards"){ Cards(navController = navController, cardViewModel = cardViewModel, setViewModel = setViewModel)}
        composable("Landing Page"){ LandingPage(navController = navController, folderViewModel = folderViewModel, setViewModel = setViewModel)}
        composable("MyProfile"){ MyProfile(navController = navController, setViewModel = setViewModel, folderViewModel = folderViewModel) }
    }
}
@Preview(showBackground = true)
@Composable
    fun DefaultPreview() {
        FlashCards1Theme {
            val db: MyDatabase = MyDatabase.getInstance(LocalContext.current)
            MainScreen(db = db)

        }
    }




