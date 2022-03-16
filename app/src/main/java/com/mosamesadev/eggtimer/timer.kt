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
    var paused = false


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

        setTextTimer() // set the initial text of the timer
        updateProgressBar() // set the initial graphics of the circle
        startTimer() // and begin the countdown
    }

    fun on(view: View) {
        when(view.id){
            R.id.btn_pause -> pauseTimer() // what to do when the pause button is pressed
            R.id.btn_reset -> resetTimer() // what to do when the reset button is pressed
        }
    }

    private fun startTimer() {

        paused=false // When the timer begins, it is not paused.

        countDownTimer = object : CountDownTimer(timer,1000){
            override fun onTick(millisUntilFinished: Long) {
                timer = millisUntilFinished
                setTextTimer() // set the text of the timer
                timeprogress = (timer/1000).toInt()  // calculate this int for the progress graphic
                updateProgressBar() // update the progress graphic
            }

            override fun onFinish() {
                TODO("Not yet implemented")
            }
        }.start() // and begin!
    }

    private fun pauseTimer() { // this is to be able to pause the timer
        if(!paused){ paused=true // + change the text on the button from pause to continue
            btn_pause.setText(R.string.continue_string)
            countDownTimer.cancel() } // stop the countdown
        else{
            btn_pause.setText(R.string.pause) // or back from continue to pause
                        startTimer()}
    }

    private fun resetTimer() {   // if you press reset, do these things
        countDownTimer.cancel()  // stop the timer from running
        timer = start            // reset the timer to the starting value
        timeprogress = timeprogressstart // set the time progress to the starting value
        btn_pause.setText(R.string.pause) // change the text of this button from continue to pause (if it was pause, it remains pause)
        setTextTimer() // update the timer text
        updateProgressBar()  // update the graphics
        startTimer() // immediately restart the running of the timer
    }

    fun setTextTimer() {
        var m = (timer / 1000) / 60 // Math! Turning the timer in the number of remaining minutes
        var s = (timer / 1000) % 60 // Modulo the timer to get the number of remaining seconds in this minute

        var format = String.format("%01d:%02d", m, s) // 1 decimal for the minutes, 2 for the seconds

        tv_main_timer.text = format // Show the textview Timer with a nice format
    }

    fun updateProgressBar() {progress_bar.progress = timeprogress} // another tick

}


