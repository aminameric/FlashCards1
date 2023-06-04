package com.example.flashcards1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.flashcards1.data.Card
import com.example.flashcards1.data.CardViewModel
import com.example.flashcards1.data.Set
import com.example.flashcards1.data.SetViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Composable
fun Cards(modifier: Modifier = Modifier, navController: NavHostController, cardViewModel: CardViewModel, setViewModel: SetViewModel) {
    val myScope = CoroutineScope(Dispatchers.Default)
    var currentSet: Set? = null
    var cards by remember { mutableStateOf(listOf(Card(answer = "a1", question = "q1", setId = 1), Card(answer = "a2", question = "q2", setId = 1), Card(answer = "a3", question = "q3", setId = 1), Card(answer = "a4", question = "q4", setId = 1),Card(answer = "a5", question = "q5", setId = 1))) }
    var currentIndex by remember {
        mutableStateOf("0")
    }
    var text by remember {
            mutableStateOf(cards.get(currentIndex.toInt()).question)
    }

    var switcher by remember {
        mutableStateOf("true")
    }


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
                    modifier = Modifier
                        .size(25.dp)
                        .clickable {
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
            currentSet?.let {
                Text(
                    text = it.name,
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .background(Color(0xFFE08601), RoundedCornerShape(8.dp)),
                    textAlign = TextAlign.Center,
                    fontSize = 30.sp,
                    color = Color.Black
                )
            }

        }
        Column(
            modifier = modifier
                .fillMaxWidth()
                .weight(0.4f)
                .background(Color(0xFFE08601)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .clickable {
                        if (switcher == "true") {
                            switcher = "false"
                        } else {
                            switcher = "true"
                        }
                    }
            ) {
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
                        text = if(switcher == "true") {
                                            cards.get(currentIndex.toInt()).question
                                            }else {
                                                  cards.get(currentIndex.toInt()).answer
                                                  },
                        modifier = Modifier
                            .padding(start = 16.dp, top = 12.dp, end = 16.dp, bottom = 12.dp)
                            .background(Color(0xFFD9D9D9), RoundedCornerShape(8.dp)),
                        textAlign = TextAlign.Center,
                        fontSize = 40.sp,
                        color = Color.Black
                    )
                }

            }
            Row(
                modifier = modifier
                    .background(Color(0xFFE08601))
            ) {
                Image(
                    painter = painterResource(R.drawable.left_icon),
                    contentDescription = "icon for app",
                    modifier = Modifier
                        .size(35.dp)
                        .clickable {
                            if (currentIndex.toInt() != 0) {
                               currentIndex = (currentIndex.toInt() - 1).toString()
                            }
                        }
                )
                Row(
                    modifier = modifier
                        .background(Color(0xFFE08601))

                ) {
                    Text(
                        text = "${currentIndex}/4",
                        modifier = Modifier
                            .padding(start = 16.dp, top = 1.dp, end = 16.dp, bottom = 12.dp)
                            .background(Color(0xFFE08601), RoundedCornerShape(8.dp)),
                        textAlign = TextAlign.Center,
                        fontSize = 25.sp,
                        color = Color.White
                    )
                    Row(
                        modifier = modifier
                            .background(Color(0xFFE08601))
                    ) {
                        Image(
                            painter = painterResource(R.drawable.right_icon),
                            contentDescription = "icon for app",
                            modifier = Modifier
                                .size(35.dp)
                                .clickable {
                                    if (currentIndex.toInt() < cards.size - 1) {
                                        currentIndex = (currentIndex.toInt() + 1).toString()
                                    }
                                }
                        )

                    }
                }

            }
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .background(Color(0xFFE08601))
                    .padding(start = 10.dp, top = 10.dp, end = 12.dp, bottom = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top

            ) {
                Row(
                    modifier = modifier
                        .background(Color(0xFFE08601))
                ) {
                    Image(
                        painter = painterResource(R.drawable.shuffl_icon),
                        contentDescription = "icon for app",
                        modifier = Modifier.size(52.dp).clickable {
                            cards = cards.shuffled()
                        }
                    )

                    Spacer(modifier = Modifier.width(50.dp))

                    Row(
                        modifier = modifier
                            .background(Color(0xFFE08601))
                    ) {
                            Image(
                                painter = painterResource(R.drawable.again_icon),
                                contentDescription = "icon for app",
                                modifier = Modifier.size(52.dp).clickable {
                                    currentIndex = "0"
                                }
                            )


                    }
                }
            }
        }
    }
}