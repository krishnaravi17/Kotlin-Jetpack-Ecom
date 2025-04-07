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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ecommerceuniqueapp.R
import com.example.ecommerceuniqueapp.presentation.components.AppComponents
import com.example.ecommerceuniqueapp.presentation.theme.LightGray
import com.example.ecommerceuniqueapp.presentation.theme.LightGray4
import com.example.ecommerceuniqueapp.presentation.theme.MontserratFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShippingScreen(navController: NavController) {
    val openDialog = remember { mutableStateOf(false) }

    Scaffold(
        bottomBar = {
            AppComponents().ButtonLayout(
                buttonText = "Continue",
                onClick = {
                    openDialog.value = true
                }
            )
        }
    ) {

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
                        color = Color.White
                    )
                    .verticalScroll(rememberScrollState()),
            ) {
                AppComponents().HeaderLayout(navController, "Checkout")

                Spacer(modifier = Modifier.height(20.dp))

                Row() {
                    Text(
                        text = "Shipping",
                        textAlign = TextAlign.Left,
                        style = TextStyle(
                            fontSize = 18.sp,
                            color = LightGray4,
                            fontFamily = MontserratFontFamily,
                            fontWeight = FontWeight.Medium
                        )
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "$ 30",
                        textAlign = TextAlign.Right,
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = LightGray4,
                            fontFamily = MontserratFontFamily,
                            fontWeight = FontWeight.Medium
                        )
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
                Row() {
                    Text(
                        text = "Order",
                        textAlign = TextAlign.Left,
                        style = TextStyle(
                            fontSize = 18.sp,
                            color = LightGray4,
                            fontFamily = MontserratFontFamily,
                            fontWeight = FontWeight.Medium
                        )
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "$ 7000",
                        textAlign = TextAlign.Right,
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = LightGray4,
                            fontFamily = MontserratFontFamily,
                            fontWeight = FontWeight.Medium
                        )
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
                Row() {
                    Text(
                        text = "Total",
                        textAlign = TextAlign.Left,
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontFamily = MontserratFontFamily,
                            fontWeight = FontWeight.Medium
                        )
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "$ 7030",
                        textAlign = TextAlign.Right,
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = MontserratFontFamily,
                            fontWeight = FontWeight.Medium
                        )
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(color = LightGray)
                )

                if (openDialog.value) {
                    BasicAlertDialog(
                        onDismissRequest = {
                            openDialog.value = false
                        }
                    ) {
                        Surface(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp),
                            shape = MaterialTheme.shapes.large
                        ) {
                            Column(
                                modifier = Modifier.padding(16.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {

                                Image(painter = painterResource(id = R.drawable.alert_success_img),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .height(127.dp)
                                        .width(154.dp)
                                        .clickable {
                                            navController.navigateUp()
                                        })

                                Spacer(modifier = Modifier.height(12.dp))

                                Text(
                                    text = "Payment done successfully.",
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        fontFamily = MontserratFontFamily,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                )

                                //... AlertDialog content
                            }
                        }
                    }
                }

            }
        }
    }

}

