package com.example.todoappwithjetpack.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoappwithjetpack.Repos.TodoRepository
import com.example.todoappwithjetpack.model.ToDoModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(private val repository: TodoRepository) : ViewModel() {

    private val _allTasks= MutableStateFlow<List<ToDoModel>>(emptyList())
    val allTasks: StateFlow<List<ToDoModel>> = _allTasks
    fun getAllTasks(){
        viewModelScope.launch {
            repository.getAllTasks.collect{
                _allTasks.value=it
            }
        }
    }
}