package responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import models.Pizza

@Serializable
sealed class PizzaApiResponse {
    @Serializable
    @SerialName("success")
    data class Success(val data: List<Pizza>) : PizzaApiResponse()

    @Serializable
    @SerialName("error")
    data class Error(val errorMessage: String) : PizzaApiResponse()
}
