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

        item.add(EggPages("https://raw.githubusercontent.com/MosaMesaDev/EggTimer/master/app/src/main/res/drawable/boiledegg.png","Boiled Eggs", "Boiling eggs is the simplest way to enjoying them. Whether you like your eggs hard, medium, or soft boiled, follow the same boiling time for the perfect boiled eggs every time."))
        item.add(EggPages("https://raw.githubusercontent.com/MosaMesaDev/EggTimer/master/app/src/main/res/drawable/poachedeggs.jpg","Poached Eggs", "More fancy than boiled eggs, but just as tasteful."))

        //Adapter setting
        val newAdapter = RecyclerViewAdapter(item)
        recyclerView.adapter = newAdapter
        newAdapter.setOnItemClickListener(object : RecyclerViewAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {


                //If you click on position 0, you open the Astrologer activity
                if( position == 0 )                     {
                    val intent = android.content.Intent(this@MainActivity, BoiledEggs::class.java)
                    startActivity(intent)
                }
                if( position == 1 )                     {
                    val intent = android.content.Intent(this@MainActivity, PoachedEggs::class.java)
                    startActivity(intent)
                }

            }

        })


    }
}