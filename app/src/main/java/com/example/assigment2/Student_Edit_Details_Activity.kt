package com.example.assigment2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.assigment2.StudentsRecyclerViewActivity.StudentsRecyclerAdapter
import com.example.assigment2.model.Model
import com.example.assigment2.model.Student
import com.example.assigment2.StudentsRecyclerViewActivity

class Student_Edit_Details_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_student_edit_details)
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

        findViewById<TextView>(R.id.activity_edit_student_name_input).text = studentName
        findViewById<TextView>(R.id.activity_edit_student_id_input).text = studentId
        findViewById<TextView>(R.id.activity_edit_student_phone_input).text = studentPhone
        findViewById<TextView>(R.id.activity_edit_student_address_input).text = studentAddress
        findViewById<CheckBox>(R.id.activity_student_details_checkbox).isChecked = studentChecked

        findViewById<Button>(R.id.activity_edit_student_cancel_button).setOnClickListener {
            finish()
        }
        findViewById<Button>(R.id.activity_edit_student_Save_Button).setOnClickListener{
            val id = findViewById<TextView>(R.id.activity_edit_student_id_input).text.toString()
            val name = findViewById<TextView>(R.id.activity_edit_student_name_input).text.toString()
            val phone = findViewById<TextView>(R.id.activity_edit_student_phone_input).text.toString()
            val address = findViewById<TextView>(R.id.activity_edit_student_address_input).text.toString()
            val checked = findViewById<CheckBox>(R.id.activity_student_details_checkbox).isChecked
            val student = Student(id, name, phone, address, checked)
            Model.shared.students[position] = student
            StudentsRecyclerViewActivity().adapter.notifyDataSetChanged()
            val intent = Intent(this, StudentsRecyclerViewActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
        findViewById<Button>(R.id.activity_edit_student_Delete_Button).setOnClickListener{
            Model.shared.students.removeAt(position)
            StudentsRecyclerViewActivity().adapter.notifyDataSetChanged()
            val intent = Intent(this, StudentsRecyclerViewActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }


    }
}