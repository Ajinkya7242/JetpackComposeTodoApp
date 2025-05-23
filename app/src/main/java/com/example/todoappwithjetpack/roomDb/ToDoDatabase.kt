package com.example.todoappwithjetpack.roomDb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todoappwithjetpack.model.ToDoModel


@Database(entities = [ToDoModel::class], version = 1, exportSchema = false)
abstract class ToDoDatabase :RoomDatabase(){
    abstract fun toDoDao():ToDoDao
}