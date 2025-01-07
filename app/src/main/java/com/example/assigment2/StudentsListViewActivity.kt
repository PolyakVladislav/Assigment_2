package com.example.assigment2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class StudentsListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_students_list_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        // TODO: 1. Set xml layout
        // TODO: 2. Set instanse of ListView
        // TODO: 3. Set adapter for ListView
        // TODO: 4. Create row layout for ListView
        // TODO 5. Create data class for student
        // TODO 6. On click on chekbox


        val listView: ListView? = findViewById(R.id.students_list_view)
    }

    class StudentsAdapter(): BaseAdapter(){
        override fun getCount(): Int = 10

        override fun getItem(position: Int): Any {
            return 0
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val inflator = LayoutInflater.from(parent?.context)
      //      val view = convertView ?: inflator.inflate(R.layout.st)



        }

    }
}