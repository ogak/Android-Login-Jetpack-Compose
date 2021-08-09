package com.example.qpay.ui.create_account

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.qpay.R
import com.example.qpay.isEmailValid
import com.example.qpay.ui.theme.QPayTheme

@Composable
fun CreateAccountScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Head()

            Column(
                modifier = Modifier.padding(start = 32.dp, end = 32.dp)
            ) {
                Column(
                    modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.Start
                )
                {
                    Text(
                        "Create an Account",
                        modifier.padding(top = 16.dp, bottom = 16.dp),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )


                    var name by rememberSaveable { mutableStateOf("") }
                    var email by rememberSaveable { mutableStateOf("") }
                    var password by rememberSaveable { mutableStateOf("") }
                    Column(
                        modifier =
                        Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp, bottom = 8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {

                        OutlinedTextField(
                            value = name,
                            onValueChange = {
                                name = it
                            },
                            label = { Text("Name") },
                            placeholder = { Text(text = "Your name here") },
                            modifier = Modifier.fillMaxWidth()
                        )

                        OutlinedTextField(
                            value = email,
                            onValueChange = {
                                email = it
                            },
                            placeholder = { Text("example@mailprovider.com") },
                            label = { Text(text = "Email") },
                            modifier = Modifier.fillMaxWidth()
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
                            onValueChange = {
                                password = it
                            },
                            label = { Text("Password") },
                            modifier = Modifier.fillMaxWidth(),
                            trailingIcon = {
                                IconButton(onClick = {
                                    passwordVisibility = !passwordVisibility
                                }) {
                                    Icon(
                                        painter = passwordTrailingIcon,
                                        contentDescription = "Password Visibility"
                                    )
                                }
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Password
                            ),
                            visualTransformation =
                            if (passwordVisibility) VisualTransformation.None
                            else
                                PasswordVisualTransformation()
                        )

                        Button(
                            onClick = { /*TODO*/ },
                            modifier
                                .fillMaxWidth()
                                //  342.d.width(p)
                                .height(64.dp)
                                .padding(top = 12.dp, bottom = 12.dp)
                        ) {
                            Text(
                                "Create Account",
                                fontSize = 17.sp
                            )
                        }

                        OutlinedButton(
                            onClick = { navController.navigate("login_screen") },
                            modifier
                                .fillMaxWidth()
                                // .width(342.dp)
                                .height(64.dp)
                                .padding(bottom = 12.dp)
                        ) {
                            Text(
                                "Login",
                                fontSize = 17.sp
                            )
                        }


                    }
                }
            }


        }
    }
}

@Composable
fun Head(modifier: Modifier = Modifier) {
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
                painterResource(id = R.drawable.ic_qpay),
                contentDescription = "QPAY TITLE",
                modifier.padding(bottom = 16.dp, top = 16.dp)
            )
            Image(
                painterResource(id = R.drawable.ic_bitcoin_isometric),
                contentDescription = "Finance Analysis",
                modifier
                    .fillMaxWidth()
            )
        }
    }
}


