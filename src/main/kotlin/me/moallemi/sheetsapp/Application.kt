package me.moallemi.sheetsapp

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import me.moallemi.sheetsapp.data.GetResponseToExpense

suspend fun main() {

    val app = GoogleSheetsApp()
    val items = app.getExpenses()
    
    val sum = items.sumByDouble { it.price.toDouble() }
    println(sum)
}
