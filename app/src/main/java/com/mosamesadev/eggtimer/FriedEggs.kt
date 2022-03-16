package com.mosamesadev.eggtimer
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_friedeggs.*

class FriedEggs : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friedeggs)
        var secs = 0// this is used to intelligently set the start number of seconds for the timer

        // this button.OnClickListener points to the timer with an initial value of 360 for the timer.



        btn6minutetimer.setOnClickListener {

            val intent = Intent(this, Timer::class.java)
            secs = 360
            intent.putExtra("secs", secs)
            startActivity(intent)
        }


    }
}