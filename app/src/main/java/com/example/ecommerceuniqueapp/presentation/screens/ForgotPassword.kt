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
fun ForgotPasswordScreen(navController: NavController,) {

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
                AppComponents().HeadingText("Forgot \n" + "password?")

                Spacer(modifier = Modifier.height(30.dp))
                AppComponents().InputEditText(
                    hintText = "Enter you email address",
                    value = "",
                    onTextChanged = {},
                    R.drawable.mail_icon
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
                        AppComponents().NormalText(text = "*",  color = R.color.red_color)
                        AppComponents().NormalText(text = " We will send you a message to set or reset your new password")
                    }
                }

                Spacer(modifier = Modifier.height(40.dp))
                AppComponents().ButtonLayout(
                    buttonText = "Submit",
                    onClick = {
                        navController.navigate(Routes.SignUpScreen.route)
                    }
                )
            }
        }
    }

}

