package com.learning.composeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import com.learning.composeexample.ui.baseview.DefaultColumn
import com.learning.composeexample.ui.baseview.DefaultRow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DefaultColumn()
            DefaultRow()
        }
    }
}
