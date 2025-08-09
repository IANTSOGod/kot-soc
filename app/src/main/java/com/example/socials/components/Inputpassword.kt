package com.example.socials.components

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun InputPassword(password: String, onPasswordChange: (String) -> Unit) {

    var isshowed by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = password,
        onValueChange = onPasswordChange,
        placeholder = { Text("Enter your password") },
        modifier = Modifier.width(300.dp),
        shape = RoundedCornerShape(10.dp),
        singleLine = true,
        visualTransformation = if (isshowed) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = { isshowed = !isshowed }) {
                Icon(
                    imageVector = if (isshowed) Icons.Default.Close else Icons.Default.Done,
                    contentDescription = null
                )
            }
        },
    )
}
