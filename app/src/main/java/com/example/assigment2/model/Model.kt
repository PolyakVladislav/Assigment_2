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
        for(i in 0..10){
            val student = Student(
                name = "Student $i",
                id = "$i",
                isChecked = false,
                phone = "1234567890",
                address = "1234 Main St"
            )
            students.add(student)
        }
    }
}