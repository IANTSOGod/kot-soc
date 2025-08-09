package com.example.socials.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StepCircle(
    stepNumber: Int,
    size: Dp = 40.dp,
    backgroundColor: Color = Color.Blue,
    textColor: Color = Color.White
) {
    Box(
        modifier = Modifier
            .size(size)
            .clip(CircleShape)            // pour avoir un cercle parfait
            .background(backgroundColor),
        contentAlignment = Alignment.Center // pour centrer le texte dans la Box
    ) {
        Text(
            text = stepNumber.toString(),
            color = textColor,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
    }
}
