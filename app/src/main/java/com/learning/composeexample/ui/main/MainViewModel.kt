package com.learning.composeexample.ui.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.learning.composeexample.ui.state.CardUiState


class MainViewModel : ViewModel() {

    var uiState by mutableStateOf(CardUiState())
        private set
    init {
        // TODO Data -> UiState Transfer
    }
}