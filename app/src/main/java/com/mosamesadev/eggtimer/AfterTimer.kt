package com.mosamesadev.eggtimer

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_aftertimer.*
import kotlinx.android.synthetic.main.activity_friedeggs.*
import kotlinx.android.synthetic.main.activity_poachedeggs.*

class AfterTimer : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_aftertimer)


            stop_alarm_button.setOnClickListener {

                val intent = Intent(this, Timer::class.java)

                startActivity(intent)
            }
        }
    }