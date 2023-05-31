package com.example.flashcards1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelStore
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.flashcards1.ui.theme.FlashCards1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlashCards1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Login"){
        composable("Login"){ LoginScreen(navController = navController)}
        composable("Signup"){ SignupScreen(navController = navController)}
        composable("Add"){ Add(navController = navController)}
        composable("Cards"){ Cards(navController = navController)}
        composable("CardsVSQuiz"){ CardsVSQuiz(navController = navController) }
        composable("Landing Page"){ LandingPage(navController = navController) }
        composable("MyProfile"){ MyProfile(navController = navController) }
        composable("Quiz"){ Quiz(navController = navController) }
        composable("StatisticsFolder"){ StatisticsFolder(navController = navController) }
    }
}
@Preview(showBackground = true)
@Composable
    fun DefaultPreview() {
        FlashCards1Theme {
            MainScreen()
        }
    }




