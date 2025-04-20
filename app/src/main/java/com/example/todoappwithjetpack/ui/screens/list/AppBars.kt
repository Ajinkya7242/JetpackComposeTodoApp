package com.example.todoappwithjetpack.ui.screens.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
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
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.todoappwithjetpack.R
import com.example.todoappwithjetpack.model.Priority
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.ContentAlpha
import com.example.todoappwithjetpack.components.PriorityItem

@Composable
fun listAppBar() {
//    defaultListAppBar(
//        onSearchClicked = {},
//        onSortClicked = {},
//        onDeleteClicked = {}
//    )

    SearchAppBar(text = "Search",
        onTextChanged = {},
        onSearchClickd = {},
        onCloseClicked = {})

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
    text: String,
    onTextChanged: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchClickd: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp),
        tonalElevation = 4.dp,
       color = MaterialTheme.colorScheme.primary,
        content = {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = text,
                onValueChange = {
                    onTextChanged(it)
                },
                placeholder = {
                    Text(
                        "Search Task",
                        color = Color.White,
                    )
                },
                textStyle = TextStyle(
                    color = MaterialTheme.colorScheme.surfaceTint,
                    fontSize = MaterialTheme.typography.titleSmall.fontSize
                ),
                singleLine = true,
                leadingIcon = {
                    IconButton(
                        modifier = Modifier.alpha(ContentAlpha.disabled),
                        onClick = { }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "seach icon",
                            tint = Color.White,

                        )
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent, // 👈 important!
                    cursorColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
        }
    )
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
    SearchAppBar(text = "", onTextChanged = {}, onSearchClickd = {}, onCloseClicked = {})


}