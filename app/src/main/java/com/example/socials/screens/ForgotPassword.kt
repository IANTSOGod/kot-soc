package com.example.socials.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.socials.components.ForgotStepper
import com.example.socials.components.StepCircle
import com.example.socials.ui.theme.SocialsTheme

@Composable
fun ForgotPassword(navController: NavController) {

    var index by remember { mutableIntStateOf(0) }
    val textlist = listOf("Recherce de compte", "Vérification de code", "Nouveau mdp")

    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    StepCircle(index + 1)
                    Text(textlist[index])
                }
                Box(modifier = Modifier.height(30.dp))
                ForgotStepper(index)
                Box(modifier = Modifier.height(20.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                    if (index != 0) {
                        Button(
                            onClick = { index -= 1 },
                            modifier = Modifier
                                .height(40.dp)
                        ) {
                            Text("Previous")
                        }
                    }
                    if (index < textlist.size - 1) {
                        Button(
                            onClick = { index += 1 },
                            modifier = Modifier
                                .height(40.dp)
                        ) {
                            Text("Continue")
                        }
                    }
                    if (index == textlist.size - 1) {
                        Button(
                            onClick = { navController.navigate("login") },
                            modifier = Modifier.height(40.dp),

                        ) {
                            Text("Finish")
                        }
                    }

                }
            }
        }
    }
}

