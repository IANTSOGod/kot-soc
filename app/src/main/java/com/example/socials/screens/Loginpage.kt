package com.example.socials.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.socials.components.Input
import com.example.socials.components.InputPassword
import com.example.socials.components.PButton

@Composable
fun Loginpage(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var mdp by remember { mutableStateOf("") }
    val scrollstate = rememberScrollState()

    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .verticalScroll(scrollstate),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                Text("Login", fontSize = 20.sp)
                Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                    Text("Email")
                    Input(field = email, placeholder = "Enter your email here") { email = it }
                }
                Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                    Text("Password")
                    InputPassword(password = mdp) { mdp = it }
                }
                PButton(label = "Log in", type = "primary") { println("$email $mdp") }
                PButton(label = "Sign up", type = "outline") { navController.navigate("signup") }
            }
        }
    }
}