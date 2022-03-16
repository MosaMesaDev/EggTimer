package com.mosamesadev.eggtimer
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_boiledeggs.*

class BoiledEggs : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boiledeggs)
        var secs = 0 // this is used to intelligently set the start number of seconds for the timer

        // every button.OnClickListener points to the same timer but with a different initial value of the timer.
        btn4minutetimer.setOnClickListener {

            val intent = Intent(this, Timer::class.java)
                secs = 240
                intent.putExtra("secs", secs)
            startActivity(intent)
            }

        btn6minutetimer.setOnClickListener {

            val intent = Intent(this, Timer::class.java)
            secs = 360
            intent.putExtra("secs", secs)
            startActivity(intent)
        }
        btn9minutetimer.setOnClickListener {

            val intent = Intent(this, Timer::class.java)
            secs = 540
            intent.putExtra("secs", secs)
            startActivity(intent)
        }

        }
    }