package com.learning.composeexample

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.learning.composeexample.ui.baseview.DefaultCard
import com.learning.composeexample.ui.baseview.DefaultColumn
import com.learning.composeexample.ui.baseview.DefaultRow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val painter = painterResource(id = R.drawable.test_image)
            val title = "Test Image"
            val description = "Lovelyz Album Shot"
            Column() {
                DefaultCard(modifier = Modifier.fillMaxWidth(0.4f).padding(12.dp),painter = painter, contentDescription = description, title = title)
                Spacer(modifier = Modifier.fillMaxHeight(0.1f))
                DefaultCard(modifier = Modifier.fillMaxWidth(0.3f).padding(12.dp), painter = painter, contentDescription = "SnackBar Test" , title = "Lovelyz so STRANGE")
            }
        }
    }
}
