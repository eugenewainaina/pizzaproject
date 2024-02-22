package com.example.pizzaproject.api

import com.example.pizzaproject.databaseOperations.DatabaseFactory
import com.varabyte.kobweb.api.Api
import com.varabyte.kobweb.api.ApiContext
import com.varabyte.kobweb.api.http.setBodyText
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import models.Pizza
import responses.PizzaApiResponse

private val pizzaList: List<Pizza> = DatabaseFactory.getPizzas()

@Api
suspend fun getPizza(context: ApiContext) {
    try {
        context.res.setBodyText(
            Json.encodeToString<PizzaApiResponse>(
                PizzaApiResponse.Success(data = pizzaList),
            ),
        )
    } catch (e: Exception) {
        context.res.setBodyText(
            Json.encodeToString<PizzaApiResponse>(
                PizzaApiResponse.Error(errorMessage = e.message.toString()),
            ),
        )
    }
}
