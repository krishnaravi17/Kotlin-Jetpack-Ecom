package com.example.ecommerceuniqueapp.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ecommerceuniqueapp.R
import com.example.ecommerceuniqueapp.domain.navigation.Routes
import com.example.ecommerceuniqueapp.presentation.components.AppComponents
import com.example.ecommerceuniqueapp.presentation.theme.LightGray1
import com.example.ecommerceuniqueapp.presentation.theme.LightGray2
import com.example.ecommerceuniqueapp.presentation.theme.MontserratFontFamily

@Composable
fun CheckOutScreen(navController: NavController) {

    Scaffold {
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
                    .verticalScroll(rememberScrollState()),
            ) {
                AppComponents().HeaderLayout(navController,"Checkout")

                Spacer(modifier = Modifier.height(50.dp))
                Box(
                    modifier = Modifier
                        .height(100.dp)
                        .width(100.dp)
                        .align(Alignment.CenterHorizontally)

                ) {
                    Image(painter = painterResource(id = R.drawable.app_logo),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                            //.height(90.dp)
                            //.width(90.dp)
                            .clip(RoundedCornerShape(50.dp))
                            .border(
                                width = 1.dp, color = LightGray1, shape = RoundedCornerShape(50.dp)
                            )
                            .clickable {
                                //navController.navigateUp()
                            })
                    Image(painter = painterResource(id = R.drawable.ic_edit),
                        contentDescription = null,
                        modifier = Modifier
                            //.fillMaxSize()
                            .height(32.dp)
                            .width(32.dp)
                            .align(alignment = Alignment.BottomEnd)
                            .clickable {
                                //navController.navigateUp()
                            })
                }

                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Personal Details", textAlign = TextAlign.Left,
                    //modifier = Modifier.padding(horizontal = 8.dp),
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = MontserratFontFamily,
                        fontWeight = FontWeight.SemiBold
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))
                AppComponents().NormalText("Email Address")
                Spacer(modifier = Modifier.height(16.dp))
                AppComponents().InputTextOnlyBorder("krishna@gmail.com", {})

                Spacer(modifier = Modifier.height(16.dp))
                AppComponents().NormalText("Password")
                Spacer(modifier = Modifier.height(16.dp))
                AppComponents().InputTextOnlyBorder("***********", {})

                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .align(Alignment.End)
                        .clickable {
                            navController.navigate(Routes.ForgotPasswordScreen.route)
                        }
                ) {

                    Text(
                        modifier = Modifier.clickable {
                            navController.navigate(Routes.SignUpScreen.route)
                        },
                        text = "Forgot password?",
                        color = colorResource(id = R.color.red_color),
                        textDecoration = TextDecoration.Underline,
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            fontFamily = MontserratFontFamily
                        )
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(color = Color.LightGray)
                )

                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Business Address Details", textAlign = TextAlign.Left,
                    //modifier = Modifier.padding(horizontal = 8.dp),
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = MontserratFontFamily,
                        fontWeight = FontWeight.SemiBold
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))
                AppComponents().NormalText("Pincode")
                Spacer(modifier = Modifier.height(16.dp))
                AppComponents().InputTextOnlyBorder("522001", {})

                Spacer(modifier = Modifier.height(16.dp))
                AppComponents().NormalText("Address")
                Spacer(modifier = Modifier.height(16.dp))
                AppComponents().InputTextOnlyBorder("216, Dhurva Enclave, Ammu Guda, Hyderabad", {})

                Spacer(modifier = Modifier.height(16.dp))
                AppComponents().NormalText("City")
                Spacer(modifier = Modifier.height(16.dp))
                AppComponents().InputTextOnlyBorder("Hyderabad", {})

                Spacer(modifier = Modifier.height(16.dp))
                AppComponents().NormalText("State")
                Spacer(modifier = Modifier.height(16.dp))
                AppComponents().InputTextOnlyBorder("Andhra Pradesh", {})

                Spacer(modifier = Modifier.height(16.dp))
                AppComponents().NormalText("Country")
                Spacer(modifier = Modifier.height(16.dp))
                AppComponents().InputTextOnlyBorder("India", {})

                Spacer(modifier = Modifier.height(20.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(color = Color.LightGray)
                )

                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Bank Account Details", textAlign = TextAlign.Left,
                    //modifier = Modifier.padding(horizontal = 8.dp),
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = MontserratFontFamily,
                        fontWeight = FontWeight.SemiBold
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))
                AppComponents().NormalText("Bank Account Number")
                Spacer(modifier = Modifier.height(16.dp))
                AppComponents().InputTextOnlyBorder("204356XXXXXXX", {})

                Spacer(modifier = Modifier.height(16.dp))
                AppComponents().NormalText("Account Holder’s Name")
                Spacer(modifier = Modifier.height(16.dp))
                AppComponents().InputTextOnlyBorder("Ravi Krishna", {})

                Spacer(modifier = Modifier.height(16.dp))
                AppComponents().NormalText("IFSC Code")
                Spacer(modifier = Modifier.height(16.dp))
                AppComponents().InputTextOnlyBorder("SBIN00428", {})

                Spacer(modifier = Modifier.height(20.dp))
                AppComponents().ButtonLayout(
                    buttonText = "Save",
                    onClick = {
                        navController.navigate(Routes.PlaceOrderScreen.route)
                    }
                )

            }
        }
    }

}
