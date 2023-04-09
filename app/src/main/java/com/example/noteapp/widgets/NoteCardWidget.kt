package com.example.noteapp.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.noteapp.data.NotesDataSource
import com.example.noteapp.models.NoteModel
import com.example.noteapp.screens.HomeScreen
import com.example.noteapp.util.dateFormatter
import java.time.format.DateTimeFormatter

@Composable
fun NoteCardWidget(
    modifier: Modifier = Modifier,
    note: NoteModel,
    onclick: (NoteModel) -> Unit,

    ) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 25.dp),
        shape = RoundedCornerShape(topEnd = 20.dp),
        color = MaterialTheme.colors.background,
        elevation = 6.dp,
        border = BorderStroke(0.5.dp, color = MaterialTheme.colors.onBackground),

        ) {
        Column(modifier = Modifier
            .clickable { onclick(note) }
            .padding(horizontal = 14.dp, vertical = 6.dp), horizontalAlignment = Alignment.Start) {
            Text(note.title, style = MaterialTheme.typography.subtitle2)
            Text(note.description, style = MaterialTheme.typography.subtitle1)
            Text(
                dateFormatter(note.entryDate.time),
                style = MaterialTheme.typography.subtitle2
            )
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    NoteCardWidget(note = NotesDataSource().loadNotes()[0], onclick = {})
}