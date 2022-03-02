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

        item.add(EggPages("https://raw.githubusercontent.com/MosaMesaDev/EggTimer/master/app/src/main/res/drawable/boiledegg.png","Boiled Eggs" ))
        item.add(EggPages("https://raw.githubusercontent.com/MosaMesaDev/EggTimer/master/app/src/main/res/drawable/poachedeggs.jpg","Poached Eggs", ))
        item.add(EggPages("https://raw.githubusercontent.com/MosaMesaDev/EggTimer/master/app/src/main/res/drawable/friedeggs.jpg","Fried Eggs" ))

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
                if( position == 2 )                     {
                    val intent = android.content.Intent(this@MainActivity, FriedEggs::class.java)
                    startActivity(intent)
                }

            }

        })


    }
}