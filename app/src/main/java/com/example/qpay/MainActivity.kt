package com.example.qpay

import android.os.Bundle
import android.text.TextUtils
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.qpay.ui.create_account.CreateAccountScreen
import com.example.qpay.ui.login.LoginScreen
import com.example.qpay.ui.theme.QPayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QpayApp()
        }
    }
}

// Email validity check
fun String.isEmailValid(): Boolean {
    return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
}


@Composable
fun QpayApp() {
    QPayTheme {
        val navController = rememberNavController()
        Surface(color = MaterialTheme.colors.background) {
            NavHost(
                navController = navController,
                startDestination = "login_screen"
            ) {
                composable("login_screen") {
                    LoginScreen(navController)
                }

                composable("create_account") {
                    CreateAccountScreen(navController)
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    QPayTheme {
        QpayApp()
    }

}