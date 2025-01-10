package com.example.assigment2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Student_Details_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_student_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val studentName = intent.getStringExtra("student_name")
        val studentId = intent.getStringExtra("student_id")
        val studentPhone = intent.getStringExtra("student_phone")
        val studentAddress = intent.getStringExtra("student_address")
        val studentChecked = intent.getBooleanExtra("student_checked", false)
        val position = intent.getIntExtra("StudentIndex", 0)

        findViewById<TextView>(R.id.activity_student_details_name).text = "Name:" + studentName
        findViewById<TextView>(R.id.activity_student_details_id).text = "Id:" + studentId
        findViewById<TextView>(R.id.activity_student_details_phone).text = "Phone:" + studentPhone
        findViewById<TextView>(R.id.activity_student_details_address).text =
            "Adrress:" + studentAddress
        findViewById<CheckBox>(R.id.activity_student_details_checkbox).isChecked = studentChecked
        findViewById<CheckBox>(R.id.activity_student_details_checkbox).isEnabled = false

        val backButton: ImageButton = findViewById(R.id.activity_student_details_back)
        backButton.setOnClickListener {
            finish()
        }
        val editButton: Button = findViewById(R.id.Student_Detail_Edit_Button)
        editButton.setOnClickListener {
            val intent = Intent(this, Student_Edit_Details_Activity::class.java).apply {
                putExtra("student_name", studentName)
                putExtra("student_id", studentId)
                putExtra("student_phone", studentPhone)
                putExtra("student_address", studentAddress)
                putExtra("student_checked", studentChecked)
                putExtra("StudentIndex", position)
            }
            startActivity(intent)
        }
    }

}