package com.dunzi.storyhouse.ui.setting

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import coil.compose.AsyncImage

// Minimal skeleton to unblock build; replace with full UI later
@Composable
fun SettingScreen() {
    var name by remember { mutableStateOf("") }
    Text(text = "Settings", modifier = Modifier.fillMaxWidth().background(Color.Transparent))
    AsyncImage(model = null, contentDescription = null)
}
