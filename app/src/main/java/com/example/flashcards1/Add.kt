package com.example.flashcards1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun Add(modifier: Modifier = Modifier, navController: NavHostController) {
    var title by remember { mutableStateOf("") }
    var question by remember { mutableStateOf("") }
    var answer by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFede0d7))
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(Color(0xFFede0d7)),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.back_button),
                contentDescription = "back button",
                modifier = Modifier.size(35.dp).clickable{
                    navController.navigate("Landing Page")
                }
            )
            Image(
                painter = painterResource(R.drawable.logo_icon),
                contentDescription = "icon for app",
            )
        }
        Column(
            modifier = modifier
                .fillMaxWidth()
                .weight(0.7f)
                .background(Color(0xFFE08601)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            Column(
                modifier = modifier.clip(shape = RoundedCornerShape(30.dp))
                    .background(Color(0xFFD9D9D9)).padding(15.dp)
                    .clip(shape = RoundedCornerShape(15.dp)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Title",
                    modifier = Modifier.padding(top = 20.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    color = Color(0xFF000000)
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = title,
                    placeholder = { Text("Statistics") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(onNext = {
                        focusManager.moveFocus(
                            FocusDirection.Down
                        )
                    }),
                    singleLine = true,
                    onValueChange = {
                        title = it
                    },
                    modifier = modifier
                        .clip(RoundedCornerShape(10.dp))
                        .height(55.dp)
                        .width(300.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.Black,
                        placeholderColor = Color.Gray,
                        focusedIndicatorColor = Color.Transparent, // removes underline when focused
                        unfocusedIndicatorColor = Color.Transparent, // removes underline when unfocused
                        disabledIndicatorColor = Color.Transparent, // removes underline when disabled
                        backgroundColor = Color(0xFFFFFFFF)
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Folder",
                    modifier = Modifier.padding(top = 20.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    color = Color(0xFF000000)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = modifier
                        .clip(shape = RoundedCornerShape(8.dp))
                        .background(Color(0xFFede0d7))
                        .padding(start = 16.dp, top = 12.dp, end = 16.dp, bottom = 12.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.add_icon),
                        contentDescription = "add new folder",
                        modifier = Modifier.size(30.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = {
                        },
                        shape = RoundedCornerShape(50),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFE08601))
                    ) {
                        Text("Statistics", fontSize = 20.sp, color = Color.White)
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = {
                        },
                        shape = RoundedCornerShape(50),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFE08601))
                    ) {
                        Text("English 1", fontSize = 20.sp, color = Color.White)
                    }
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            Column(
                modifier = modifier.clip(shape = RoundedCornerShape(30.dp))
                    .background(Color(0xFFD9D9D9)).padding(15.dp)
                    .clip(shape = RoundedCornerShape(15.dp)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Question",
                    modifier = Modifier.padding(top = 20.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    color = Color(0xFF000000)
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = question,
                    placeholder = { Text("What is the Central Limit Theorem?") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(onNext = {
                        focusManager.moveFocus(
                            FocusDirection.Down
                        )
                    }),
                    singleLine = true,
                    onValueChange = {
                        question= it
                    },
                    modifier = modifier
                        .clip(RoundedCornerShape(10.dp))
                        .height(55.dp)
                        .width(300.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.Black,
                        placeholderColor = Color.Gray,
                        focusedIndicatorColor = Color.Transparent, // removes underline when focused
                        unfocusedIndicatorColor = Color.Transparent, // removes underline when unfocused
                        disabledIndicatorColor = Color.Transparent, // removes underline when disabled
                        backgroundColor = Color(0xFFFFFFFF)
                    )
                )
                Text(
                    text = "Answer",
                    modifier = Modifier.padding(top = 20.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    color = Color(0xFF000000)
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = answer,
                    placeholder = { Text("states that the distribution of sample means approximates a normal distribution as the sample size gets larger") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(onNext = { focusManager.clearFocus()}),
                    singleLine = true,
                    onValueChange = {
                        answer= it
                    },
                    modifier = modifier
                        .clip(RoundedCornerShape(10.dp))
                        .height(55.dp)
                        .width(300.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.Black,
                        placeholderColor = Color.Gray,
                        focusedIndicatorColor = Color.Transparent, // removes underline when focused
                        unfocusedIndicatorColor = Color.Transparent, // removes underline when unfocused
                        disabledIndicatorColor = Color.Transparent, // removes underline when disabled
                        backgroundColor = Color(0xFFFFFFFF)
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = modifier
                        .clip(shape = RoundedCornerShape(8.dp))
                        .background(Color(0xFFede0d7))
                        .padding(start = 16.dp, top = 12.dp, end = 16.dp, bottom = 12.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Button(
                        onClick = {
                        },
                        shape = RoundedCornerShape(50),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFE08601))
                    ) {
                        Text("Private", fontSize = 20.sp, color = Color.White)
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = {
                        },
                        shape = RoundedCornerShape(50),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFE08601))
                    ) {
                        Text("Public", fontSize = 20.sp, color = Color.White)
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row() {
                Button(
                    onClick = {
                    },
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFD9D9D9))
                ) {
                    Image(
                        painter = painterResource(R.drawable.add_icon),
                        contentDescription = "add button",
                        modifier = Modifier.size(30.dp)
                    )
                    Text("Add", fontSize = 25.sp, color = Color.Black)


                }
            }
        }
    }
}