package com.example.todoappwithjetpack.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.todoappwithjetpack.utility.AppConstants

@Entity(tableName = AppConstants.DATABASE_TABLE)
data class ToDoModel(
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val title:String,
    val description:String,
    val priority: Priority

)