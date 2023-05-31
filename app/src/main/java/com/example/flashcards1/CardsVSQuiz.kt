package com.example.flashcards1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun CardsVSQuiz(modifier: Modifier = Modifier, navController: NavHostController) {
    Column(                                                    //function
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)

    ) {
        Row(){
            Button(
                onClick = {
                },
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFede0d7))
            ) {
                Image(
                    painter = painterResource(R.drawable.back_button),
                    contentDescription = "back button",
                    modifier = Modifier.size(25.dp).clickable{
                        navController.navigate("Landing Page")
                    }
                )
            }
        }
        Column(
            modifier = modifier
                .fillMaxWidth()
                .weight(0.3f)
                .background(Color(0xFFefe4dc)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.logo_icon),
                contentDescription = "icon for app"
            )
            Text(
                text = "Statistics",
                modifier = Modifier
                    .padding(top = 20.dp)
                    .background(Color(0xFFE08601), RoundedCornerShape(8.dp)),
                textAlign = TextAlign.Center,
                fontSize = 40.sp,
                color = Color.Black
            )

        }
        Column(
            modifier = modifier
                .fillMaxWidth()
                .weight(0.7f)
                .background(Color(0xFFE08601)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(modifier = Modifier.padding(16.dp).clip(RoundedCornerShape(8.dp))) {
                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .background(Color(0xFFD9D9D9))
                        .padding(start = 16.dp, top = 12.dp, end = 16.dp, bottom = 12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Cards",
                        modifier = Modifier
                            .padding(start = 16.dp, top = 12.dp, end = 16.dp, bottom = 12.dp)
                            .background(Color(0xFFD9D9D9), RoundedCornerShape(8.dp)),
                        textAlign = TextAlign.Center,
                        fontSize = 40.sp,
                        color = Color.Black
                    )
                }
            }
            Box(modifier = Modifier.padding(16.dp).clip(RoundedCornerShape(8.dp))) {
                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .background(Color(0xFFD9D9D9))
                        .padding(start = 16.dp, top = 12.dp, end = 16.dp, bottom = 12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Quiz",
                        modifier = Modifier
                            .padding(start = 16.dp, top = 12.dp, end = 16.dp, bottom = 12.dp)
                            .background(Color(0xFFD9D9D9), RoundedCornerShape(8.dp)),
                        textAlign = TextAlign.Center,
                        fontSize = 40.sp,
                        color = Color.Black
                    )
                }
            }
        }
    }
}