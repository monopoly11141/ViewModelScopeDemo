package com.example.viewmodelscopedemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.viewmodelscopedemo.model.UserRepository
import kotlinx.coroutines.Dispatchers

class MainActivityViewModel : ViewModel() {

    private var userRepository = UserRepository()
//    var users : MutableLiveData<List<User>> = MutableLiveData()
//
//    fun getUserData() {
//        viewModelScope.launch{
//            var result : List<User>? = null
//            withContext(Dispatchers.IO) {
//                result = userRepository.getUsers()
//            }
//
//            users.value = result
//
//        }
//    }

    var users = liveData(Dispatchers.IO){
        val result = userRepository.getUsers()
        emit(result)

    }

}