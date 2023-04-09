package com.example.noteapp.components

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Colors
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import kotlin.math.max

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    text: String,
    label: String,
    maxLine: Int = 1,
    onTextChange: (String) -> Unit,
    onImeAction: () -> Unit = {},

    ) {
    val keyboardController = LocalSoftwareKeyboardController.current
    TextField(
        value = text, onValueChange = onTextChange,
        label = {
            Text(label)

        },
        maxLines = maxLine,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent
        ),
        modifier = modifier,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                onImeAction()
                keyboardController?.hide()
            }
        )
    )
}