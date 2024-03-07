package ru.com.vbulat.coroutineflowretry.lessons.lesson_08

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

val coroutineScorpe = CoroutineScope(Dispatchers.IO)
suspend fun main (){
    val flow = getFlow()

    val job1 = coroutineScorpe.launch {
        flow.collect{
            println(it)
        }
    }

    delay(5000)

    val job2 = coroutineScorpe.launch {
        flow.collect{
            println(it)
        }
    }

    job1.join()
    job2.join()
}

fun getFlow() : Flow<Int> = flow {
    repeat(10){
        println("Emitted: $it")
        emit(it)
        delay(1000)
    }
}