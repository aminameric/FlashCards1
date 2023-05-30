package com.example.flashcards1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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

@Composable
fun LandingPage(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFede0d7))

    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .weight(0.13f)
                .background(Color(0xFFE08601)),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            Image(
                painter = painterResource(R.drawable.logo_icon),
                contentDescription = "icon for app"
            )
        }

        Spacer(modifier = Modifier.height(40.dp))
        Column(
            modifier = modifier
                .fillMaxWidth()
                .weight(0.5f)
                .background(Color(0xFFede0d7)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "Most popular",
                modifier = Modifier.padding(start = 16.dp, top = 10.dp),
                textAlign = TextAlign.Start,
                fontSize = 25.sp,
                color = Color(0xFF000000)
            )
            Row(
                modifier = modifier
                    .clip(shape = RoundedCornerShape(8.dp))
                    .background(Color(0xFFD9D9D9))
                    .padding(start = 16.dp, top = 12.dp, end = 16.dp, bottom = 12.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
            ) {

                Button(
                    onClick = {
                    },
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFE08601))
                ) {
                    Text("Calculus", fontSize = 20.sp, color = Color.Black)
                }
                Spacer(modifier = Modifier.width(20.dp))
                Button(
                    onClick = {
                    },
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFE08601))
                ) {
                    Text("Programming", fontSize = 20.sp, color = Color.Black)
                }

            }
            Spacer(modifier = Modifier.height(60.dp))
            Text(
                text = "Recently used",
                modifier = Modifier.padding(start = 16.dp, top = 10.dp),
                textAlign = TextAlign.Start,
                fontSize = 25.sp,
                color = Color(0xFF000000)
            )
            Row(
                modifier = modifier
                    .clip(shape = RoundedCornerShape(8.dp))
                    .background(Color(0xFFD9D9D9))
                    .padding(start = 16.dp, top = 12.dp, end = 16.dp, bottom = 12.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
            ) {

                Button(
                    onClick = {
                    },
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFE08601))
                ) {
                    Text("Calculus", fontSize = 20.sp, color = Color.Black)
                }
                Spacer(modifier = Modifier.width(20.dp))
                Button(
                    onClick = {
                    },
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFE08601))
                ) {
                    Text("Programming", fontSize = 20.sp, color = Color.Black)
                }

            }
            Spacer(modifier = Modifier.height(60.dp))
            Text(
                text = "Folders",
                modifier = Modifier.padding(start = 16.dp, top = 10.dp),
                textAlign = TextAlign.Start,
                fontSize = 25.sp,
                color = Color(0xFF000000)
            )
            Row(
                modifier = modifier
                    .clip(shape = RoundedCornerShape(8.dp))
                    .padding(start = 16.dp, top = 12.dp, end = 16.dp, bottom = 12.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
            ) {

                Button(
                    onClick = {
                    },
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFE08601))
                ) {
                    Text("Calculus", fontSize = 20.sp, color = Color.Black)
                }
                Spacer(modifier = Modifier.width(20.dp))
                Button(
                    onClick = {
                    },
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFE08601))
                ) {
                    Text("Programming", fontSize = 20.sp, color = Color.Black)
                }

            }
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .background(Color(0xFFede0d7)),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.home_icon),
                        contentDescription = "icon for home page",
                        modifier = Modifier.size(65.dp)
                    )
                    Text("Home", fontSize = 30.sp, color = Color.Black)
                }
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .background(Color(0xFFede0d7)),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.add_icon),
                        contentDescription = "icon for add",
                        modifier = Modifier.size(65.dp)
                    )
                    Text("Add", fontSize = 30.sp, color = Color.Black)
                }
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .background(Color(0xFFede0d7)),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.profile_icon),
                        contentDescription = "icon for profile page",
                        modifier = Modifier.size(65.dp)
                    )
                    Text("Profile", fontSize = 30.sp, color = Color.Black)
                }
            }
        }

    }
}





