package com.example.todoappwithjetpack.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todoappwithjetpack.R
import com.example.todoappwithjetpack.model.Priority
import com.example.todoappwithjetpack.ui.theme.Typography


@Composable
fun PriorityItem(priority: Priority) {

    Row(
        verticalAlignment = Alignment.CenterVertically
    ){
        Canvas(modifier = Modifier.size(16.dp)){
            drawCircle(color = Color.Black,
                style = androidx.compose.ui.graphics.drawscope.Stroke(width = 1f,
                     )
            )

            drawCircle(
                color = priority.color, // fill color
                radius = size.minDimension / 2 - 2f
            )
        }

        Text(
            text = priority.name,
            style = Typography.titleSmall,
            modifier = Modifier.padding(start = 8.dp),
            color = Color.Black
        )
    }
}


@Composable
@Preview
fun showPreview(){
    PriorityItem(Priority.LOW)
}