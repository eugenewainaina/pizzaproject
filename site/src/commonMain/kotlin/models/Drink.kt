package models

import kotlinx.serialization.Serializable

@Serializable
data class Drink(
    private val id: String = "",
    private val name: String,
    private val type: String,
    private val price: Double,
) {
    fun getDrinkID() = id

    fun getDrinkName() = name

    fun getDrinkType() = type

    fun getDrinkPrice() = price
}
