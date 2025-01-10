package com.example.assigment2

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import com.example.assigment2.model.Student
import com.example.assigment2.model.Model

class Add_Student_Activity : AppCompatActivity() {
    private var cancleButton: Button? = null
    private var saveButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)

        // Adjust padding for system bars
        val rootView = findViewById<LinearLayout>(R.id.activity_add_student_root)
        ViewCompat.setOnApplyWindowInsetsListener(rootView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.updatePadding(
                left = systemBars.left,
                top = systemBars.top,
                right = systemBars.right,
                bottom = systemBars.bottom
            )
            insets
        }
        val cancleButton = findViewById<Button>(R.id.btn_cancel)
        val saveButton = findViewById<Button>(R.id.btn_save)
        cancleButton?.setOnClickListener {
            finish()
        }

        saveButton?.setOnClickListener {
            val name = findViewById<EditText>(R.id.input_name).text.toString()
            val id = findViewById<EditText>(R.id.input_id).text.toString()
            val phone = findViewById<EditText>(R.id.input_phone).text.toString()
            val address = findViewById<EditText>(R.id.input_address).text.toString()
            val isChecked = findViewById<CheckBox>(R.id.input_checked).isChecked  ?:false
            val student = Student(name, id, phone, address , isChecked)
            Model.shared.addStudent(student)
            finish()
        }
    }

}
