package com.example.flashcards1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.flashcards1.data.Folder
import com.example.flashcards1.data.FolderViewModel
import com.example.flashcards1.data.Set
import com.example.flashcards1.data.SetViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun LandingPage(modifier: Modifier = Modifier, navController: NavHostController, folderViewModel: FolderViewModel, setViewModel: SetViewModel) {
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
                text = "Public Sets",
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
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                LazyRow {
                    items(mySets) {
                        item ->  if (item.privacy) {
                            SetTemplate(set = item, navController = navController)
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(60.dp))
            Text(
                text = "My Sets",
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
                LazyRow {
                    items(mySets) {
                        item -> SetTemplate(set = item, navController = navController)
                    }
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
                        modifier = Modifier
                            .size(65.dp)
                            .clickable {
                                navController.navigate("Landing Page")
                            }
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
                        modifier = Modifier
                            .size(65.dp)
                            .clickable {
                                navController.navigate("Add")
                            }
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
                        modifier = Modifier
                            .size(65.dp)
                            .clickable {
                                navController.navigate("MyProfile")
                            }
                    )
                    Text("Profile", fontSize = 30.sp, color = Color.Black)
                }
            }
        }

    }
}





