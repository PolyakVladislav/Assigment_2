package com.example.assigment2

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assigment2.model.Model
import com.example.assigment2.model.Student

class StudentsRecyclerViewActivity : AppCompatActivity() {
    var adapter = StudentsRecyclerAdapter(Model.shared.students)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_students_recycler_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val students: MutableList<Student> = Model.shared.students
        val recyclerView: RecyclerView = findViewById(R.id.students_recycler_view)
        recyclerView.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        adapter = StudentsRecyclerAdapter(students)
        recyclerView.adapter = adapter

        val addStudentButton = findViewById<View>(R.id.add_student_button)
        addStudentButton?.setOnClickListener {
            val intent = Intent(this, Add_Student_Activity::class.java)
            startActivity(intent)
        }
    }
    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }
    class StudentViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){


        private var nameTextView: TextView? = null
        private var idTextView: TextView? = null
        private var checkBox: CheckBox? = null
        private var student: Student? = null
        private var student_list_row: View = itemView.findViewById(R.id.student_list_row)

        init {
            nameTextView = itemView.findViewById(R.id.student_row_name_view)
            idTextView = itemView.findViewById(R.id.student_row_id_view)
            checkBox = itemView.findViewById(R.id.student_row_check_box)
            checkBox?.apply{
                setOnClickListener{ view ->
                    (tag as? Int)?.let{
                        student?.isChecked = (view as? CheckBox)?.isChecked ?: false
                    }
                }
            }
            itemView.setOnClickListener{
                adapterPosition
            }
            student_list_row.setOnClickListener{
                val intent = Intent(itemView.context, Student_Details_Activity::class.java).apply {
                    putExtra("student_id", student?.id)
                    putExtra("student_name", student?.name)
                    putExtra("student_phone", student?.phone)
                    putExtra("student_address", student?.address)
                    putExtra("student_checked", student?.isChecked)
                    putExtra("StudentIndex", adapterPosition)
                }
                itemView.context.startActivity(intent)
            }

        }
        fun bind(student: Student?, position: Int) {
            this.student = student
            nameTextView?.text = student?.name
            idTextView?.text = student?.id
            checkBox?.apply{
                isChecked = student?.isChecked ?: false
                tag = position
            }
        }
    }
    class StudentsRecyclerAdapter(private val students: List<Student>?): RecyclerView.Adapter<StudentViewHolder>(){

        override fun getItemCount(): Int = students?.size ?: 0

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
            val inflation = LayoutInflater.from(parent.context)
            val view =  inflation.inflate(
                R.layout.student_list_row,
                parent,
                false
            )
            return StudentViewHolder(view)
        }

        override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
            holder.bind(students?.get(position),position)
        }


    }
}