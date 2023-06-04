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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ExitToApp
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
import com.example.flashcards1.data.Folder
import com.example.flashcards1.data.FolderViewModel
import com.example.flashcards1.data.Set
import com.example.flashcards1.data.SetViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun MyProfile(modifier: Modifier = Modifier, navController: NavHostController, folderViewModel: FolderViewModel, setViewModel: SetViewModel) {
    var mySets: List<Set> = listOf()
    var myFolders: List<Folder> = listOf()
    val myScope = CoroutineScope(Dispatchers.Default)


    fun getFoldersAndSets() {
        myScope.launch {
            if(LoggedUser.user != null) {
                myFolders = folderViewModel.getFolderByUserId(LoggedUser.user!!.userId)
                mySets = setViewModel.getSetByUser(LoggedUser.user!!.userId)

            }
        }
    }
    getFoldersAndSets()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(Color(0xFFefe4dc)),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment=Alignment.CenterVertically
        ) {
            Button(
                onClick = {navController.navigate("Landing Page")
                },
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFede0d7))
            ) {
                Image(
                    painter = painterResource(R.drawable.back_button),
                    contentDescription = "back button",
                    modifier = Modifier.size(25.dp)
                )
            }
            Image(
                painter = painterResource(R.drawable.logo_icon),
                contentDescription = "icon for app"
            )

                Icon(
                    imageVector = Icons.Rounded.ExitToApp,
                    contentDescription = null,
                    modifier

                        .height(100.dp)
                        .width(100.dp)
                        .padding(20.dp)
                        .clickable(onClick = {
                            LoggedUser.user = null
                            navController.navigate("Login")
                        })
                    ,
                    tint = Color.Black,
                )
            }

        Column(
            modifier= modifier
                .fillMaxWidth()
                .weight(0.6f)
                .background(Color(0xFFE08601)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ){
            LoggedUser.user?.let { painterResource(it.icon) }
                ?.let { Image(painter= it, contentDescription = "example_where icon will be placed") }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "${LoggedUser.user?.firstName} ${LoggedUser.user?.lastName}",
                modifier = Modifier.padding(top = 20.dp),
                textAlign = TextAlign.Left,
                fontSize = 20.sp,
                color = Color(0xFF000000))
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "${LoggedUser.user?.email}",
                modifier = Modifier.padding(top = 20.dp),
                textAlign = TextAlign.Left,
                fontSize = 20.sp,
                color = Color(0xFF000000))
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "${LoggedUser.user?.location}",
                modifier = Modifier.padding(top = 20.dp),
                textAlign = TextAlign.Left,
                fontSize = 20.sp,
                color = Color(0xFF000000))
            Spacer(modifier = Modifier.height(80.dp))
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .background(Color(0xFFE08601)),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment=Alignment.CenterVertically
            ){

                Spacer(modifier = Modifier.height(80.dp))

                Spacer(modifier= Modifier
                    .height(12.dp)
                    .background(Color.Gray))
                Column(
                    modifier= modifier
                        .background(Color(0xFFede0d7))
                        .clip(shape = RoundedCornerShape(30.dp)),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ){
                    Text(
                        text = "My Sets",
                        modifier = Modifier.padding(top = 2.dp),
                        textAlign = TextAlign.Center,
                        fontSize = 25.sp,
                        color = Color(0xFF000000)
                    )
                    Spacer(modifier=Modifier.height(8.dp))
                    LazyColumn{
                        items(mySets) {
                            item -> SetTemplate(set = item, navController = navController)
                        }
                    }
                }
            }

        }
    }

}
@Composable
fun SetTemplate(modifier: Modifier = Modifier, set: Set, navController: NavHostController) {
    Button(
        onClick = {
            LoggedUser.currentSet = set.setId
            navController.navigate("Cards")
                  },
        shape = RoundedCornerShape(50),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFE08601))
    ) {
        Text("${set.name}", fontSize = 18.sp, color = Color.White)
    }
}