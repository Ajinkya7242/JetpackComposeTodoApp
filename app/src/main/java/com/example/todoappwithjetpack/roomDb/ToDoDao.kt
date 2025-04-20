package com.example.todoappwithjetpack.roomDb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.todoappwithjetpack.model.ToDoModel
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {

    @Query("SELECT * FROM table_todo ORDER BY id ASC")
    fun getAllTasks():Flow<List<ToDoModel>>

    @Query("SELECT * FROM table_todo WHERE id=:taskId")
    fun getSelectedTask(taskId:Int):Flow<ToDoModel>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(toDoModel: ToDoModel)

    @Update
    suspend fun updateTask(toDoModel: ToDoModel)

    @Delete
    suspend fun deleteTask(toDoModel: ToDoModel)

    @Query("DELETE FROM table_todo")
    suspend fun deleteAllTasks()

    @Query("SELECT * FROM table_todo WHERE title LIKE :searchQuery OR description LIKE :searchQuery")
    fun searchDatabase(searchQuery:String):Flow<List<ToDoModel>>

    @Query("SELECT * FROM table_todo ORDER BY CASE WHEN priority LIKE 'L%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'H%' THEN 3 END")
    fun searchByLowPriority():Flow<List<ToDoModel>>
}