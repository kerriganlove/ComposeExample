package com.learning.composeexample.ui.baseview

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DefaultColumn(

) {
    Column() {

    }
}

@Composable
fun DefaultRow() {

}

@Composable
@Preview
fun DefaultCard(
    modifier : Modifier = Modifier,
    painter : Painter,
    contentDescription : String,
    title : String
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),

    ) {
        Box(Modifier.clickable {

        }) {
            Image(painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxWidth())
            Text(text = title,
                style = TextStyle(color = Color.White, fontSize = 14.sp),
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(5.dp))
        }
    }
}

@Composable
fun DefaultSnackBar(description : String) {
    val name by remember { mutableStateOf(description) }
}