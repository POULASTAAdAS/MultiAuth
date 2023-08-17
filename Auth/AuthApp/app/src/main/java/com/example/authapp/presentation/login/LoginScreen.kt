package com.example.authapp.presentation.login

import android.app.Activity
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.authapp.common.StartActivityForResult
import com.example.authapp.common.singIn
import com.example.authapp.model.AuthenticationRequest

@Composable
fun LoginScreen(
    mainViewModel: MainViewModel = hiltViewModel()
) {
    val googleButtonClicked = remember {
        mutableStateOf(false)
    }

    Content(
        googleButtonClicked = googleButtonClicked.value,
        handleBasicLogin = { userName, password ->

            mainViewModel.verifyUserOnBackend(
                authenticationRequest = AuthenticationRequest(
                    userName = userName,
                    password = password
                )
            )
        },
        handleGoogleLogin = {
            googleButtonClicked.value = true
        }
    ){
        mainViewModel.show()
    }

    val activity = LocalContext.current as Activity

    StartActivityForResult(
        key = googleButtonClicked.value,
        onResultReceived = {
            Log.d("tokenId", it)
            googleButtonClicked.value = false
            mainViewModel.verifyUserOnBackend(authenticationRequest = AuthenticationRequest(tokenID = it))
        },
        onDialogDismissed = {
            googleButtonClicked.value = false
        }
    ) { activityLauncher ->
        if (googleButtonClicked.value) {
            singIn(
                activity = activity,
                launchActivityResult = { intentSenderRequest ->
                    activityLauncher.launch(intentSenderRequest)
                },
                accountNotFound = {
                    googleButtonClicked.value = false
                }
            )
        }
    }
}