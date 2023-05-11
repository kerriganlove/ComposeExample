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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.RequestManager
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory
import com.learning.composeexample.R
import com.learning.composeexample.ui.theme.ExampleTypography
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
        TitleText(title = "title")
        // ImageCard 구현.
        Image(painter = painter, contentDescription = "Ranking Thumbnail")
        Text(text = "")
    }
}

@Composable
fun TitleText(
    title : String,
    titleStyle : TextStyle = ExampleTypography.bodyMedium
) {
    Text(
        modifier = Modifier,
        style = titleStyle,
        text = title
    )
}


// LazyRow의 ImageCard 아이템 View
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ImageCard(
    modifier : Modifier = Modifier,
    image : String,
    contentDescription : String? = null,
    title : String = "",
    requestManager : RequestManager,
    defaultImage : Painter = painterResource(id = R.drawable.default_image_card),
    onClick : () -> Unit = {}
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
            GlideImage(model = image,
                contentDescription = contentDescription,
                modifier = modifier) {
                it.thumbnail(requestManager.asDrawable().load(defaultImage))
            }
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

