package me.moallemi.sheetsapp

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import me.moallemi.sheetsapp.data.Expense
import me.moallemi.sheetsapp.data.GetResponseToExpense
import java.io.File

class GoogleSheetsApp {

    fun loadDataFromFile(): String {
        val file = File(javaClass.classLoader.getResource("response.json").toURI())
        return file.readText()
    }

    suspend fun getExpenses(): List<Expense> {
        val response = fetchData()
        val mapper = GetResponseToExpense()
        return mapper.map(response)
    }

    private suspend fun fetchData(): GetResponseDto {
        val client = HttpClient() {
            install(JsonFeature) {
                serializer = KotlinxSerializer()
            }
        }
        val response: GetResponseDto = client.get(GET_ENDPOINT)
        return response
    }
}

private const val GET_ENDPOINT =
    "https://sheets.googleapis.com/v4/spreadsheets/SPREADSHEET_ID/values/A2:G?key=API_KEY"