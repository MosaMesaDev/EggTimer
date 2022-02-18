package com.mosamesadev.eggtimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.timer.*
import android.os.CountDownTimer
import android.view.View

class Timer : AppCompatActivity() {
    private var progr = 240
    val start = 240_000L
    var timer = start
    lateinit var countDownTimer: CountDownTimer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.timer)



//      the first value
                setTextTimer()
        updateProgressBar()

            }

            fun on(view: View) {
                when(view.id){
                    R.id.btn_main_start -> startTimer()
                    R.id.btn_main_pause -> pauseTimer()
                    R.id.btn_main_rest -> resetTimer()
                }
            }

            //    btn start
            private fun startTimer() {
                countDownTimer = object : CountDownTimer(timer,1000){
                    //            end of timer

                    override fun onTick(millisUntilFinished: Long) {
                        timer = millisUntilFinished
                        setTextTimer()

                        progr = (timer/1000).toInt()
                        updateProgressBar()
                    }

                    override fun onFinish() {
                        TODO("Not yet implemented")
                    }

                }.start()
            }

            //    btn pause
            private fun pauseTimer() {
                countDownTimer.cancel()
            }

            //    btn restart
            private fun resetTimer() {
                countDownTimer.cancel()
                timer = start
                progr = 240
                setTextTimer()
                updateProgressBar()
            }

            //  timer format
            fun setTextTimer() {
                var m = (timer / 1000) / 60
                var s = (timer / 1000) % 60

                var format = String.format("%02d:%02d", m, s)

                tv_main_timer.setText(format)
            }


    private fun updateProgressBar() {
        progress_bar.progress = progr
    }
}