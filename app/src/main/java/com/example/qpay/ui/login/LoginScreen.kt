package com.example.qpay.ui.login

import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.qpay.isEmailValid
import com.example.qpay.ui.theme.QPayTheme
import com.example.qpay.R

@Composable
fun LoginScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        item {
            Box {
                Column(
                    modifier
                        .fillMaxWidth()
                        .height(241.dp)
                        .background(MaterialTheme.colors.primary),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {

                }
                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painterResource(R.drawable.ic_qpay),
                        contentDescription = "QPAY TITLE",
                        modifier.padding(bottom = 16.dp, top = 16.dp)
                    )
                    Image(
                        painterResource(id = R.drawable.ic_finance_login),
                        contentDescription = "Finance Analysis",
                        modifier
                            .fillMaxWidth()
                    )
                }
            }

            Column(
                modifier
                    .padding(start = 36.dp, end = 36.dp)
                    .fillMaxSize()
            ) {

                Column(
                    modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.Start,
                ) {
                    Text(
                        text = "Welcome Back",
                        modifier
                            .padding(top = 16.dp, bottom = 16.dp),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                }


                // The text will remain intact when there is configuration changes
                var email by rememberSaveable { mutableStateOf("") }
                var password by rememberSaveable { mutableStateOf("") }

                // value of isEmailValid true or false
                val emailIsValid = email.isEmailValid()

                // Icon will changed to check when the email is valid
                val emailTrailingIcon = if (emailIsValid)
                    painterResource(id = R.drawable.ic_twotone_check)
                else
                    painterResource(id = R.drawable.ic_twotone_x)

                Column(
                    modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    OutlinedTextField(
                        value = email,
                        onValueChange = { typedEmail ->
                            email = typedEmail
                        },
                        modifier = modifier
                            .fillMaxWidth()
                            //.width(342.dp)
                            .padding(bottom = 14.dp),
                        singleLine = true,
                        label = { Text(text = "Email") },
                        placeholder = { Text("john@email.com") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Outlined.Email,
                                contentDescription = "Email"
                            )
                        },
                        trailingIcon = {
                            Icon(
                                painter = emailTrailingIcon,
                                contentDescription = "Email is valid"
                            )
                        }
                    )


                    // Password visibility will remain intact when there is configuration changes
                    var passwordVisibility by remember {
                        mutableStateOf(false)
                    }

                    // Icon button for visibility of password
                    val passwordTrailingIcon = if (passwordVisibility)
                        painterResource(id = R.drawable.ic_twotone_visibility_on)
                    else
                        painterResource(id = R.drawable.ic_twotone_visibility_off)

                    OutlinedTextField(
                        value = password,
                        onValueChange = { typedPassword ->
                            password = typedPassword
                        },
                        modifier = modifier
                            .fillMaxWidth(),
                        //.width(342.dp),
                        singleLine = true,
                        label = { Text(text = "Password") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Outlined.Lock,
                                contentDescription = "Password"
                            )
                        },
                        trailingIcon = {
                            IconButton(
                                onClick = {
                                    passwordVisibility = !passwordVisibility
                                }
                            ) {
                                Icon(
                                    painter = passwordTrailingIcon,
                                    contentDescription = "Password Visibility"
                                )
                            }
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password
                        ),
                        visualTransformation = if (passwordVisibility) VisualTransformation.None
                        else
                            PasswordVisualTransformation()
                    )
                    //Forgot password link
                    ClickableText(
                        text = AnnotatedString("Forgot Password?"),
                        style = MaterialTheme.typography.caption,
                        modifier =
                        modifier.padding(top = 18.dp, bottom = 18.dp),
                        onClick = {
                            Log.d(
                                "Login Screen",
                                "Forgot Password clicked!"
                            )
                        }
                    )

                    //Login Button

                    Button(
                        onClick = { },
                        modifier
                            .fillMaxWidth()
                            //.width(342.dp)
                            .height(64.dp)
                            .padding(bottom = 12.dp)
                    ) {
                        Text(
                            "Log In",
                            fontSize = 17.sp
                        )
                    }

                    //Create Account Button
                    OutlinedButton(
                        onClick = { navController.navigate("create_account") },
                        modifier
                            .fillMaxWidth()
                            // .width(342.dp)
                            .height(64.dp)
                            .padding(bottom = 12.dp)
                    ) {
                        Text(
                            "Create Account",
                            fontSize = 17.sp
                        )
                    }
                }


            }

        }

    }


}



