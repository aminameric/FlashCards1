package com.example.flashcards1

import android.app.Application
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.flashcards1.data.FlashCards1Application
import com.example.flashcards1.data.MyDatabase
import com.example.flashcards1.data.User
import com.example.flashcards1.data.UserDao
import com.example.flashcards1.data.UserViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun SignupScreen (modifier: Modifier = Modifier, navController: NavHostController, userViewModel:UserViewModel){

    val myScope = CoroutineScope(Dispatchers.Default)
    var firstname by remember { mutableStateOf("") }
    var lastname by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }       //mutable state of, with strings
    var password by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    var icon: Int = 0
    val focusManager = LocalFocusManager.current //fokusiran na one text field kad kliknemo na nesto
    Column(                                                    //function
        modifier= modifier
            .fillMaxSize()
            .background(Color.White)

    ) {
        Row(
            modifier= modifier
                .fillMaxWidth()
                .weight(0.5f)
                .background(Color(0xFFefe4dc)), //uzimamo sta nam treba iz modifier, .fillmaxWidth, .weight0.5(uzimamo pola visine) i koju cemo boju imati u tom column-u
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Top                                  //da centrira ikonicu i text unutar tog columna
        ){
            Column() {
                Image(
                    painter = painterResource(R.drawable.logo_icon),
                    contentDescription = "icon for app"
                )
                Button(
                    onClick = {
                    },
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFede0d7))
                ) {
                    Image(
                        painter = painterResource(R.drawable.back_button),
                        contentDescription = "back button",
                        modifier = Modifier.size(25.dp).clickable{navController.navigate("Login")
                        }
                    )
                }
            }
            Row(
                modifier= modifier
                    .fillMaxWidth()
                    .weight(0.1f)
                    .background(Color(0xFFefe4dc))
            ){

                Text(
                    text = "Choose your icon",
                    modifier = Modifier.padding(top = 70.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp,
                    color = Color(0xFF000000)
                )
                Spacer(modifier = Modifier.height(1.dp))
                Column(
                    modifier= modifier
                        .fillMaxWidth()
                        .weight(2f)
                        .background(Color(0xFFede0d7))
                        .clip(shape = RoundedCornerShape(30.dp)),       //HELP
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    Image(painter = painterResource(R.drawable.girl_icon), contentDescription = "icon for app", modifier = modifier.size(65.dp).clickable {icon = R.drawable.girl_icon  })
                            Spacer(modifier = Modifier.height(20.dp))
                    Image(painter = painterResource(R.drawable.boy_iconn), contentDescription = "icon for app",  modifier = modifier.size(65.dp).clickable { icon = R.drawable.boy_iconn })
                }
               }
        }
        Column(
            modifier= modifier
                .fillMaxWidth()
                .weight(2f)
                .background(Color(0xFFE08601))
                .clip(shape = RoundedCornerShape(30.dp)),       //HELP
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ){
            Column(
                modifier= modifier
                    .background(Color(0xFFede0d7))
                    .padding(15.dp)
                    .clip(shape = RoundedCornerShape(20.dp)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ){
                Text(
                    text = "First name",
                    modifier = Modifier.padding(top = 20.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    color = Color(0xFF000000)
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(     //za email
                    value = firstname,
                    placeholder = { Text("Amina") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down)}),
                    singleLine = true,
                    onValueChange = {firstname = it},                 //email varijabla se updateuje zato imamo remember by state of
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
                    text = "Last name",
                    modifier = Modifier.padding(top = 20.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    color = Color(0xFF000000)
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(     //za email
                    value = lastname,
                    placeholder = { Text("Meric") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down)}),
                    singleLine = true,
                    onValueChange = {lastname = it},                 //email varijabla se updateuje zato imamo remember by state of
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
                    text = "Location",
                    modifier = Modifier.padding(top = 20.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    color = Color(0xFF000000)
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(     //za email
                    value = location,
                    placeholder = { Text("Sarajevo") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down)}),
                    singleLine = true,
                    onValueChange = {location = it},                 //email varijabla se updateuje zato imamo remember by state of
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
                    text = "Email",
                    modifier = Modifier.padding(top = 20.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    color = Color(0xFF000000)
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = email,
                    placeholder = { Text("aminameric7@gmail.com") },
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
                TextField(
                    value = password,
                    placeholder = { Text("1123") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.NumberPassword,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down)}),
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
            }
            Spacer(modifier = Modifier.height(12.dp))
            Button(
                onClick = {
                    val newUser = User(email = email, firstName = firstname, lastName = lastname, icon = icon, location = location, password = password)
                    myScope.launch{userViewModel.insert(newUser)}
                    LoggedUser.user = newUser
                    navController.navigate("Landing Page")
                },
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFede0d7))
            ) {
                Text("Sign up", fontSize = 20.sp, color = Color(0xFFE08601))
            }
        }
    }
}