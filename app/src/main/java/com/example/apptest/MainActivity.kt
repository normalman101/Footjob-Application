package com.example.apptest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.apptest.ui.theme.FirstAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            FirstAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    List(label = "Имя", modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Input(label: String, inputText: MutableState<String>, modifier: Modifier) {
    Column(modifier = modifier.padding(0.dp),
        verticalArrangement = Arrangement.spacedBy(0.dp)) {
        Text(
            text = label,
            modifier = modifier,
            color = colorResource(R.color.purple_700)
        )
        Text(
            text = label,
            modifier = modifier,
            color = colorResource(R.color.purple_700)
        )
        TextField(
            value = inputText.value,
            onValueChange = { text -> inputText.value = text },
            modifier = modifier
        )
    }
}

@Composable
fun List(label: String, modifier: Modifier = Modifier) {
    val name_buffer = remember { mutableStateOf("") }
    val surname_buffer = remember { mutableStateOf("") }
    val patronymic_buffer = remember { mutableStateOf("") }
    val message = remember { mutableStateOf("") }
    val messages = remember { mutableStateListOf<String>() }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var show_list = Button(
            content = { Text(text = "Показать список") },
            modifier = modifier,
            onClick = {}
        )

        var add_person = Button(
            content = { Text(text = "Добавить человека") },
            modifier = modifier,
            onClick = {
                message.value =
                    surname_buffer.value + " " + name_buffer.value + " " + patronymic_buffer.value
                messages.add(message.value)
            }
        )

        var surnameInputTest = Input("Фамилия", surname_buffer, modifier)

        var surnameInput = TextField(
            value = surname_buffer.value,
            onValueChange = { text -> surname_buffer.value = text },
            modifier = modifier
                .width(300.dp)
        )

        var nameInput = TextField(
            value = name_buffer.value,
            onValueChange = { text -> name_buffer.value = text },
            modifier = modifier
        )

        var patronymicInput = TextField(
            value = patronymic_buffer.value,
            onValueChange = { text -> patronymic_buffer.value = text },
            modifier = modifier
        )

        LazyColumn(modifier = modifier.fillMaxWidth()) {
            item { Row() { Text(text = "TEXT") } }
            items(messages) { msg -> Text(text = msg) }
        }
    }
}
