package com.example.vk1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    /**
     * Глобальные изменяемые (var) переменные это плохой подход.
     * Да и хранить список тут как будто смысла нет.
     *
     * Предлагаю оставить тут изменяемую переменную, но поменять на squaresCount.
     * В onCreate тогда будет val data = MutableList(it.getInt("num")){it}
     *
     * Кстати переменные лучше называть понятнее, что такое data - неясно
     */
    private var data = mutableListOf(0,1,2,3,4,5,6)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * В kotlin code style принято использовать конструкции с let
         * savedInstanceState?.let {
         *    data = MutableList(it.getInt("num")){it}
         * }
         */
        if (savedInstanceState != null) {
            data = MutableList(savedInstanceState.getInt("num")){it}
        }
        val customAdapter = CustomAdapter(data)

        /**
         * findViewById
         * Returns: a view with given ID if found, or null otherwise
         *
         * Формально нужно использовать:
         * val recyclerView: RecyclerView? = findViewById(R.id.recycler)
         */
        val recyclerView: RecyclerView = findViewById(R.id.recycler)
        /**
         * Предложил бы заинлайнить
         * recyclerView.adapter = CustomAdapter(data)
         */
        recyclerView.adapter = customAdapter
        val button:Button = findViewById(R.id.button)
        button.setOnClickListener{
            data.add(data.size)
            customAdapter.notifyItemInserted(data.size-1)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {

        /**
         * Ключ по-хорошему нужно выделить в константу тк используется в нескольких местах
         */
        outState.putInt("num",data.size)
        super.onSaveInstanceState(outState)

    }

}