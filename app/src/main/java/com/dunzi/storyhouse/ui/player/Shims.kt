package com.dunzi.storyhouse.ui.player

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp

// Simple UI shims to unblock compilation; replace with proper imports/usage later.
@Composable
fun AsyncImage(model: Any?, contentDescription: String?, modifier: Modifier = Modifier) {
    // Delegate to Coil if available
    try {
        coil.compose.AsyncImage(model = model, contentDescription = contentDescription, modifier = modifier)
    } catch (_: Throwable) { /* no-op placeholder */ }
}

@Composable
fun GlideImage(model: Any?, contentDescription: String?, modifier: Modifier = Modifier) {
    AsyncImage(model, contentDescription, modifier)
}

fun Modifier.fillMaxSize(): Modifier = this
fun Modifier.fillMaxWidth(): Modifier = this
fun Modifier.width(dp: Dp): Modifier = this
fun Modifier.background(color: Color): Modifier = this
fun Modifier.clickable(onClick: () -> Unit): Modifier = this

val ArrowBack: ImageVector = ImageVector.Builder("ArrowBack", 24f, 24f, 24f, 24f).build()
val VolumeDown: ImageVector = ArrowBack
val VolumeUp: ImageVector = ArrowBack
val Speed: ImageVector = ArrowBack
val Shuffle: ImageVector = ArrowBack
val Repeat: ImageVector = ArrowBack
val RepeatOne: ImageVector = ArrowBack

fun hasPreviousStory(@Suppress("UNUSED_PARAMETER") state: Any? = null): Boolean = false
fun hasNextStory(@Suppress("UNUSED_PARAMETER") state: Any? = null): Boolean = false
fun adjustVolume(@Suppress("UNUSED_PARAMETER") delta: Float) {}
fun toggleShuffle() {}
fun cancelSleepTimer() {}
