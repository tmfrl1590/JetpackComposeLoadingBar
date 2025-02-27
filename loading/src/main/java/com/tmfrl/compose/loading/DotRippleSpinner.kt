package com.tmfrl.compose.loading

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * DotRippleSpinner Composable Function
 *
 * This function implements a dot ripple animation based on the provided settings.
 *
 * @param modifier Modifier to apply to the composable.
 * @param color The color of the dots (default: Black).
 * @param dotCount The number of dots to be displayed.
 * @param rippleSpeed The animation duration (in ms) for each dot. The total animation duration is calculated as rippleSpeed * dotCount.
 * @param dotSize The size of each dot.
 * @param dotSpacing The spacing between dots.
 * @param dotShape The shape of the dots (default: CircleShape). Can be customized to support squares, rounded corners, etc.
 */

@Composable
fun DotRippleSpinner(
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    dotCount: Int = 4,
    rippleSpeed: Int = 100,
    dotSize: Dp = 16.dp,
    dotSpacing: Dp = 8.dp,
    dotShape: Shape = CircleShape
) {
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val progress by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = rippleSpeed * dotCount, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = ""
    )

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(dotSpacing)
    ) {
        for (index in 0 until dotCount) {
            val phase = (progress + index.toFloat() / dotCount) % 1f
            val scale = ((kotlin.math.sin(phase * 2 * Math.PI) + 1) / 2) * 0.5f + 0.5f
            Box(
                modifier = Modifier
                    .size(dotSize)
                    .scale(scale.toFloat())
                    .background(color, dotShape)
            )
        }
    }
}