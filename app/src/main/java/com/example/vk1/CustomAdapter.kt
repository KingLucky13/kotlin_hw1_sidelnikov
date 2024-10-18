package com.example.vk1

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val data:MutableList<Int>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val numText = view.findViewById<TextView>(R.id.textView)
        fun bind(number:Int){
            numText.text = "$number"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val num = data[position]
        holder.bind(num)
        if(num % 2 == 1){
            holder.numText.setBackgroundColor(Color.BLUE)
        }
    }
}