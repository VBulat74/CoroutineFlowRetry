package ru.com.vbulat.coroutineflowretry.lessons.lesson_09

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

val coroutineScorpe = CoroutineScope(Dispatchers.IO)
suspend fun main (){
    val flow = MutableSharedFlow<Int>()


    coroutineScorpe.launch {
        repeat(10){
            println("Emitted: $it")
            flow.emit(it)
            delay(1000)
        }
    }

    val job1 = coroutineScorpe.launch {
        flow.collect{
            println("Got from 1st collector $it")
        }
    }

    delay(5000)

    val job2 = coroutineScorpe.launch {
        flow.collect{
            println("Got from 2nd collector $it")
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