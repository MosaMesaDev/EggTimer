package com.mosamesadev.eggtimer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_boiledeggs.*

class BoiledEggs : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boiledeggs)

        btn4minutetimer.setOnClickListener {
            val intent = android.content.Intent(this, Timer::class.java)
            startActivity(intent)
        }
    }

}