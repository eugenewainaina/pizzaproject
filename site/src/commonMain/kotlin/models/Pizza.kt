package models

import kotlinx.serialization.Serializable

@Serializable
data class Pizza(
    private val id: String = "",
    private val name: String,
    private val description: String,
    private val smallPrice: Double,
    private val mediumPrice: Double,
    private val largePrice: Double,
    private val superLargePrice: Double,
    private val picturePath: String,
) {
    fun getID() = id

    fun getName() = name

    fun getDescription() = description

    fun getSmallPrice() = smallPrice

    fun getMediumPrice() = mediumPrice

    fun getLargePrice() = largePrice

    fun getSuperLargePrice() = superLargePrice
}
