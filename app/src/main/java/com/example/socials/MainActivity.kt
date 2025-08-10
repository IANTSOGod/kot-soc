package com.example.socials

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.socials.screens.ForgotPassword
import com.example.socials.screens.Homepage
import com.example.socials.screens.Loginpage
import com.example.socials.screens.SignupPage
import com.example.socials.ui.theme.SocialsTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SocialsTheme {
                val navcontroller = rememberNavController()
                NavHost(navController = navcontroller, startDestination = "login") {
                    composable("login") { Loginpage(navcontroller) }
                    composable("signup") { SignupPage(navcontroller) }
                    composable("forgotpwd") { ForgotPassword(navcontroller) }
                    composable("home") { Homepage(navcontroller) }
                }

            }
        }
    }
}


