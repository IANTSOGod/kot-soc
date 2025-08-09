package com.example.socials.components

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Input(field: String,placeholder: String, onChange: (String) -> Unit) {
    OutlinedTextField(
        value = field,
        onValueChange = onChange,
        placeholder = { Text(placeholder) },
        modifier = Modifier.width(300.dp),
        shape = RoundedCornerShape(10.dp),
        singleLine = true,
    )
}