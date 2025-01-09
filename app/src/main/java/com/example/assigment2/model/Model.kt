package com.example.assigment2.model

class Model private constructor(){
    fun addStudent(student: Student) {
        students.add(student)
    }

    var students: MutableList<Student> = ArrayList()

    companion object{
        val shared = Model()
    }

    init {
        for(i in 0..20){
            val student = Student(
                name = "Name Dor La Gaz $i",
                id = "Srudent ID: $i",
                isChecked = false,
                phone = "Phone: 1234567890",
                address = "Address: 1234 Main St"
            )
            students.add(student)
        }
    }
}