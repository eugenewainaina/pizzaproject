package com.example.pizzaproject.api

import com.example.pizzaproject.databaseOperations.DatabaseFactory
import com.varabyte.kobweb.api.Api
import com.varabyte.kobweb.api.ApiContext
import com.varabyte.kobweb.api.http.setBodyText
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import models.Drink
import responses.DrinkApiResponse

private val drinkList: List<Drink> = DatabaseFactory.getDrinks()

@Api
suspend fun getDrink(context: ApiContext) {
    // DatabaseFactory

    try {
        context.res.setBodyText(
            Json.encodeToString<DrinkApiResponse>(
                DrinkApiResponse.Success(data = drinkList),
            ),
        )
    } catch (e: Exception) {
        context.res.setBodyText(
            Json.encodeToString<DrinkApiResponse>(
                DrinkApiResponse.Error(errorMessage = e.message.toString()),
            ),
        )
    }
}
