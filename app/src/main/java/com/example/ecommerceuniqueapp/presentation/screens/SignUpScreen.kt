package com.example.ecommerceuniqueapp.presentation.screens

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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ecommerceuniqueapp.R
import com.example.ecommerceuniqueapp.domain.navigation.Routes
import com.example.ecommerceuniqueapp.presentation.components.AppComponents
import com.example.ecommerceuniqueapp.presentation.theme.MontserratFontFamily

@Composable
fun SignUpScreen(navController: NavController,) {

    Scaffold {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Column(
                modifier = Modifier
                    .padding(vertical = 20.dp, horizontal = 12.dp)
                    .fillMaxSize(),
            ) {
                Spacer(modifier = Modifier.height(12.dp))
                AppComponents().HeadingText("Create an \n" + "account")

                Spacer(modifier = Modifier.height(30.dp))
                AppComponents().InputEditText(
                    value = "Username or email", onTextChanged = {}, R.drawable.user_icon
                )

                Spacer(modifier = Modifier.height(30.dp))
                AppComponents().InputEditText(
                    value = "password",
                    onTextChanged = {},
                    drawableRes = R.drawable.password_lock_icon,
                    isPassword = true,
                )

                Spacer(modifier = Modifier.height(30.dp))
                AppComponents().InputEditText(
                    value = "Confirm Password",
                    onTextChanged = {},
                    drawableRes = R.drawable.password_lock_icon,
                    isPassword = true,
                )

                Spacer(modifier = Modifier.height(10.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Start)
                        .padding(horizontal = 16.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Start,
                    ) {
                        AppComponents().NormalText(text = "By clicking the ")
                        AppComponents().NormalText(text = "Register", color = R.color.red_color)
                        AppComponents().NormalText(text = " button, you agree to the offer")
                    }
                }

                Spacer(modifier = Modifier.height(40.dp))
                AppComponents().ButtonLayout(
                    buttonText = "Create Account",
                    onClick = {
                        navController.navigate(Routes.SignUpScreen.route)
                    }
                )

                Spacer(modifier = Modifier.height(50.dp))
                Box(
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    AppComponents().NormalText("- OR Continue with -")
                }

                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    AppComponents().ImageLayout(R.drawable.google, onClick = {})
                    AppComponents().ImageLayout(R.drawable.apple, onClick = {})
                    AppComponents().ImageLayout(R.drawable.facebook, onClick = {})
                }


                Spacer(modifier = Modifier.height(16.dp))
                Box(
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Row() {
                        Text(
                            text = "I Already Have an Account",
                            color = colorResource(id = R.color.grey_color),
                            style = TextStyle(
                                fontSize = 14.sp, fontFamily = MontserratFontFamily
                            )
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            modifier = Modifier.clickable { },
                            text = "Login",
                            color = colorResource(id = R.color.red_color),
                            textDecoration = TextDecoration.Underline,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = MontserratFontFamily
                            )
                        )
                    }
                }
            }
        }
    }

}

