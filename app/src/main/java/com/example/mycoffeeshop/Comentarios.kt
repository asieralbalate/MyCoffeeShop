package com.example.mycoffeeshop

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.mycoffeeshop.ui.theme.MyDarkPink

@SuppressLint("RememberReturnType")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Comentarios(nombreCafeteria: String){
    var isMenuVisible by remember { mutableStateOf(false) }
    var showAddCommentButton by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopAppBar(
            title = {
                Text(text = nombreCafeteria, color = Color.White ,fontSize = 20.sp)
            },

            navigationIcon = {
                IconButton(
                    onClick = {
                    }
                ) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = null, tint = Color.White)
                }
            },
            actions = {
                IconButton(
                    onClick = {
                        isMenuVisible = true
                    }
                ) {
                    Icon(imageVector = Icons.Default.MoreVert, contentDescription = null, tint = Color.White)
                }
            },
            colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = MyDarkPink)
        )

        // Agregar el botón "add new comment" si showAddCommentButton es true
    }
}