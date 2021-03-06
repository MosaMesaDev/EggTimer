package com.mosamesadev.eggtimer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder


class RecyclerViewAdapter(val eggPagesList: ArrayList<EggPages>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    private lateinit var mListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view, mListener)
    }
    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {
        holder.bind(eggPagesList[position])
    }
    override fun getItemCount(): Int {
        return eggPagesList.size
    }
    class ViewHolder(itemView: View, listener:onItemClickListener) : RecyclerView.ViewHolder(itemView) {

        init {

            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }

        }
        fun bind(eggPages: EggPages) {

            Glide.with(itemView.context)
                .load(eggPages.EggPageRecyclerImage) // load this image...
                .into(itemView.findViewById(R.id.CVRecyclerImage))// ...into this imageview

            val textViewName = itemView.findViewById<TextView>(R.id.title) // get this text...
            textViewName.text = eggPages.EggPageTitle // ... and show it here

        }
    }

}
