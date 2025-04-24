package com.example.todoappwithjetpack.ui.screens.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Text
import com.example.todoappwithjetpack.R


@Composable
fun EmptyContentScreen(

) {

    Column(
        modifier = Modifier.fillMaxSize().background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(modifier = Modifier.size(120.dp),
            painter = painterResource(R.drawable.img_nodata),
            contentDescription = "No data",
            tint = Color.Gray)
        Text(text = "NO TASKS FOUND",
            color = Color.Gray,
            fontWeight = FontWeight.SemiBold,
            fontSize =  MaterialTheme.typography.bodyMedium.fontSize
        )
    }
}


@Preview
@Composable
fun previewScreen(){
    EmptyContentScreen(
    )
}