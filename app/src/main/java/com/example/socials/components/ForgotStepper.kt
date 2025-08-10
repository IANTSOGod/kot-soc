package com.example.socials.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ForgotStepper(index: Int) {
    var email by remember { mutableStateOf("") }

    when (index) {
        0 -> {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                    Text("Email")
                    Input(field = email, placeholder = "Enter your email here") { email = it }
                }
                Box(
                    modifier = Modifier
                        .background(Color.Gray)
                        .width(300.dp)
                        .height(100.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    Text("Entrer l'email de votre compte", color = Color.White)
                }
            }

        }

        1 -> {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {

            }
        }
    }

}