package com.example.todoappwithjetpack.Repos

import com.example.todoappwithjetpack.model.ToDoModel
import com.example.todoappwithjetpack.roomDb.ToDoDao
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@ViewModelScoped
class TodoRepository @Inject constructor(private val todoDao: ToDoDao) {

    val getAllTasks: Flow<List<ToDoModel>> = todoDao.getAllTasks()
    val sortByLowPriority: Flow<List<ToDoModel>> = todoDao.searchByLowPriority()

    fun getSelectedTask(taskId: Int): Flow<ToDoModel> = todoDao.getSelectedTask(taskId)

    suspend fun addTask(toDoModel: ToDoModel) = todoDao.addTask(toDoModel)

    suspend fun updateTask(toDoModel: ToDoModel) = todoDao.updateTask(toDoModel)
    suspend fun deleteTask(toDoModel: ToDoModel) = todoDao.deleteTask(toDoModel)
    suspend fun deleteAllTasks() = todoDao.deleteAllTasks()

    fun searchDatabase(searchQuery: String): Flow<List<ToDoModel>> =
        todoDao.searchDatabase(searchQuery)

}