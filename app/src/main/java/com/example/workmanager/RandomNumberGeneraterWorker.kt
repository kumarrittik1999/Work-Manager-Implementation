package com.example.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class RandomNumberGeneraterWorker(
    val context: Context,
    val workerParams: WorkerParameters
) : Worker(context, workerParams) {

    private var isRandomGeneratorOn = false

    init {
        isRandomGeneratorOn = true
    }

    override fun doWork(): Result {
        startRandomNumberGenerator()
        return Result.success()
    }

    private fun startRandomNumberGenerator() {
        var i = 0
        while(i < 5) {
            if(isRandomGeneratorOn) {
                Thread.sleep(1000)
                val randomNumber = generateRandomNumber()
                Log.i("WorkManager", "Current thread id is " + Thread.currentThread().id + " and Random number " + randomNumber)
                i++
            }
        }
    }

    private fun generateRandomNumber(): Int {
        val randomNumber = (1..100).random()
        return randomNumber
    }

}