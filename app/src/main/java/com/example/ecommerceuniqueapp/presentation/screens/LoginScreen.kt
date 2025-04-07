package com.example.ecommerceuniqueapp.presentation.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.ecommerceuniqueapp.R
import com.example.ecommerceuniqueapp.data.api.NetworkResponse
import com.example.ecommerceuniqueapp.domain.navigation.Routes
import com.example.ecommerceuniqueapp.domain.viewmodel.LoginViewModel
import com.example.ecommerceuniqueapp.presentation.components.AppComponents
import com.example.ecommerceuniqueapp.presentation.components.CustomLoader
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
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

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
                    value = username,
                    hintText = "Username or email",
                    onTextChanged = {
                        username = it
                    },
                    drawableRes = R.drawable.user_icon,
                )

                Spacer(modifier = Modifier.height(30.dp))
                AppComponents().InputEditText(
                    hintText = "Password",
                    value = password,
                    onTextChanged = {
                        password = it
                    },
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
                if (btnText == "Loading...") CustomLoader(modifier = Modifier.align(Alignment.CenterHorizontally))
                else Box(
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                AppComponents().ButtonLayout(buttonText = "Login", onClick = {
                    //viewModel.login("mor_2314", "83r5^_")
                    if(username.isEmpty() || password.isEmpty()){
                        viewModel.login(username, password)
                   // Toast.makeText(LocalContext.current, "Please enter username and password", Toast.LENGTH_SHORT).show()
                    }else{
                        viewModel.login(username, password)
                    }
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



