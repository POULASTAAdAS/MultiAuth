package com.example.authapp.presentation.login

import androidx.lifecycle.ViewModel
import com.example.authapp.model.AuthenticationRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(): ViewModel() {
    fun verifyUserOnBackend(authenticationRequest: AuthenticationRequest){
        if (authenticationRequest.tokenID == null){

        }else{

        }
    }
}