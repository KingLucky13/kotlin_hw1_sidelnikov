package com.example.vk1

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SquareAdapter(private val squareNumbers:MutableList<Int>): RecyclerView.Adapter<SquareAdapter.ViewHolder>() {
    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val numText:TextView? = view.findViewById<TextView>(R.id.textView)
        fun bind(number:Int){
            numText?.text = "$number"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false))
    }

    override fun getItemCount(): Int {
        return squareNumbers.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val num = squareNumbers[position]
        holder.bind(num)
        if(num % 2 == 1){
            holder.numText?.setBackgroundColor(Color.BLUE)
        }
    }
}