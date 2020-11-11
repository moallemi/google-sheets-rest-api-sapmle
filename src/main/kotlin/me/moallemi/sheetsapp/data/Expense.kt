package me.moallemi.sheetsapp.data

data class Expense(
    val title: String,
    val description: String,
    val category: String,
    val price: Long,
    val date: String,
    val tag1: String,
    val tag2: String
)