package com.mosamesadev.eggtimer
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_poachedeggs.*

class PoachedEggs : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poachedeggs)
        var secs = 0

        btn3minutetimer.setOnClickListener {

            val intent = Intent(this, Timer::class.java)
            secs = 180
            intent.putExtra("secs", secs)
            startActivity(intent)
        }

    }
}