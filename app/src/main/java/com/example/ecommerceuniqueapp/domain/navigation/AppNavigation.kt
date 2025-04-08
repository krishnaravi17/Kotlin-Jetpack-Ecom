package com.example.ecommerceuniqueapp.domain.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ecommerceuniqueapp.presentation.screens.LoginScreen
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ecommerceuniqueapp.presentation.screens.AddToCartScreen
import com.example.ecommerceuniqueapp.presentation.screens.CheckOutScreen
import com.example.ecommerceuniqueapp.presentation.screens.ForgotPasswordScreen
import com.example.ecommerceuniqueapp.presentation.screens.HomeScreen
import com.example.ecommerceuniqueapp.presentation.screens.PlaceOrderScreen
import com.example.ecommerceuniqueapp.presentation.screens.ProductDetailScreen
import com.example.ecommerceuniqueapp.presentation.screens.ShippingScreen
import com.example.ecommerceuniqueapp.presentation.screens.SignUpScreen

@Composable
fun AppNavigationGraph(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.HomeScreen.route ){
        composable(Routes.LoginScreen.route){
            LoginScreen(navController)
        }
        composable(Routes.SignUpScreen.route){
            SignUpScreen(navController)
        }
        composable(Routes.ForgotPasswordScreen.route){
            ForgotPasswordScreen(navController)
        }
        composable(Routes.HomeScreen.route){
            HomeScreen(navController)
        }
        /*composable(Routes.ProductDetailScreen.route){
            ProductDetailScreen(navController)
        }*/
        composable(
            route = Routes.ProductDetailScreen.route,
            arguments = listOf(navArgument("productId") { type = NavType.StringType })
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId")
            ProductDetailScreen(navController, productId = productId ?: "")
        }
        composable(Routes.CheckOutScreen.route){
            CheckOutScreen(navController)
        }
        composable(Routes.AddToCartScreen.route){
            AddToCartScreen(navController)
        }
        composable(Routes.PlaceOrderScreen.route){
            PlaceOrderScreen(navController)
        }
        composable(Routes.ShippingScreen.route){
            ShippingScreen(navController)
        }
    }
}