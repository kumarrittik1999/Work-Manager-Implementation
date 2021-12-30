package com.example.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.work.PeriodicWorkRequest
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.example.workmanager.databinding.ActivityMainBinding
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    private lateinit var workManager: WorkManager
    private lateinit var workRequest: WorkRequest


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initializeMembers()

        setOnClickListeners()
    }

    private fun initializeMembers() {
        workManager = WorkManager.getInstance(this)
        workRequest = PeriodicWorkRequest.Builder(RandomNumberGeneraterWorker::class.java,15, TimeUnit.MINUTES).build()
    }

    private fun setOnClickListeners() {
        binding.btnStartWorker.setOnClickListener(this)
        binding.btnStopWorker.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_start_worker -> {
                startWorker()
            }
            R.id.btn_stop_worker -> {
                stopWorker()
            }
            else -> {
                return
            }
        }
    }

    private fun startWorker() {
        workManager.enqueue(workRequest)
    }

    private fun stopWorker() {
        workManager.cancelWorkById(workRequest.id)
    }
}