package com.example.ecommerceuniqueapp.domain.navigation

sealed class Routes(val route: String) {
    object LoginScreen:Routes("loginscreen")
    object SignUpScreen:Routes("signupscreen")
    object ForgotPasswordScreen:Routes("forgotpassword")
    object HomeScreen:Routes("homescreen")
    //object ProductDetailScreen:Routes("productdetail")
    object ProductDetailScreen : Routes("productdetail/{productId}") {
        fun createRoute(productId: String) = "productdetail/$productId"
    }

    object CheckOutScreen:Routes("checkoutscreen")
    object AddToCartScreen:Routes("addtocartscreen")
    object PlaceOrderScreen:Routes("placeorderscreen")
    object ShippingScreen:Routes("shippingscreen")
}