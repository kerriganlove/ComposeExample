package com.learning.composeexample.ui.baseview

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.learning.composeexample.R

val DefaultSnackBarHost : @Composable (SnackbarHostState) -> Unit = { _snackBarHostState ->
    val painter = painterResource(id = R.drawable.ic_click)
    val contentDescription = "Item Click"
    SnackbarHost(hostState = _snackBarHostState) { data ->
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.05f)
                .padding(10.dp)
        ) {
            Row() {
                Image(painter = painter,
                    contentDescription = contentDescription,
                    modifier = Modifier.fillMaxWidth(0.2f))
                Text(text = data.visuals.message,
                    style = TextStyle(color = Color.Black))
            }
        }
    }
}
