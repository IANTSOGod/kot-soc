package com.example.socials.screens

import androidx.core.view.WindowInsetsCompat.Type
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
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.navigation.NavController
import com.example.socials.components.Input
import com.example.socials.components.InputPassword
import com.example.socials.components.PButton
import com.example.socials.services.signup
import com.example.socials.types.SignupResult
import kotlinx.coroutines.launch

@Composable
fun SignupPage(navController: NavController) {
    var fname by remember { mutableStateOf("") }
    var lname by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val coroutinescope = rememberCoroutineScope()
    val scrollstate = rememberScrollState()

    val view = LocalView.current
    var imeHeightPx by remember { mutableIntStateOf(0) }

    val imeHeightDp = with(LocalDensity.current) { imeHeightPx.toDp() }

    DisposableEffect(view) {
        ViewCompat.setOnApplyWindowInsetsListener(view) { _, insets ->
            val imeHeight = insets.getInsets(Type.ime()).bottom
            imeHeightPx = imeHeight
            insets
        }
        onDispose {
            ViewCompat.setOnApplyWindowInsetsListener(view, null)
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
                    .verticalScroll(scrollstate)
                    .padding(bottom = imeHeightDp)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Text("Sign up", fontSize = 20.sp)
                Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                    Text("First name")
                    Input(field = fname, placeholder = "Enter your first name here") { fname = it }
                }
                Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                    Text("Last name")
                    Input(field = lname, placeholder = "Enter your last name here") { lname = it }
                }
                Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                    Text("Email")
                    Input(field = email, placeholder = "Enter your email here") { email = it }
                }
                Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                    Text("Password")
                    InputPassword(password = password) { password = it }
                }
                PButton(label = "Create account", type = "primary") {
                    coroutinescope.launch {
                        when (val result = signup(
                            fname = fname,
                            lname = lname,
                            email = email,
                            password = password
                        )) {
                            is SignupResult.Ok -> {
                                println(result.data.email)
                            }

                            is SignupResult.Bad -> {
                                result.data.message.map { message -> println(message) }
                            }

                            is SignupResult.Err -> {
                                println(result.data.message)
                            }
                        }
                    }
                }
                PButton(label = "Go back", type = "outline") { navController.navigate("login") }
            }
        }
    }
}