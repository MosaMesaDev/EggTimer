package com.mosamesadev.eggtimer
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_friedeggs.*

class FriedEggs : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friedeggs)
        var secs = 0


        btn6minutetimer.setOnClickListener {

            val intent = Intent(this, Timer::class.java)
            secs = 360
            intent.putExtra("secs", secs)
            startActivity(intent)
        }


    }
}