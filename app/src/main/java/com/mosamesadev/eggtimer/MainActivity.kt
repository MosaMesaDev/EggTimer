package com.mosamesadev.eggtimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Layout manager
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val item = ArrayList<EggPages>()

        //adding user, the name for this variables User, Firstname and Lastname are inherited from one of the tutorials I have followed. I wont change this name, in honor of them :)

        item.add(EggPages("https://raw.githubusercontent.com/MosaMesaDev/myCV/master/src/main/res/drawable/mycvastrologer.png","Astrologer", "The Astrologer activity was a basic lesson for me about working with input fields in an activity. Even tho in this particular case, the outcome will always be the same ;) ."))
        item.add(EggPages("https://raw.githubusercontent.com/MosaMesaDev/myCV/master/src/main/res/drawable/mycvbestproperty.png","Property locator", "In this activity you want to compare 5 neighbourhoods, you want to know which has the lowest max distance to the 5 services you need. \n\nFor interactivity, you place 5 important services, and then the algorithm will show which area has the lowest maximum distance to all 5 services."))

        //Adapter setting
        val newAdapter = RecyclerViewAdapter(item)
        recyclerView.adapter = newAdapter
        newAdapter.setOnItemClickListener(object : RecyclerViewAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {


                //If you click on position 0, you open the Astrologer activity
                if( position == 0 )                     {
                    val intent = android.content.Intent(this@MainActivity, Astrologer::class.java)
                    startActivity(intent)
                }

            }

        })


    }
}