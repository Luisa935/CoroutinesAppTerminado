package com.example.coroutinesapp.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.job
import kotlinx.coroutines.launch

class MainViewModel:ViewModel () {

    var resultState by mutableStateOf("")
        private set

    var countTime by mutableStateOf(0)
        private set
    private var oneCount by mutableStateOf(false)

    var segundoboton by mutableStateOf(false)
    private set

    fun fetchData() {
        val job = viewModelScope.launch {
            for (i in 1..5) {
                delay(1000)
                countTime = i

            }
            oneCount = true
        }
        segundoboton = true

        /*
    Thread trabaja en el mismo contexto
    fun bloqueoApp(){
        Thread.sleep(5000)
        resultState="Respuesta del servidor "
    }*/



        fun fetchData() {
            viewModelScope.launch { //launch agrupa las corrutinas y viewmodelscope es para la app
                delay(5000)
                resultState =
                    "Respuesta desde el servidor web" //viewmodel basicamente manda al backgorund
            }
            if (oneCount){
                job.cancel()
            }

        }

    }
fun clicksegundoboton(){
    viewModelScope.launch { delay(2000) }
    resultState = "Respuesta desde el segundo botón"
}

}