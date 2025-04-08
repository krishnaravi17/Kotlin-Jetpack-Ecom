package com.example.ecommerceuniqueapp.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Colors
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.ecommerceuniqueapp.R
import com.example.ecommerceuniqueapp.data.model.ProductModelRes
import com.example.ecommerceuniqueapp.domain.navigation.Routes
import com.example.ecommerceuniqueapp.presentation.theme.LightGray3
import com.example.ecommerceuniqueapp.presentation.theme.MontserratFontFamily
import kotlin.math.roundToInt

class AppComponents {

    @Composable
    fun NormalText(text: String, color: Int = R.color.grey_color) {
        Text(
            text = text,
            color = colorResource(id = color),
            textAlign = TextAlign.Left,
            style = TextStyle(
                fontSize = 12.sp, fontFamily = MontserratFontFamily
            )
        )
    }

    @Composable
    fun HeadingText(text: String) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 36.sp
            ),
            modifier = Modifier.padding(horizontal = 18.dp),
            fontWeight = FontWeight.Bold,
            overflow = TextOverflow.Ellipsis,
            fontFamily = MontserratFontFamily
        )
    }

    @Composable
    fun InputEditText(
        hintText: String = "Enter Value",
        value: String = "",
        onTextChanged: (String) -> Unit,
        drawableRes: Int = 0,
        isPassword: Boolean = false
    ) {

        TextField(value = value,
            visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None  ,
            onValueChange = onTextChanged,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .border(
                    BorderStroke(width = 1.dp, color = Color.LightGray),
                    shape = RoundedCornerShape(10.dp)
                ),
            shape = RoundedCornerShape(10.dp),
            leadingIcon = {
                if (drawableRes != 0) {
                    Image(
                        painter = painterResource(id = drawableRes),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                }
            },
            trailingIcon = {
                if (isPassword) Image(
                    painter = painterResource(id = R.drawable.password_eye_icon),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
            },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.LightGray.copy(alpha = 0.3f),
                unfocusedContainerColor = Color.LightGray.copy(alpha = 0.3f),
            ),
            placeholder = {
                Text(
                    text = hintText, style = TextStyle(
                        fontSize = 12.sp, fontFamily = MontserratFontFamily
                    )
                    //MaterialTheme.typography.bodySmall
                )
            })

    }


    @Composable
    fun InputTextOnlyBorder(
        userValue: String,
        onTextChanged: (String) -> Unit,
    ) {
        TextField(value = userValue,
            onValueChange = { onTextChanged },
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    BorderStroke(width = 1.dp, color = Color.LightGray),
                    shape = RoundedCornerShape(10.dp)
                ),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
            ),
            placeholder = {
                Text(
                    text = "Search for products", style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = MontserratFontFamily,
                        fontWeight = FontWeight.SemiBold
                    )
                    //MaterialTheme.typography.bodySmall
                )
            })
    }

    @Composable
    fun ButtonLayout(
        buttonText: String, onClick: () -> Unit, color: Int = R.color.red_color
    ) {
        Button(
            onClick = onClick,
            shape = RoundedCornerShape(8),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(55.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = color),

                )
            //colors = ButtonColors(containerColor = colorResource(id = R.color.btn_color))
        ) {
            Text(
                text = buttonText,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = MontserratFontFamily
                ),
            )

        }
    }

    @Composable
    fun ImageLayout(drawableRes: Int, onClick: () -> Unit) {
        Image(
            painter = painterResource(id = drawableRes),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp)
                .size(54.dp)
                .clip(CircleShape)
                .background(color = colorResource(id = R.color.light_red_color))
                .border(
                    BorderStroke(width = 1.dp, color = colorResource(id = R.color.red_color)),
                    shape = RoundedCornerShape(50.dp)
                )
                .clickable { onClick },
            contentScale = ContentScale.Inside
        )
    }

    @Composable
    fun ProductItem(product: ProductModelRes, onClick: () -> Unit) {
        var rating by remember { mutableFloatStateOf(3f) }

        Card(
            modifier = Modifier
                .padding(8.dp)
                .size(width = 164.dp, height = 245.dp)
                .clickable { onClick() },
            //elevation = CardDefaults.cardElevation(.5.dp),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.LightGray.copy(alpha = 0.2f))
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                AsyncImage(
                    model = product.image,
                    contentDescription = null,
                      modifier = Modifier
                          .fillMaxWidth()
                          .height(136.dp)
                )
                /*Image(
                    painter = painterResource(id = R.drawable.app_logo),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(136.dp)
                )*/

                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = product.title,//"Product name",
                    style = TextStyle(
                        fontSize = 16.sp, fontFamily = MontserratFontFamily
                    ),
                    modifier = Modifier.padding(horizontal = 8.dp),
                    fontWeight = FontWeight.Medium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    //text = "Autumn And Winter Casual cotton-padded jacket & Cool Stuff, Buy now Limited offer",
                    text = product.description,
                    style = TextStyle(
                        fontSize = 10.sp, fontFamily = MontserratFontFamily
                    ),
                    modifier = Modifier.padding(horizontal = 8.dp),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.size(5.dp))
                Text(
                    text = "$ ${product.price}",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = MontserratFontFamily,
                        fontWeight = FontWeight.Medium
                    ),
                    modifier = Modifier.padding(horizontal = 8.dp),
                )
                Spacer(modifier = Modifier.size(3.dp))
                Row(
                    verticalAlignment = Alignment.Bottom
                   // horizontalArrangement = Arrangement.Start
                ) {
                    StarRatingBar(maxStars = product.rating.rate.roundToInt(),
                        rating = rating, onRatingChanged = {
                            rating = it
                        })

                    Text(
                        text = product.rating.count.toString(),
                        style = TextStyle(
                            fontSize = 10.sp,
                            fontFamily = MontserratFontFamily,
                            color = Color.LightGray
                        ),
                        modifier = Modifier
                            .padding(bottom = 3.dp)
                            //.align(alignment = Alignment.CenterEnd),
                    )
                }
            }
        }
    }

    @Composable
    fun ProductGridLayout(productList: List<ProductModelRes>, navController: NavController) {
        Spacer(modifier = Modifier.size(8.dp))
        LazyVerticalGrid(
            GridCells.Fixed(2),
            //modifier = Modifier.height(300.dp)
        ) {
            items(productList) { product ->
                val isVisible = remember { mutableStateOf(false) }
                LaunchedEffect(true) {
                    isVisible.value = true
                }
                AnimatedVisibility(
                    visible = isVisible.value, enter = fadeIn() + expandVertically()
                ) {
                    AppComponents().ProductItem(product = product) {
                        //navController.navigate(Routes.ProductDetailScreen.route)
                        navController.navigate(Routes.ProductDetailScreen.createRoute(productId = product.id.toString()))
                    }
                }
            }
        }
    }

    @Composable
    fun HeaderLayout(navController: NavController, text: String) {
        Box(
            modifier = Modifier.height(44.dp)
        ) {
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(painter = painterResource(id = R.drawable.ic_back_ios),
                        contentDescription = null,
                        modifier = Modifier
                            .height(20.dp)
                            .width(10.dp)
                            .clickable {
                                navController.navigateUp()
                            })
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = text, style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = MontserratFontFamily,
                            fontWeight = FontWeight.SemiBold
                        ), modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(color = LightGray3)
                )
            }
        }
    }


}