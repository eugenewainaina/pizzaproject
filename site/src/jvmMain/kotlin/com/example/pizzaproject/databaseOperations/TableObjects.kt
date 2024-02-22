package com.example.pizzaproject.databaseOperations

import org.jetbrains.exposed.dao.id.UUIDTable

// tables in the Database
object Pizzas : UUIDTable(name = "Pizzas", columnName = "Pizza_ID") {
    val name = varchar("Name", 255)
    val description = text("Description")
    val smallPrice = double("Small_Price")
    val mediumPrice = double("Medium_Price")
    val largePrice = double("Large_Price")
    val superLargePrice = double("Super_Large_Price")
    val picturePath = varchar("Pizza_Picture", 255)
}

object Drinks : UUIDTable(name = "Drinks", columnName = "Drink_ID") {
    val name = varchar("Name", 255)
    val type = varchar("Type", 255)
    val price = double("Price")
}
