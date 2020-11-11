package me.moallemi.sheetsapp

import kotlinx.serialization.Serializable

@Serializable
data class GetResponseDto(
    val range: String,
    val majorDimension: String,
    val values: List<List<String>>
)