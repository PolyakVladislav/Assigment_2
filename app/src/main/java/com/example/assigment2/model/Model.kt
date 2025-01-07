package com.example.assigment2.model

class Model private constructor(){

    var students: MutableList<Student> = ArrayList()

    companion object{
        val shared = Model()
    }

    init {
        for(i in 0..20){
            val student = Student(
                name = "Name Dor La Gaz $i",
                id = "Srudent ID: $i",
                avatarUrl = "",
                isChecked = false
            )
            students.add(student)
        }
    }
}