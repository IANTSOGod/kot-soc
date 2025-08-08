package com.example.socials.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PButton(label: String, onClick: () -> Unit) {
    Button(
        onClick = onClick, modifier = Modifier
            .width(300.dp)
            .height(45.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(label)
    }
}