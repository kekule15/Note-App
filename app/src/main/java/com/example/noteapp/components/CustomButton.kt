package com.example.noteapp.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    title: String,
    textStyle: TextStyle,

    shape: Shape = CircleShape,
    onclick: () -> Unit = {},
) {
    Button(onClick = onclick, modifier = modifier, shape = shape) {
        Text(text = title, style = textStyle)
    }
}