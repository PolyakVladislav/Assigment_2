package com.example.assigment2.model

data class Student(
    val name: String,
    val id: String,
    val phone: String,
    val address: String,
    var isChecked : Boolean = false
)
