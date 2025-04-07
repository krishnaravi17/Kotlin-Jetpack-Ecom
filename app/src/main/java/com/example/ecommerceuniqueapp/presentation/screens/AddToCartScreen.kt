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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ecommerceuniqueapp.R
import com.example.ecommerceuniqueapp.presentation.components.AppComponents
import com.example.ecommerceuniqueapp.presentation.components.StarRatingBar
import com.example.ecommerceuniqueapp.presentation.theme.LightGray1
import com.example.ecommerceuniqueapp.presentation.theme.LightGray2
import com.example.ecommerceuniqueapp.presentation.theme.MontserratFontFamily

@Composable
fun AddToCartScreen(navController: NavController) {

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
                //.verticalScroll(rememberScrollState()),
            ) {
                AppComponents().HeaderLayout(navController, "Add To Cart")

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_location),
                        contentDescription = null,
                        modifier = Modifier
                            //.fillMaxWidth()
                            .height(15.dp)
                            .width(15.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "Delivery Address",
                        style = TextStyle(
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 14.sp,
                        ),
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))
                Row {
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .height(80.dp)
                        //.width(240.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(6.dp),
                        )
                        .clickable { }) {
                        Column(
                            modifier = Modifier.padding(8.dp)
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.Top
                            ) {
                                Text(
                                    text = "Address :",
                                    style = TextStyle(
                                        fontSize = 12.sp, fontWeight = FontWeight.Medium
                                    ),
                                )
                                Spacer(
                                    Modifier
                                        .fillMaxWidth()
                                        .weight(1f)
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.ic_address_edit),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .height(18.dp)
                                        .width(18.dp)
                                )


                            }
                            Spacer(modifier = Modifier.height(10.dp))
                            AppComponents().NormalText(text = "216 St Paul's Rd, London N1 2LL, UK\nContact :  +44-784232")
                        }
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Box(modifier = Modifier
                        .width(80.dp)
                        .height(80.dp)
                        .background(
                            color = Color.White, shape = RoundedCornerShape(6.dp)
                        )
                        .clickable { }) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_add_circle),
                            contentDescription = null,
                            modifier = Modifier
                                .height(30.dp)
                                .width(30.dp)
                                .align(alignment = Alignment.Center)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Shopping List",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = MontserratFontFamily,
                        fontWeight = FontWeight.SemiBold
                    ),
                )

                Spacer(modifier = Modifier.height(12.dp))
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        //.height(500.dp)
                        .padding(it)
                ) {
                    items(2 /*key={wish-> wish.id}*/) { wish ->
                        AddToCardView()
                    }
                }
            }
        }
    }
}

@Composable
fun AddToCardView() {
    Box(modifier = Modifier
        .fillMaxWidth()
        //.width(80.dp)
        .height(200.dp)
        .padding(bottom = 8.dp)
        .background(
            color = Color.White, shape = RoundedCornerShape(6.dp)
        )
        .clickable { }) {
        Column {
            Row() {
                Image(
                    painter = painterResource(id = R.drawable.app_logo),
                    contentDescription = null,
                    modifier = Modifier
                        .height(125.dp)
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
                    Row(){
                        Text(
                            text = "Variations:",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = MontserratFontFamily,
                                fontWeight = FontWeight.Medium
                            ),
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        variationViewLayout("Black")
                        Spacer(modifier = Modifier.width(5.dp))
                        variationViewLayout("Red")
                    }

                    Spacer(modifier = Modifier.size(8.dp))
                    RatingBar()

                    Spacer(modifier = Modifier.size(8.dp))
                    Row(){
                        Box(modifier = Modifier
                            .height(29.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .border(
                                width = 1.dp, color = LightGray1, shape = RoundedCornerShape(4.dp)
                            )
                            .padding(start = 8.dp, end = 8.dp, top = 5.dp, bottom = 5.dp)
                        ) {
                            Text(
                                text = "$ 48.00",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontFamily = MontserratFontFamily,
                                    fontWeight = FontWeight.SemiBold
                                ),
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Column(
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(
                                text = "upto 33% off  ",
                                style = TextStyle(
                                    fontSize = 8.sp,
                                    fontFamily = MontserratFontFamily,
                                    color = Color.Red,
                                    fontWeight = FontWeight.Medium
                                ),
                            )
                            Text(
                                text = "$ 64.00",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontFamily = MontserratFontFamily,
                                    color = LightGray1,
                                    fontWeight = FontWeight.Medium,
                                    textDecoration = TextDecoration.LineThrough
                                ),
                                //modifier = Modifier.padding(start = 8.dp, end = 3.dp),
                            )

                        }
                    }


                }
            }

            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(color = Color.LightGray)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp)
            ) {
                Text(
                    text = "Total Order(1):",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = MontserratFontFamily,
                        fontWeight = FontWeight.Medium
                    ),
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "$ 48.00",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = MontserratFontFamily,
                        fontWeight = FontWeight.SemiBold
                    ),
                )
            }


        }
    }

}

@Composable
private fun variationViewLayout(text: String) {
    Box(modifier = Modifier
        .height(17.dp)
        .clip(RoundedCornerShape(4.dp))
        .border(
            width = 1.dp, color = LightGray1, shape = RoundedCornerShape(4.dp)
        )
        .padding(start = 5.dp, end = 5.dp, top = 2.dp, bottom = 2.dp)
        .clickable { }) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 10.sp,
                fontFamily = MontserratFontFamily,
                fontWeight = FontWeight.Medium
            ),
        )
    }
}

@Composable
private fun RatingBar() {
    Row {
        var rating by remember { mutableFloatStateOf(3f) }
        Text(
            text = "4.8",
            style = TextStyle(
                fontSize = 12.sp,
                fontFamily = MontserratFontFamily,
                fontWeight = FontWeight.Medium
            ),
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .align(alignment = Alignment.CenterVertically)

        )

        StarRatingBar(maxStars = 5,
            rating = rating,
            onRatingChanged = {
            rating = it
        })


    }
}
