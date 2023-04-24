package com.learning.composeexample.ui.baseview

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.textInputServiceFactory
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Composable
fun DefaultColumn(

) {
    Column() {

    }
}

@Composable
fun DefaultRow() {

}


// State Hoisting?
@Composable
fun DefaultCard(
    modifier: Modifier = Modifier,
    painter: Painter,
    contentDescription: String,
    title: String,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = RoundedCornerShape(20.dp),

        ) {
        Box(Modifier.clickable {
            onClick()
        }) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = title,
                style = TextStyle(color = Color.White, fontSize = 14.sp),
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(5.dp)
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DefaultLazyColumnItem(
    modifier : Modifier = Modifier.basicMarquee(),
    painter : Painter,
    item : Any,
    onClick : () -> Unit = {}
) {
    Row(modifier = modifier) {
        Text(text = "")
        TitleText(fontSize = 14.sp)
        Text(text = "")
        Image(painter = painter, contentDescription = "Ranking Thumbnail")
    }
}

@Composable
fun TitleText(
    modifier : Modifier = Modifier,
    fontSize : TextUnit,

) {
    Text(
        modifier = modifier,
        style = TextStyle(fontSize =  fontSize),
        text = ""
    )
}
