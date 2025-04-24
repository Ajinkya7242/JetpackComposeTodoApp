package com.example.todoappwithjetpack.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoappwithjetpack.Repos.TodoRepository
import com.example.todoappwithjetpack.model.ToDoModel
import com.example.todoappwithjetpack.utility.RequestState
import com.example.todoappwithjetpack.utility.SearchAppbarState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(private val repository: TodoRepository) : ViewModel() {

    private val _allTasks= MutableStateFlow<RequestState<List<ToDoModel>>>(RequestState.Idle)
    val _searchAppBarState: MutableState<SearchAppbarState> = mutableStateOf(SearchAppbarState.CLOSED)
    val serchTextState:MutableState<String> = mutableStateOf("")
    val allTasks: StateFlow<RequestState<List<ToDoModel>>> = _allTasks
    fun getAllTasks(){
        _allTasks.value=RequestState.Loading
        try{
            viewModelScope.launch {
                repository.getAllTasks.collect{
                    _allTasks.value=RequestState.Success(it)
                }
            }
        }catch (e:Exception){
            _allTasks.value= RequestState.Error(e)

        }

    }

    private val _selectedTask:MutableStateFlow<ToDoModel?> = MutableStateFlow(null)
    val selectedTask:StateFlow<ToDoModel?> =_selectedTask

    fun getSelectedTasks(taskId:Int){
        viewModelScope.launch {
            repository.getSelectedTask(taskId).collect{task->
                _selectedTask.value=task
            }
        }
    }
}