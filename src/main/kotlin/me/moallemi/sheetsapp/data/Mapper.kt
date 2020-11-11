package me.moallemi.sheetsapp.data

interface Mapper<Input, Output> {
    fun map(input: Input): Output
}