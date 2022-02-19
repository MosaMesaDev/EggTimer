package com.mosamesadev.eggtimer
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_boiledeggs.*

class BoiledEggs : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boiledeggs)
        var secs = 0

        btn4minutetimer.setOnClickListener {

            val intent = Intent(this, Timer::class.java)
                secs = 240
                intent.putExtra("secs", secs)
            startActivity(intent)
            }
        btn5minutetimer.setOnClickListener {

            val intent = Intent(this, Timer::class.java)
            secs = 300
            intent.putExtra("secs", secs)
            startActivity(intent)
        }
        btn6minutetimer.setOnClickListener {

            val intent = Intent(this, Timer::class.java)
            secs = 360
            intent.putExtra("secs", secs)
            startActivity(intent)
        }
        btn7minutetimer.setOnClickListener {

            val intent = Intent(this, Timer::class.java)
            secs = 420
            intent.putExtra("secs", secs)
            startActivity(intent)
        }
        btn8minutetimer.setOnClickListener {

            val intent = Intent(this, Timer::class.java)
            secs = 480
            intent.putExtra("secs", secs)
            startActivity(intent)
        }
        btn10minutetimer.setOnClickListener {

            val intent = Intent(this, Timer::class.java)
            secs = 600
            intent.putExtra("secs", secs)
            startActivity(intent)
        }

        }
    }