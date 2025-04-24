package com.example.todoappwithjetpack.ui.screens.list

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Text
import com.example.todoappwithjetpack.model.Priority
import com.example.todoappwithjetpack.model.ToDoModel
import com.example.todoappwithjetpack.utility.RequestState


@Composable
fun ListContent(
    toDoTasks: RequestState<List<ToDoModel>>,
    navigateToTaskScreen: (taskId: Int) -> Unit,
    modifier: Modifier
) {
    if(toDoTasks is RequestState.Success){
        if(toDoTasks.data.isEmpty()){
            EmptyContentScreen()
        }else{
            DisplayTasks(toDoTasks.data,navigateToTaskScreen,modifier)
        }
    }

}

@Composable
fun DisplayTasks(
    toDoTasks: List<ToDoModel>,
    navigateToTaskScreen: (taskId: Int) -> Unit,
    modifier: Modifier
){
    LazyColumn(modifier = modifier) {
        items(items = toDoTasks,
            key = {task->task.id},
        ){
            TaskItem(toDoTask = it,navigateToTaskScreen=navigateToTaskScreen)
        }
    }
}

@Composable
fun TaskItem(
    toDoTask:ToDoModel,
    navigateToTaskScreen:(taskId:Int)->Unit
){
    Surface(
        modifier = Modifier.fillMaxWidth().padding(10.dp),
        color = Color.LightGray,
        shadowElevation = 5.dp,
        shape = RoundedCornerShape(10.dp),
        onClick = {
            navigateToTaskScreen(toDoTask.id)
        }
    ) {

        Column(
            modifier = Modifier.padding(20.dp).fillMaxWidth()
        ) {
            Row {
                Text(
                    modifier = Modifier.weight(9f),
                    text = toDoTask.title,
                    color = Color.Black,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Box(modifier = Modifier.fillMaxWidth().weight(1f)){
                    Canvas(
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .width(20.dp)
                            .height(20.dp)
                    ) {
                        drawCircle(color = toDoTask.priority.color)
                    }
                }
            }

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                thickness = 1.dp,
                color = Color.Black
            )

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = toDoTask.description,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}


@Preview
@Composable
fun previewFunc(){
    TaskItem(
        toDoTask = ToDoModel(id = 0, title = "sdssd",
            description = "sdsd", priority = Priority.HIGH),
        navigateToTaskScreen ={}
    )
}