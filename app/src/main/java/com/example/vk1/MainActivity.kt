package com.example.vk1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var data = mutableListOf(0,1,2,3,4,5,6)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState != null) {
            data = MutableList(savedInstanceState.getInt("num")){it}
        }
        val customAdapter = CustomAdapter(data)
        val recyclerView: RecyclerView = findViewById(R.id.recycler)
        recyclerView.adapter = customAdapter
        val button:Button = findViewById(R.id.button)
        button.setOnClickListener{
            data.add(data.size)
            customAdapter.notifyItemInserted(data.size-1)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {

        outState.putInt("num",data.size)
        super.onSaveInstanceState(outState)

    }

}