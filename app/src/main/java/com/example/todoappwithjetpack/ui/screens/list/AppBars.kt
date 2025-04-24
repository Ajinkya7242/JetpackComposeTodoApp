package com.example.todoappwithjetpack.ui.screens.list

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.todoappwithjetpack.R
import com.example.todoappwithjetpack.model.Priority
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.todoappwithjetpack.components.PriorityItem
import com.example.todoappwithjetpack.utility.SearchAppbarState
import com.example.todoappwithjetpack.utility.TrailingIconState
import com.example.todoappwithjetpack.viewmodels.SharedViewModel

@Composable
fun listAppBar(viewModel: SharedViewModel,
               searchAppBarState:SearchAppbarState,
               searchTextState:String
               ) {

    when(searchAppBarState){
        SearchAppbarState.CLOSED->{
            defaultListAppBar(
                onSearchClicked = {viewModel._searchAppBarState.value= SearchAppbarState.OPENED },
                onSortClicked = {},
                onDeleteClicked = {}
            )
        }
        else->{
            SearchAppBar(text = searchTextState,
                onTextChanged = {viewModel.serchTextState.value=it},
                onSearchClicked = {
                },
                onCloseClicked = {
                    viewModel._searchAppBarState.value=SearchAppbarState.CLOSED
                    viewModel.serchTextState.value=""})
        }
    }




}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun defaultListAppBar(
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit,
    onDeleteClicked: () -> Unit

) {
    TopAppBar(
        title = {
            Text(
                text = "Tasks",
                color = Color.White
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        actions = {
            listAppBarActions(
                onSearchClicked = onSearchClicked,
                onSortClicked = onSortClicked,
                onDeleteClicked = onDeleteClicked
            )
        }
    )
}


@Composable
fun listAppBarActions(
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit,
    onDeleteClicked: () -> Unit


) {
    searchAction(onSearchClicked = onSearchClicked)

    sortAction(onSortClicked = onSortClicked)
    DeleteAllAction(onDeleteClicked = onDeleteClicked)
}


@Composable
fun searchAction(
    onSearchClicked: () -> Unit
) {
    IconButton(
        onClick = {
            onSearchClicked()
        }
    ) {
        Icon(imageVector = Icons.Filled.Search, contentDescription = "Search", tint = Color.White)
    }
}

@Composable
fun sortAction(
    onSortClicked: (Priority) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    IconButton(onClick = { expanded = true }) {
        Icon(
            painter = painterResource(id = R.drawable.filter),
            contentDescription = "Sort",
            tint = Color.White,
            modifier = Modifier.size(25.dp)
        )
    }

    DropdownMenu(expanded = expanded, onDismissRequest = {
        expanded = false
    }) {
        DropdownMenuItem(
            onClick = {
                expanded = false
                onSortClicked(Priority.LOW)

            },
            text = {
                PriorityItem(Priority.LOW)
            },

            )

        DropdownMenuItem(
            onClick = {
                expanded = false
                onSortClicked(Priority.MEDIUM)

            },
            text = {
                PriorityItem(Priority.MEDIUM)
            },

            )

        DropdownMenuItem(
            onClick = {
                expanded = false
                onSortClicked(Priority.HIGH)
            },
            text = {
                PriorityItem(Priority.HIGH)
            },
        )

        DropdownMenuItem(
            onClick = {
                expanded = false
                onSortClicked(Priority.NONE)

            },
            text = {
                PriorityItem(Priority.NONE)
            },
        )
    }


}

@Composable
fun DeleteAllAction(
    onDeleteClicked: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    IconButton(onClick = { expanded = true }) {
        Icon(
            painter = painterResource(R.drawable.iv_more),
            contentDescription = "Delete Action",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )

        DropdownMenu(expanded = expanded,
            onDismissRequest = {
                expanded = false
            }) {
            DropdownMenuItem(
                onClick = {
                    expanded = false
                    onDeleteClicked()
                },
                text = {
                    Text(
                        text = "Delete All",
                        color = Color.Black,
                        modifier = Modifier.padding(10.dp)
                    )

                })
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchAppBar(
    text:String,
    onTextChanged: (String) ->Unit,
    onCloseClicked: () -> Unit,
    onSearchClicked: (String) -> Unit
){

    var trailingIconState:TrailingIconState by remember { mutableStateOf(TrailingIconState.READY_TO_DELETE) }
    Surface(
        modifier = Modifier.fillMaxWidth(),
        tonalElevation = 4.dp,
        color = MaterialTheme.colorScheme.primary,
    ) {
        TextField(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .background(color = Color.Transparent),
            value = text,
            onValueChange =onTextChanged,
            textStyle=TextStyle(
                color = Color.White,
                fontSize = MaterialTheme.typography.titleSmall.fontSize
            ),
            singleLine=true,
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = "Search Icon", tint = Color.White)
            },
            trailingIcon = {
                IconButton(onClick = {
                    when(trailingIconState){
                        TrailingIconState.READY_TO_DELETE->{
                            onTextChanged("")
                            trailingIconState=TrailingIconState.READY_TO_CLOSE
                        }
                        TrailingIconState.READY_TO_CLOSE->{
                            if(text.isNotEmpty()){
                                onTextChanged("")
                            }else{
                                onCloseClicked()
                                trailingIconState=TrailingIconState.READY_TO_DELETE
                            }
                        }
                    }
                }) {
                    Icon(painterResource(R.drawable.ic_close),
                        contentDescription = "close icon",
                        tint = Color.White, modifier = Modifier.size(25.dp),

                        )
                }

            },
            placeholder = {
                Text("Search Here ", color = Color.LightGray)
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                focusedTextColor = Color.White,
                disabledTextColor = Color.White,
                cursorColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearchClicked(text)
                }
            )
        )
    }
}


@Composable
@Preview
fun listAppBarPreview() {
    defaultListAppBar(
        onSearchClicked = {},
        onSortClicked = {},
        onDeleteClicked = {}

    )
}

@Composable
@Preview
fun seachBarPreview() {
    SearchAppBar(text = "", onTextChanged = {}, onSearchClicked = {}, onCloseClicked = {})


}