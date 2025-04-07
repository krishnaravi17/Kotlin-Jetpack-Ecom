package com.example.ecommerceuniqueapp.data.model

import android.graphics.drawable.Icon
import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem(
    val label : String,
    val icon : ImageVector,
    val badgeCount : Int,
)
