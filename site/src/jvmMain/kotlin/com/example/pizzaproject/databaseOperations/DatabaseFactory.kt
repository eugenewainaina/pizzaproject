@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.example.pizzaproject.databaseOperations

import models.Drink
import models.Pizza
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction
import java.io.FileInputStream
import java.util.*
import kotlin.collections.ArrayList

const val DB_PROPERTIES_PATH = ""

object DatabaseFactory {
    init {
        val properties = Properties()

        properties.load(
            FileInputStream(DB_PROPERTIES_PATH),
        )

        Database.connect(
            url = properties.getProperty("database.url"),
            driver = properties.getProperty("database.driver"),
            user = properties.getProperty("database.user"),
            password = properties.getProperty("database.password"),
        )
    }

    fun getPizzas(): ArrayList<Pizza> {
        val pizzas = arrayListOf<Pizza>()

        transaction {
            val query = Pizzas.selectAll()
            query.forEach {
                pizzas.add(
                    Pizza(
                        id = it[Pizzas.id].toString(),
                        name = it[Pizzas.name],
                        description = it[Pizzas.description],
                        smallPrice = it[Pizzas.smallPrice],
                        mediumPrice = it[Pizzas.mediumPrice],
                        largePrice = it[Pizzas.largePrice],
                        superLargePrice = it[Pizzas.superLargePrice],
                        picturePath = it[Pizzas.picturePath],
                    ),
                )
            }
        }

        return pizzas
    }

    fun getDrinks(): ArrayList<Drink> {
        val drinks = arrayListOf<Drink>()

        transaction {
            try {
                val query = Drinks.selectAll()
                query.forEach {
                    drinks.add(
                        Drink(
                            id = it[Drinks.id].toString(),
                            name = it[Drinks.name],
                            type = it[Drinks.type],
                            price = it[Drinks.price],
                        ),
                    )
                }
                println("getDrinks transaction successful")
            } catch (e: Exception) {
                println("getDrinks transaction failed: ${e.message}")
            }
        }

        return drinks
    }
}
