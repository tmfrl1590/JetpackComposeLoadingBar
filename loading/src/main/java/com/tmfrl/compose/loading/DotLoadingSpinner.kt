package com.tmfrl.compose.loading

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

/**
 * DotLoadingSpinner Composable
 *
 * A simple dot-based loading animation for Jetpack Compose.
 * The dots scale up and down sequentially to create a smooth loading effect.
 * Supports customization of color, speed, number of dots, size, and animation direction.
 *
 * @param modifier Modifier to apply to the composable.
 * @param color The color of the dots (default: Black).
 * @param isReverse If true, the animation plays in reverse order (default: false).
 * @param dotCount The number of dots in the animation (default: 4).
 * @param animationDuration The duration of each dot's animation in milliseconds (default: 100ms).
 * @param dotSize The size of each dot (default: 20.dp).
 *
 * Example usage:
 * ```
 * @Composable
 * fun LoadingScreen() {
 *     Box(
 *         modifier = Modifier.fillMaxSize(),
 *         contentAlignment = Alignment.Center
 *     ) {
 *         DotLoadingSpinner(
 *             color = Color.Red,
 *             isReverse = true,
 *             dotCount = 5,
 *             animationDuration = 150,
 *             dotSize = 16.dp
 *         )
 *     }
 * }
 * ```
 */

@Composable
fun DotLoadingSpinner(
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    isReverse: Boolean = false,
    dotCount: Int = 4,
    animationDuration: Int = 100,
    dotSize: Dp = 20.dp,
) {
    val scales = List(dotCount) { remember { Animatable(0.5f) } }

    LaunchedEffect(Unit) {
        while (true) {
            val indices = if (isReverse) (dotCount - 1 downTo 0) else (0 until dotCount)
            for (index in indices) {
                scales[index].animateTo(
                    targetValue = 1f,
                    animationSpec = tween(animationDuration)
                )
                scales[index].animateTo(
                    targetValue = 0.5f,
                    animationSpec = tween(animationDuration)
                )
                delay(animationDuration.toLong())
            }
        }
    }

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        scales.forEach { scale ->
            Box(
                modifier = Modifier
                    .size(dotSize)
                    .scale(scale.value)
                    .background(color, CircleShape)
            )
        }
    }
}