package com.example.ecommerceuniqueapp.presentation.screens

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ecommerceuniqueapp.R
import com.example.ecommerceuniqueapp.domain.navigation.Routes
import com.example.ecommerceuniqueapp.presentation.components.AppComponents
import com.example.ecommerceuniqueapp.presentation.components.DropDownDemo
import com.example.ecommerceuniqueapp.presentation.theme.LightGray1
import com.example.ecommerceuniqueapp.presentation.theme.LightGray2
import com.example.ecommerceuniqueapp.presentation.theme.LightGray3
import com.example.ecommerceuniqueapp.presentation.theme.MontserratFontFamily

@Composable
fun PlaceOrderScreen(navController: NavController) {
    Scaffold(
        bottomBar = {
            BottomBarView(navController)
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
                Row {
                    AppComponents().HeaderLayout(navController, "Shopping Bag")
                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        painter = painterResource(id = R.drawable.ic_heart_outline),
                        contentDescription = null,
                        modifier = Modifier
                            .height(18.dp)
                            .width(18.dp)
                        //.padding(8.dp)

                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Box(modifier = Modifier.height(155.dp)) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        items(1 /*key={wish-> wish.id}*/) { wish ->
                            OrderItemsLayout()
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))
                Row() {
                    Image(
                        painter = painterResource(id = R.drawable.ic_coupon),
                        contentDescription = null,
                        modifier = Modifier
                            .height(20.dp)
                            .width(21.dp)

                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Apply Coupons",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = MontserratFontFamily,
                            fontWeight = FontWeight.Medium
                        ),
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "Select",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = MontserratFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            color = colorResource(id = R.color.red_color)
                        ),
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(color = Color.LightGray)
                )

                Spacer(modifier = Modifier.height(25.dp))
                Text(
                    text = "Order Payment Details", textAlign = TextAlign.Left,
                    style = TextStyle(
                        fontSize = 17.sp,
                        fontFamily = MontserratFontFamily,
                        fontWeight = FontWeight.Medium
                    )
                )

                Spacer(modifier = Modifier.height(25.dp))
                Row() {
                    Text(
                        text = "Order Amounts",
                        textAlign = TextAlign.Left,
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = MontserratFontFamily,
                        )
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "$ 7000.00",
                        textAlign = TextAlign.Right,
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = colorResource(id = R.color.black),
                            fontFamily = MontserratFontFamily,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Convenience",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = MontserratFontFamily,
                        )
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = "Know More",
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 12.sp,
                            color = colorResource(id = R.color.red_color),
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = MontserratFontFamily,
                        )
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "Apply Coupon",
                        textAlign = TextAlign.Right,
                        style = TextStyle(
                            fontSize = 12.sp,
                            color = colorResource(id = R.color.red_color),
                            fontFamily = MontserratFontFamily,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Delivery Fee",
                        textAlign = TextAlign.Left,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = MontserratFontFamily,
                        )
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "Free",
                        textAlign = TextAlign.Right,
                        style = TextStyle(
                            fontSize = 14.sp,
                            color = colorResource(id = R.color.red_color),
                            fontFamily = MontserratFontFamily,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                }

                Spacer(modifier = Modifier.height(25.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(color = Color.LightGray)
                )

                Spacer(modifier = Modifier.height(25.dp))
                Row() {
                    Text(
                        text = "Order Total",
                        textAlign = TextAlign.Left,
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = MontserratFontFamily,
                        )
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "$ 7000.00",
                        textAlign = TextAlign.Right,
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = colorResource(id = R.color.black),
                            fontFamily = MontserratFontFamily,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "EMI  Available ",
                        textAlign = TextAlign.Left,
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = MontserratFontFamily,
                        )
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = "Details",
                        textAlign = TextAlign.Right,
                        style = TextStyle(
                            fontSize = 12.sp,
                            color = colorResource(id = R.color.red_color),
                            fontFamily = MontserratFontFamily,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                }


            }
        }
    }

}

@Composable
fun OrderItemsLayout() {
    Box(modifier = Modifier
        .fillMaxSize()
        //.width(80.dp)
        //.height(155.dp)
        //.padding(bottom = 8.dp)
        .background(
            color = Color.White, shape = RoundedCornerShape(6.dp)
        )
        .clickable { }) {
        Column {
            Row() {
                Image(
                    painter = painterResource(id = R.drawable.cart_img),
                    contentDescription = null,
                    modifier = Modifier
                        .height(150.dp)
                        .width(125.dp)
                        .padding(8.dp)

                )
                Spacer(modifier = Modifier.width(8.dp))
                Column(
                    modifier = Modifier.padding(8.dp)
                ) {
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Women’s Casual Wear",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = MontserratFontFamily,
                            fontWeight = FontWeight.SemiBold
                        ),
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Checked Single-Breasted Blazer",
                        style = TextStyle(
                            fontSize = 13.sp,
                            fontFamily = MontserratFontFamily,
                        ),
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row {
                        Row(
                            modifier = Modifier
                                .height(28.dp)
                                .background(
                                    color = LightGray3, shape = RoundedCornerShape(4.dp)
                                ),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Size ",
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontFamily = MontserratFontFamily,
                                ),
                                modifier = Modifier.padding(5.dp)
                            )
                            DropDownDemo(listOf("S", "M", "L", "XL", "XXL"))
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Row(
                            modifier = Modifier
                                .height(28.dp)
                                .background(
                                    color = LightGray3, shape = RoundedCornerShape(4.dp)
                                ),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Qty ",
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontFamily = MontserratFontFamily,
                                ),
                                modifier = Modifier.padding(5.dp)
                            )
                            DropDownDemo(listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"))
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Row() {
                        Text(
                            text = "Delivery by ",
                            style = TextStyle(
                                fontSize = 13.sp,
                                fontFamily = MontserratFontFamily,
                            ),
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "10 Nov 2024",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontFamily = MontserratFontFamily,
                                fontWeight = FontWeight.SemiBold
                            ),
                        )
                    }
                }
            }
        }
    }

}

@Composable
fun BottomBarView(navController: NavController) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(90.dp)
        .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
        .border(
            width = 1.dp,
            color = LightGray1,
            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
        )
        .background(color = LightGray2)
        .padding(horizontal = 15.dp)
        .clickable { }) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "$ 7000.00",
                    textAlign = TextAlign.Left,
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.black),
                        fontFamily = MontserratFontFamily,
                        fontWeight = FontWeight.SemiBold
                    )
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "View Details",
                    textAlign = TextAlign.Left,
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = colorResource(id = R.color.red_color),
                        fontFamily = MontserratFontFamily,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            AppComponents().ButtonLayout(
                buttonText = "Proceed to Payment",
                onClick = {
                    navController.navigate(Routes.ShippingScreen.route)
                }
            )
        }
    }

}