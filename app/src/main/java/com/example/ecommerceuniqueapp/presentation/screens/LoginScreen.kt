package com.example.ecommerceuniqueapp.presentation.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.ecommerceuniqueapp.R
import com.example.ecommerceuniqueapp.data.api.NetworkResponse
import com.example.ecommerceuniqueapp.domain.navigation.Routes
import com.example.ecommerceuniqueapp.domain.viewmodel.LoginViewModel
import com.example.ecommerceuniqueapp.presentation.components.AppComponents
import com.example.ecommerceuniqueapp.presentation.theme.MontserratFontFamily

@Composable
fun LoginScreen(navController: NavController,
                viewModel: LoginViewModel = hiltViewModel()) {

    var btnText = "Login"

    val loginResults = viewModel.loginResult.observeAsState()

    when (val result = loginResults.value) {
        NetworkResponse.Loading ->{
            btnText = "Loading..."
            Log.i("NAVIGATION LOADING" ,">>>>>>")
        }
        is NetworkResponse.Success -> {
            LaunchedEffect(Unit) {
                btnText = "Navigating..."
                Log.i("NAVIGATION SUCCESS", ">>>>>>")
                navController.navigate(Routes.HomeScreen.route)
            }
        }//WeatherDetails(result.data, navigateToDetail)
        is NetworkResponse.Failure -> {
            btnText = "Error occurred!"
            //Text(text = result.msg)
            Log.i("NAVIGATION ERROR" ,">>>>>>")
            Toast.makeText(LocalContext.current, result.msg, Toast.LENGTH_SHORT).show()
        }

        null -> {}
    }


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
                AppComponents().HeadingText("Welcome \n" + "User!")

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

                Spacer(modifier = Modifier.height(10.dp))
                Box(modifier = Modifier
                    .align(Alignment.End)
                    .padding(horizontal = 16.dp)
                    .clickable {
                        navController.navigate(Routes.ForgotPasswordScreen.route)
                    }) {
                    AppComponents().NormalText(text = "Forgot password?", color = R.color.red_color)
                }

                Spacer(modifier = Modifier.height(40.dp))
                AppComponents().ButtonLayout(buttonText = btnText, onClick = {
                    viewModel.login("mor_2314", "83r5^_")
                    //navController.navigate(Routes.HomeScreen.route)
                })

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
                            text = "Create An Account",
                            color = colorResource(id = R.color.grey_color),
                            style = TextStyle(
                                fontSize = 14.sp, fontFamily = MontserratFontFamily
                            )
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            modifier = Modifier.clickable {
                                navController.navigate(Routes.SignUpScreen.route)
                            },
                            text = "Sign Up",
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

