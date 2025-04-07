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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
import com.example.ecommerceuniqueapp.presentation.components.SliderBanner
import com.example.ecommerceuniqueapp.presentation.components.StarRatingBar
import com.example.ecommerceuniqueapp.presentation.theme.LightGray1
import com.example.ecommerceuniqueapp.presentation.theme.LightGray2
import com.example.ecommerceuniqueapp.presentation.theme.LightPink
import com.example.ecommerceuniqueapp.presentation.theme.LightPink1
import com.example.ecommerceuniqueapp.presentation.theme.MontserratFontFamily
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ProductDetailScreen(navController: NavController) {
    //var products = remember { mutableStateOf<List<Product>>(emptyList()) }
    //sample list
    val notesList = listOf(
        "Drink water",
        "Read Books",
        "Eat fruits",
        "Go for a Walk",
        "Drink water1",
        "Read Books1",
        "Eat fruits1",
        "Go for a Walk1",
    )

    Scaffold {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(
                    color = LightGray2
                )
        ) {
            Column(
                modifier = Modifier
                    .padding(vertical = 20.dp, horizontal = 12.dp)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                AppComponents().HeaderLayout(navController, "")

                SliderBanner()

                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Size : 7UK",
                    textAlign = TextAlign.Left,
                    modifier = Modifier.padding(horizontal = 8.dp),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = MontserratFontFamily,
                        fontWeight = FontWeight.SemiBold
                    )
                )

                Spacer(modifier = Modifier.size(8.dp))
                Row {
                    repeat(4) {
                        SizeItem(size = "${it + 1}UK", isSelected = it == 0) {}
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Nike Sneakers",
                    textAlign = TextAlign.Left,
                    modifier = Modifier.padding(horizontal = 8.dp),
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = MontserratFontFamily,
                        fontWeight = FontWeight.SemiBold
                    )
                )

                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Vision Alta Men’s Shoes Size (All Colours)",
                    textAlign = TextAlign.Left,
                    modifier = Modifier.padding(horizontal = 8.dp),
                    style = TextStyle(
                        fontSize = 14.sp, fontFamily = MontserratFontFamily
                    )
                )

                Spacer(modifier = Modifier.size(8.dp))
                RatingBar()

                Spacer(modifier = Modifier.size(8.dp))
                AmountLayout()

                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Product Details",
                    textAlign = TextAlign.Left,
                    modifier = Modifier.padding(horizontal = 8.dp),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = MontserratFontFamily,
                        fontWeight = FontWeight.Medium
                    )
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = stringResource(R.string.description_dummy),
                    textAlign = TextAlign.Left,
                    modifier = Modifier.padding(horizontal = 8.dp),
                    style = TextStyle(
                        fontSize = 12.sp, fontFamily = MontserratFontFamily
                    )
                )

                Spacer(modifier = Modifier.height(8.dp))
                Row {
                    SizeItemWithRes("Nearest Store", R.drawable.location, {})
                    SizeItemWithRes("VIP", R.drawable.password_lock_icon, {})
                    SizeItemWithRes("Return Policy", R.drawable.return_icon, {})
                }

                Spacer(modifier = Modifier.height(10.dp))
                ButtonsLayout(navController)

                Spacer(modifier = Modifier.height(8.dp))
                DeliveryBannerLayout()

                Spacer(modifier = Modifier.height(8.dp))
                SimilarCompareLayout()

                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Similar To", style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = MontserratFontFamily,
                        fontWeight = FontWeight.SemiBold
                    ), modifier = Modifier.padding(horizontal = 8.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))
                FilterLayout()

                AppComponents().ProductGridLayout(notesList, navController)
            }
        }
    }
}

@Composable
private fun FilterLayout() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "282+ Items", style = TextStyle(
                fontSize = 18.sp,
                fontFamily = MontserratFontFamily,
                fontWeight = FontWeight.SemiBold
            ), modifier = Modifier.padding(horizontal = 8.dp)
        )
        Row() {
            Box(modifier = Modifier
                //.fillMaxSize()
                .height(24.dp)
                .width(60.dp)
                .background(
                    color = Color.White, shape = RoundedCornerShape(6.dp)
                )
                .clickable { }) {
                Row(
                    modifier = Modifier.align(alignment = Alignment.Center)
                ) {
                    Text(
                        text = "Sort",
                        style = TextStyle(
                            fontSize = 12.sp,
                        ),
                    )
                    Spacer(modifier = Modifier.width(3.dp))
                    Image(
                        painter = painterResource(id = R.drawable.ic_sort),
                        contentDescription = null,
                        modifier = Modifier
                            .height(16.dp)
                            .width(16.dp)
                    )


                }
            }
            Spacer(modifier = Modifier.width(5.dp))
            Box(modifier = Modifier
                //.fillMaxSize()
                .height(24.dp)
                .width(60.dp)
                .background(
                    color = Color.White, shape = RoundedCornerShape(6.dp)
                )
                .clickable { }) {
                Row(
                    modifier = Modifier.align(alignment = Alignment.Center)
                ) {
                    Text(
                        text = "Filter",
                        style = TextStyle(
                            fontSize = 12.sp,
                        ),
                    )
                    Spacer(modifier = Modifier.width(3.dp))
                    Image(
                        painter = painterResource(id = R.drawable.ic_filter),
                        contentDescription = null,
                        modifier = Modifier
                            .height(16.dp)
                            .width(16.dp)
                    )


                }
            }
        }
    }
}

@Composable
private fun DeliveryBannerLayout() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(60.dp)
            .background(
                color = LightPink1, shape = RoundedCornerShape(5.dp)
            )
    ) {
        Column(
            modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Delivery In", style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = MontserratFontFamily,
                    fontWeight = FontWeight.SemiBold
                ), modifier = Modifier.padding(horizontal = 16.dp)
            )
            Text(
                text = "1 within Hour", style = TextStyle(
                    fontSize = 21.sp,
                    fontFamily = MontserratFontFamily,
                    fontWeight = FontWeight.SemiBold
                ), modifier = Modifier.padding(horizontal = 16.dp)
            )
        }

    }
}

@Composable
private fun SimilarCompareLayout() {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 8.dp,
            )
    ) {
        Box(modifier = Modifier
            .padding(horizontal = 0.dp)
            //.fillMaxWidth()
            .height(42.dp)
            //.width(50.dp)
            .clip(RoundedCornerShape(8.dp))
            .border(
                width = 1.dp, color = LightGray1, shape = RoundedCornerShape(8.dp)
            )
            .padding(8.dp)
            .clickable { }) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.password_eye_icon),
                    contentDescription = null,
                    modifier = Modifier
                        //.fillMaxWidth()
                        .height(24.dp)
                        .width(24.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "View Similar",
                    style = TextStyle(
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                    ),
                )
            }
        }
        Spacer(modifier = Modifier.width(10.dp))
        Box(modifier = Modifier
            .padding(horizontal = 0.dp)
            .fillMaxWidth()
            .height(42.dp)
            //.width(50.dp)
            .clip(RoundedCornerShape(8.dp))
            .border(
                width = 1.dp, color = LightGray1, shape = RoundedCornerShape(8.dp)
            )
            .padding(8.dp)
            .clickable { }) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.compare_icon),
                    contentDescription = null,
                    modifier = Modifier
                        //.fillMaxWidth()
                        .height(24.dp)
                        .width(24.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Add to compare",
                    style = TextStyle(
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                    ),
                )
            }
        }

    }
}

@Composable
private fun AmountLayout() {
    Row {
        Text(
            text = "₹2,999",
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = MontserratFontFamily,
                color = LightGray1,
                textDecoration = TextDecoration.LineThrough
            ),
            modifier = Modifier.padding(start = 8.dp, end = 3.dp),
        )
        Text(
            text = "₹1,500",
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = MontserratFontFamily,

                ),
            modifier = Modifier.padding(horizontal = 3.dp),
        )
        Text(
            text = "50% Off",
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = MontserratFontFamily,
                color = LightPink,
                fontWeight = FontWeight.SemiBold
            ),
            modifier = Modifier.padding(horizontal = 3.dp),
        )
    }
}

@Composable
private fun RatingBar() {
    Box {
        var rating by remember { mutableFloatStateOf(3f) }
        StarRatingBar(maxStars = 5, rating = rating, onRatingChanged = {
            rating = it
        })

        Text(
            text = "35,980",
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = MontserratFontFamily,
                color = LightGray1,
                fontWeight = FontWeight.Medium
            ),
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .align(alignment = Alignment.CenterEnd),
        )
    }
}

@Composable
private fun ButtonsLayout(navController: NavController) {
    Row {
        Box() {
            Box(
                modifier = Modifier.padding(
                    top = 1.dp, start = 3.dp
                )
            ) {
                Text(
                    text = "   Go To Cart", textAlign = TextAlign.Center, style = TextStyle(
                        color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Medium
                    ), modifier = Modifier
                        .clickable(onClick = {
                            navController.navigate(Routes.AddToCartScreen.route)
                        })
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color(0xFF3F92FF), Color(0xFF0B3689)
                                )
                            ), shape = RoundedCornerShape(
                                topStart = 20.dp,
                                topEnd = 4.dp,
                                bottomStart = 20.dp,
                                bottomEnd = 4.dp
                            )
                        )
                        .padding(horizontal = 20.dp, vertical = 10.dp)
                        .width(120.dp)
                    //.height(36.dp),
                )
            }
            Image(
                painter = painterResource(id = R.drawable.add_to_cart_btn),
                contentDescription = null,
                modifier = Modifier
                    //.fillMaxWidth()
                    .height(42.dp)
                    .width(42.dp)
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Box() {
            Box(
                modifier = Modifier.padding(
                    top = 1.dp, start = 3.dp
                )
            ) {
                Text(
                    text = "   Buy Now", textAlign = TextAlign.Center, style = TextStyle(
                        color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Medium
                    ), modifier = Modifier
                        .clickable(onClick = {
                            navController.navigate(Routes.CheckOutScreen.route)
                        })
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color(0xFF71F9A9), Color(0xFF31B769)
                                )
                            ), shape = RoundedCornerShape(
                                topStart = 20.dp,
                                topEnd = 4.dp,
                                bottomStart = 20.dp,
                                bottomEnd = 4.dp
                            )
                        )
                        .padding(horizontal = 20.dp, vertical = 10.dp)
                        .width(120.dp)
                    //.height(36.dp),
                )
            }
            Image(
                painter = painterResource(id = R.drawable.buy_now_btn),
                contentDescription = null,
                modifier = Modifier
                    //.fillMaxWidth()
                    .height(42.dp)
                    .width(42.dp)
            )
        }
    }
}

@Composable
fun SizeItem(size: String, isSelected: Boolean, onClick: () -> Unit) {
    Box(modifier = Modifier
        .padding(horizontal = 4.dp)
        .height(32.dp)
        .width(50.dp)
        .clip(RoundedCornerShape(4.dp))
        .border(
            width = 1.dp, color = LightPink, shape = RoundedCornerShape(4.dp)
        )
        .background(
            if (isSelected) LightPink else Color.Transparent
        )
        .padding(8.dp)
        .clickable { onClick() }) {
        Text(
            text = size, style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
            ), modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun SizeItemWithRes(
    text: String, drawableRes: Int, onClick: () -> Unit
) {
    Box(modifier = Modifier
        .padding(horizontal = 4.dp)
        .height(24.dp)
        //.width(50.dp)
        .clip(RoundedCornerShape(4.dp))
        .border(
            width = 1.dp, color = LightGray1, shape = RoundedCornerShape(4.dp)
        )
        .padding(5.dp)
        .clickable { onClick() }) {
        Row(
            verticalAlignment = Alignment.Bottom
        ) {
            Image(
                painter = painterResource(id = drawableRes),
                contentDescription = null,
                modifier = Modifier
                    //.fillMaxWidth()
                    .height(24.dp)
            )
            Spacer(modifier = Modifier.width(3.dp))
            Text(
                text = text,
                style = TextStyle(
                    fontWeight = FontWeight.Medium, fontSize = 10.sp, color = LightGray1
                ),
                //modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}



