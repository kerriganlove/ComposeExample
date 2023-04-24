package com.learning.composeexample.model.data

import com.learning.composeexample.ui.state.CardUiState


data class CardData(
    val title : String = "",
    val desc : String = "",
    val image : String = "",
    val adultTag : String = "None"
)

fun CardData.toCardUiState() : CardUiState {
    return CardUiState(
        title = title,
        desc = desc,
        image = image,
        adultTag = adultTag
    )
}