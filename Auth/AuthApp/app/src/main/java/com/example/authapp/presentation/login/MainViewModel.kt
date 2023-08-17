package com.example.authapp.presentation.login

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.authapp.domain.repository.NetworkRepository
import com.example.authapp.model.AuthenticationRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val networkRepository: NetworkRepository
) : ViewModel() {

    private val response =
        mutableStateOf(false)

    fun verifyUserOnBackend(authenticationRequest: AuthenticationRequest) {
        viewModelScope.launch(Dispatchers.IO) {
            response.value =
                networkRepository.logInUserOnBackend(authenticationRequest = authenticationRequest).status!!
        }
    }

    fun show(){
        Log.d("api response" , response.value.toString())
    }
}