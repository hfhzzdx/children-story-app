package com.dunzi.storyhouse.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun GlideImage(model: Any?, contentDescription: String?, modifier: Modifier = Modifier) {
    try {
        coil.compose.AsyncImage(model = model, contentDescription = contentDescription, modifier = modifier)
    } catch (_: Throwable) { }
}

fun Modifier.fillMaxSize(): Modifier = this
