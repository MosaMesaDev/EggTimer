package com.mosamesadev.eggtimer
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_poachedeggs.*

class PoachedEggs : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poachedeggs)
        var secs = 0// this is used to intelligently set the start number of seconds for the timer

        // this button.OnClickListener points to the timer with an initial value of 180 for the timer.

        btn3minutetimer.setOnClickListener {

            val intent = Intent(this, Timer::class.java)
            secs = 180
            intent.putExtra("secs", secs)
            startActivity(intent)
        }

    }
}