package com.example.authapp.presentation.login

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material.icons.rounded.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Content(
    handleBasicLogin: (String , String) -> Unit,
    handleGoogleLogin: (String) -> Unit
) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(all = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Spacer(
            modifier = Modifier
                .aspectRatio(2f)
        )

        Column(
            Modifier
                .fillMaxSize()
        ) {

            Spacer(modifier = Modifier.aspectRatio(3f))

            val focusManager = LocalFocusManager.current

            val userName = remember { mutableStateOf("") }

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = userName.value,
                onValueChange = {
                    userName.value = it
                },
                placeholder = {
                    Text(
                        text = "Username , email",
                        color = Color.LightGray
                    )
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                ),
                singleLine = true,
                shape = Shapes().large
            )

            Spacer(modifier = Modifier.height(20.dp))

            val password = remember { mutableStateOf("") }

            val showPassword = remember {
                mutableStateOf(true)
            }

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = password.value,
                onValueChange = {
                    password.value = it
                },
                placeholder = {
                    Text(
                        text = "password",
                        color = Color.LightGray
                    )
                },
                visualTransformation = if (showPassword.value) PasswordVisualTransformation()
                else VisualTransformation.None,
                trailingIcon = {
                    Icon(
                        modifier = Modifier.clickable(
                            indication = null,
                            interactionSource = MutableInteractionSource()
                        ) {
                            showPassword.value = !showPassword.value
                            Log.d("showPassword", showPassword.value.toString())
                        },
                        imageVector = if (showPassword.value) Icons.Rounded.Visibility
                        else Icons.Rounded.VisibilityOff,
                        contentDescription = "hide , show icon"
                    )
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        focusManager.clearFocus()
                    }
                ),
                singleLine = true,
                shape = Shapes().large
            )


            Spacer(modifier = Modifier.height(30.dp))


            Button(
                onClick = {
                    focusManager.clearFocus()
                    userName.value = ""
                    password.value = ""
                    handleBasicLogin(userName.value , password.value)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                border = BorderStroke(
                    2.dp,
                    Color.DarkGray
                ),
                shape = Shapes().extraLarge
            ) {
                Text(
                    text = "Login",
                    fontSize = MaterialTheme.typography.titleLarge.fontSize
                )
            }


            Row(
                Modifier
                    .fillMaxSize()
                    .padding(bottom = 10.dp)
            ) {
                Button(
                    onClick = {

                    },
                    Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .align(Alignment.Bottom),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                    border = BorderStroke(2.dp, Color.DarkGray)
                ) {
                    Text(
                        text = "Continue with Google",
                        fontSize = MaterialTheme.typography.titleLarge.fontSize,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Image(
                        imageVector = Icons.Rounded.Person,
                        contentDescription = "google button"
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    Content(
        handleBasicLogin = { _ ,_ ->

        },
        handleGoogleLogin = {}
    )
}