package com.example.socials.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.socials.components.Input
import com.example.socials.components.PButton

@Composable
fun ForgotPassword(navController: NavController) {

    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            GetComponents(navController)
        }
    }
}

@Composable
fun GetComponents(navController: NavController){
    var email by remember { mutableStateOf("") }
    var index by remember { mutableIntStateOf(0) }

    if(index==0){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text("Recherche de compte")
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
            PButton(label = "Continuer", type = "primary") { index=index+1 }
            PButton(label = "Cancel", type = "outline") { navController.navigate("login") }
        }
    }
    else if(index==1){
        Text("Envoi de code")
    }
}