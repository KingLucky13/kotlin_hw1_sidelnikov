package com.example.vk1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var squareCount = 0
    private val squaresCountKey = "squareCount"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        savedInstanceState?.let{
            squareCount = savedInstanceState.getInt(squaresCountKey)
        }

        var squareNumbers = MutableList(squareCount){it}
        val squareAdapter = SquareAdapter(squareNumbers)
        val recyclerView: RecyclerView? = findViewById(R.id.recycler)
        recyclerView?.adapter = squareAdapter

        val button:Button? = findViewById(R.id.button)
        button?.setOnClickListener{
            squareNumbers.add(squareCount)
            squareAdapter.notifyItemInserted(squareCount)
            squareCount += 1
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {

        outState.putInt(squaresCountKey,squareCount)
        super.onSaveInstanceState(outState)

    }

}