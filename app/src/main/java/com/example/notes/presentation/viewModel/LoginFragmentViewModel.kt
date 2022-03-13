package com.example.notes.presentation.viewModel

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notes.R
import com.example.notes.domain.entity.Profile
import com.example.notes.domain.useCase.GetProfileByIdUseCase
import com.example.notes.domain.useCase.GetProfileListUseCase
import com.example.notes.domain.useCase.LoadDataUseCase
import com.example.notes.domain.useCase.MakeLoginRequestUseCase
import com.example.notes.presentation.models.LoginResult
import com.example.notes.presentation.models.LoginState
import kotlinx.coroutines.launch
import java.lang.RuntimeException
import javax.inject.Inject
import com.example.notes.presentation.models.Result
import kotlinx.coroutines.runBlocking
import java.lang.Exception

class LoginFragmentViewModel @Inject constructor(
    private val makeLoginRequestUseCase: MakeLoginRequestUseCase,
    private val getProfileListUseCase: GetProfileListUseCase,
    private val getProfileByIdUseCase: GetProfileByIdUseCase,
    private val loadDataUseCase: LoadDataUseCase
) : ViewModel() {

    private val _loginState = MutableLiveData<LoginState>()
    val loginState: LiveData<LoginState> = _loginState

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    fun getProfileList() = getProfileListUseCase()

    fun getProfileById(id: String) = getProfileByIdUseCase(id)

    fun auth(email: String, password: String): Result<Profile> {

        var result: Result<Profile>? = null

        try {
            result = makeLoginRequestUseCase(email, password)
        } catch (e: Exception) {
        }


        if (result is Result.Success) {
            _loginResult.value =
                LoginResult(success = result.data.name)
        } else {
            _loginResult.value = LoginResult(error = R.string.login_failed)
        }

        return result as Result<Profile>
    }

    fun loginDataChanged(username: String, password: String) {
        if (!isUserNameValid(username)) {
            _loginState.value = LoginState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(password)) {
            _loginState.value = LoginState(passwordError = R.string.invalid_password)
        } else {
            _loginState.value = LoginState(isDataValid = true)
        }
    }

    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }
}