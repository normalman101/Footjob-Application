package com.example.apptest

import android.R
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup

@Composable
fun View(modifier: Modifier) {
    val nameBuffer = remember { mutableStateOf("") }
    val surnameBuffer = remember { mutableStateOf("") }
    val patronymicBuffer = remember { mutableStateOf("") }
    val birthdayBuffer = remember { mutableStateOf("") }
    val user = remember { mutableStateOf("") }
    val users = remember { mutableStateListOf<String>() }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        Button(
//            content = { Text(text = "Показать список") },
//            modifier = modifier.width(300.dp),
//            onClick = {},
//            colors = ButtonDefaults.buttonColors(
//                containerColor = Color.White,
//                contentColor = Black
//            ),
//            border = BorderStroke(2.dp, Black),
//            shape = RoundedCornerShape(8.dp)
//        )

        Button(
            content = { Text(text = "Добавить человека") },
            modifier = modifier.width(300.dp),
            onClick = {
                user.value =
                    "ФИО: ${surnameBuffer.value} ${nameBuffer.value} ${patronymicBuffer.value}\nДата рождения: ${birthdayBuffer.value}"
                users.add(user.value)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Black
            ),
            border = BorderStroke(2.dp, Black),
            shape = RoundedCornerShape(8.dp)

        )


        TextField(
            value = surnameBuffer.value,
            onValueChange = { text -> surnameBuffer.value = text },
            modifier = modifier.width(300.dp),
            placeholder = { Text(text = "Фамилия", color = Color.Gray) },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedTextColor = Black,
                cursorColor = Black
            )
        )

        TextField(
            value = nameBuffer.value,
            onValueChange = { text -> nameBuffer.value = text },
            modifier = modifier.width(300.dp),
            placeholder = { Text(text = "Имя", color = Color.Gray) },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedTextColor = Black,
                cursorColor = Black
            )

        )

        TextField(
            value = patronymicBuffer.value,
            onValueChange = { text -> patronymicBuffer.value = text },
            modifier = modifier.width(300.dp),
            placeholder = { Text(text = "Отчество", color = Color.Gray) },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedTextColor = Black,
                cursorColor = Black
            )

        )

        TextField(
            value = birthdayBuffer.value,
            onValueChange = { text -> birthdayBuffer.value = text },
            modifier = modifier.width(300.dp),
            placeholder = { Text(text = "Дата рождения (ДД.ММ.ГГГГ)", color = Color.Gray) },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedTextColor = Black,
                cursorColor = Black
            )
        )


        HorizontalDivider(modifier = modifier, thickness = 2.dp, color = Color.Gray)


        Text(text = "Список пользователей")


        LazyColumn(
            modifier = modifier
                .fillMaxWidth()
                .border(
                    width = 2.dp,
                    color = Color.Gray,
                    shape = RectangleShape
                )
                .padding(4.dp)
                .height(150.dp)
        ) {
            items(users) { element -> Text(text = element) }
        }
    }
}