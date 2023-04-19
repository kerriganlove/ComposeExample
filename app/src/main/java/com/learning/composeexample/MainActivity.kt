package com.learning.composeexample

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.learning.composeexample.ui.baseview.DefaultCard
import com.learning.composeexample.ui.baseview.DefaultColumn
import com.learning.composeexample.ui.baseview.DefaultRow
import com.learning.composeexample.ui.baseview.DefaultSnackBarHost
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val painter = painterResource(id = R.drawable.test_image)
            val title = "Test Image"
            val description = "Lovelyz Album Shot"

            val defaultScope = rememberCoroutineScope()
            val snackBarHost = remember { SnackbarHostState() }
            Scaffold(
                snackbarHost = { DefaultSnackBarHost(snackBarHost) }
            ) { value ->
                Column() {
                    DefaultCard(modifier = Modifier
                        .fillMaxWidth(0.4f)
                        .padding(value),
                        painter = painter,
                        contentDescription = description,
                        title = title,
                        onClick = {
                            defaultScope.launch {
                                snackBarHost.showSnackbar(title)
                            }
                        })
                    Spacer(modifier = Modifier.fillMaxHeight(0.1f))
                    DefaultCard(modifier = Modifier
                        .fillMaxWidth(0.3f)
                        .padding(value),
                        painter = painter,
                        contentDescription = "SnackBar Test",
                        title = "Lovelyz so STRANGE",
                        onClick = {
                            defaultScope.launch {
                                snackBarHost.showSnackbar("Lovelyz so STRANGE")
                            }
                        })
                }
            }
        }
    }
}
