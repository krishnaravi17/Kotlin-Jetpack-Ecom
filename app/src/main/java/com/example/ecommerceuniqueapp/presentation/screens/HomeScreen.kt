package com.example.ecommerceuniqueapp.presentation.screens

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
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ecommerceuniqueapp.R
import com.example.ecommerceuniqueapp.data.model.NavItem
import com.example.ecommerceuniqueapp.presentation.components.AppComponents
import com.example.ecommerceuniqueapp.presentation.theme.LightGray2
import com.example.ecommerceuniqueapp.presentation.theme.LightPink1
import com.example.ecommerceuniqueapp.presentation.theme.MontserratFontFamily

@Composable
fun HomeScreen(navController: NavController) {
    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

    val navItemList = listOf(
        NavItem("Home", Icons.Default.Home, 0),
        NavItem("Wishlist", Icons.Default.FavoriteBorder, 5),
        NavItem("Search", Icons.Default.Search, 0),
        NavItem("Setting", Icons.Default.Settings, 1)
    )

    Scaffold(topBar = {},
        bottomBar = {
            NavigationBar {
                navItemList.forEachIndexed { index, navItem ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index
                        },
                        icon = {
                            BadgedBox(badge = {
                                if (navItem.badgeCount > 0)
                                    Badge() {
                                        Text(text = navItem.badgeCount.toString())
                                    }
                            }) {
                                Icon(imageVector = navItem.icon, contentDescription = "Icon")
                            }

                        },
                        label = {
                            Text(text = navItem.label)
                        }
                    )
                }
            }
        }) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {

            Column(
                modifier = Modifier
                    .padding(vertical = 20.dp, horizontal = 20.dp)
                    .fillMaxSize()
                    .background(
                        color = LightGray2
                    )
                //.verticalScroll(rememberScrollState()),
            ) {
                HomeScreenHeader("Home")
                ContentScreen(selectedIndex, navController)

            }

        }
    }

}

@Composable
fun HomeScreenInnerLayout(navController: NavController) {
    AppComponents().ProductGridLayout(
        listOf(
            "Drink water",
            "Read Books",
            "Eat fruits",
            "Go for a Walk",
            "Drink water1",
            "Read Books1",
            "Eat fruits1",
            "Go for a Walk1",
        ), navController
    )
}

@Composable
fun HomeScreenHeader(text: String) {
    Box(
        modifier = Modifier.height(44.dp)
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(painter = painterResource(id = R.drawable.ic_humberger),
                    contentDescription = null,
                    modifier = Modifier
                        .height(32.dp)
                        .width(32.dp)
                        .clickable {
                            //navController.navigateUp()
                        })
                Spacer(modifier = Modifier.width(8.dp))
                Row() {
                    Image(painter = painterResource(id = R.drawable.app_logo),
                        contentDescription = null,
                        modifier = Modifier
                            .height(32.dp)
                            .width(38.dp)
                            .clickable {
                                //navController.navigateUp()
                            })
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = stringResource(id = R.string.app_name), style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = MontserratFontFamily,
                            fontWeight = FontWeight.SemiBold
                        ), modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
                Image(painter = painterResource(id = R.drawable.ic_profile),
                    contentDescription = null,
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                        .clickable {
                            //navController.navigateUp()
                        })

            }
            Spacer(modifier = Modifier.height(12.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(color = LightPink1)
            )
        }
    }
}

@Composable
fun ContentScreen(selectedIndex: Int, navController: NavController) {
    when (selectedIndex) {
        0 -> HomeScreenInnerLayout(navController)
        1 -> HomeScreenInnerLayout(navController)
        2 -> HomeScreenInnerLayout(navController)
        3 -> HomeScreenInnerLayout(navController)

    }
}


