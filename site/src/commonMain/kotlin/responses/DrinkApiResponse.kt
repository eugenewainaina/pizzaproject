package responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import models.Drink

@Serializable
sealed class DrinkApiResponse {
    @Serializable
    @SerialName("success")
    data class Success(val data: List<Drink>) : DrinkApiResponse()

    @Serializable
    @SerialName("error")
    data class Error(val errorMessage: String) : DrinkApiResponse()
}
