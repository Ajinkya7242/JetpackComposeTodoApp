package com.example.todoappwithjetpack.model

import androidx.compose.ui.graphics.Color
import com.example.todoappwithjetpack.ui.theme.HighPriorityColor
import com.example.todoappwithjetpack.ui.theme.LowPriorityColor
import com.example.todoappwithjetpack.ui.theme.MediumPriorityColor
import com.example.todoappwithjetpack.ui.theme.NonePriorityColor

enum class Priority (val color: Color){
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}