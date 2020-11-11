package me.moallemi.sheetsapp.data

import me.moallemi.sheetsapp.GetResponseDto

class GetResponseToExpense : Mapper<GetResponseDto, List<Expense>> {

    override fun map(input: GetResponseDto): List<Expense> {
        val items = mutableListOf<Expense>()
        for (item in input.values) {
            val expense = Expense(
                title = item[0],
                description = item[1],
                category = item[2],
                price = item[3].replace(",", "").toLong(),
                date = item[4],
                tag1 = if (item.size > 5) item[5] else "",
                tag2 = if (item.size > 6) item[6] else ""
            )
            items.add(expense)
        }
        return items
    }
}