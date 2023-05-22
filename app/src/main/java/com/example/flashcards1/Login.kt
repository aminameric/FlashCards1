package com.example.flashcards1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun LoginScreen(modifier:Modifier = Modifier){
    var email by remember { mutableStateOf("") }       //mutable state of, with strings
    var password by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current            //fokusiran na one text field kad kliknemo na nesto
    Column(                                                    //function
       modifier= modifier
           .fillMaxSize()
           .background(Color.White)

    ){
        Column(
            modifier= modifier
                .fillMaxWidth()
                .weight(0.5f)
                .background(Color(0xFFefe4dc)), //uzimamo sta nam treba iz modifier, .fillmaxWidth, .weight0.5(uzimamo pola visine) i koju cemo boju imati u tom column-u
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center                                      //da centrira ikonicu i text unutar tog columna
        ){
            Image(painter = painterResource(R.drawable.logo_icon), contentDescription = "icon for app")
            Text(
                text = "FlashCards",
                modifier = Modifier.padding(top = 20.dp),
                textAlign = TextAlign.Center,
                fontSize = 40.sp,
                color = Color(0xFFE08601)
            )
        }
        Column(
            modifier= modifier
                .fillMaxWidth()
                .weight(0.5f)
                .background(Color(0xFFE08601))
                .clip(shape = RoundedCornerShape(30.dp)),       //HELP
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ){
            Column(
                modifier=modifier.background(Color(0xFFede0d7)).padding(15.dp).clip(shape = RoundedCornerShape(20.dp)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ){
                Text(
                    text = "Email address",
                    modifier = Modifier.padding(top = 20.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    color = Color(0xFF000000)
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(     //za email
                    value = email,
                    placeholder = { Text("aminameric@gmail.com") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down)}),
                    singleLine = true,
                    onValueChange = {email = it},                 //email varijabla se updateuje zato imamo remember by state of
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
                    text = "Password",
                    modifier = Modifier.padding(top = 20.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    color = Color(0xFF000000)
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(     //za password
                    value = password,
                    placeholder = { Text("1123") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.NumberPassword,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(onNext = { focusManager.clearFocus()}),    //clear focus jer je zadnji text field
                    singleLine = true,
                    onValueChange = {password = it},                 //email varijabla se updateuje zato imamo remember by state of
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
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text="Log in", fontSize = 25.sp, color=Color(0xFFE08601)
                )
                Spacer(modifier = Modifier.height(12.dp))
            }
            Spacer(modifier = Modifier.height(12.dp))
            Button(
                onClick = { },
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFede0d7))
            ) {
                Text("Sign up", fontSize = 20.sp, color = Color(0xFFE08601))
            }
        }

    }


}