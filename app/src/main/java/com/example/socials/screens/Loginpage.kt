package com.example.socials.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.socials.components.Input
import com.example.socials.components.InputPassword
import com.example.socials.components.PButton
import com.example.socials.services.login
import com.example.socials.types.LoginResult
import kotlinx.coroutines.launch

@Composable
fun Loginpage(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var mdp by remember { mutableStateOf("") }
    var state by remember { mutableStateOf("idle") }
    var error_message by remember { mutableStateOf("") }
    val scrollstate = rememberScrollState()

    val corountinescope = rememberCoroutineScope();

    LaunchedEffect(error_message) {
        if (error_message != "") {
            Toast.makeText(navController.context, error_message, Toast.LENGTH_SHORT).show()
            error_message=""
        }
    }
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
                Column(verticalArrangement = Arrangement.spacedBy(0.dp)) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(50.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Password")
                        TextButton(
                            onClick = { navController.navigate("forgotpwd") },
                        ) { Text("Mot de passe oublié ?") }
                    }
                    InputPassword(password = mdp) { mdp = it }
                }
                PButton(
                    label = if(state=="loading") "Loading.." else "Login",
                    type = "primary"
                ) {
                    corountinescope.launch {
                        state="loading"
                        when (val result = login(email = email, password = mdp)) {
                            is LoginResult.Ok -> {
                                state="success"
                                navController.navigate("forgotpwd")
                            }
                            is LoginResult.Bad -> {
                                state="bad_request"
                                var mess=""
                                result.data.message.map { data -> mess="$mess $data " }
                                error_message=mess
                            }
                            is LoginResult.Err -> {
                                state="error_mess"
                                error_message=result.data.message
                            }
                        }
                    }
                }
                PButton(label = "Sign up", type = "outline") { navController.navigate("signup") }
            }
        }
    }
}