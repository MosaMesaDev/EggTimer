package com.mosamesadev.eggtimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.timer.*
import android.os.CountDownTimer
import android.view.View

class Timer : AppCompatActivity() {

    // initial values and types for the progress circle and timer counter
    private var timeprogressstart = 0
    var timeprogress = 0
    private var start = 0L
    var timer = 0L
    lateinit var countDownTimer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.timer)

        // gets the number of seconds to start with, from the previous activity
        val intent = intent
        val numberOfSeconds = intent.getIntExtra("secs", 100)

        // Turns numberOfSeconds into millis and into type Long
        start = (numberOfSeconds*1000).toLong()
        // sets up where the timer starts from
        timer = start
        // sets up where the progress circle starts from
        timeprogressstart = numberOfSeconds
        timeprogress = timeprogressstart
        // sets the max value of the progress circle to the number of seconds that will be counted down
        progress_bar.max = timeprogressstart

        setTextTimer()
        updateProgressBar()

    }

    fun on(view: View) {
        when(view.id){
            R.id.btn_start -> startTimer()
            R.id.btn_pause -> pauseTimer()
            R.id.btn_reset -> resetTimer()
        }
    }

    private fun startTimer() {
        countDownTimer = object : CountDownTimer(timer,1000){
            override fun onTick(millisUntilFinished: Long) {
                timer = millisUntilFinished
                setTextTimer()
                timeprogress = (timer/1000).toInt()
                updateProgressBar()
            }

            override fun onFinish() {
                TODO("Not yet implemented")
            }
        }.start()
    }

    private fun pauseTimer() {countDownTimer.cancel()}

    private fun resetTimer() {
        countDownTimer.cancel()
        timer = start
        timeprogress = timeprogressstart
        setTextTimer()
        updateProgressBar()
    }

    fun setTextTimer() {
        var m = (timer / 1000) / 60
        var s = (timer / 1000) % 60

        var format = String.format("%02d:%02d", m, s)

        tv_main_timer.text = format
    }

    fun updateProgressBar() {progress_bar.progress = timeprogress}

}


