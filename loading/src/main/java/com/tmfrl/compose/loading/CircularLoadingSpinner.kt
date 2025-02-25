package com.tmfrl.compose.loading

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CircularLoadingSpinner(
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    strokeWidth: Dp = 4.dp,
    diameter: Dp = 50.dp,
    sweepAngle: Float = 270f,
    rotationSpeed: Int = 1200,
) {
    val infiniteTransition = rememberInfiniteTransition(label = "")

    val rotateAngle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = rotationSpeed, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = ""
    )

    Canvas(modifier = modifier.size(diameter)) {
        val strokeWidthPx = strokeWidth.toPx()
        val radius = size.minDimension / 2
        val arcRadius = radius - strokeWidthPx / 2

        drawArc(
            color = color,
            startAngle = rotateAngle,
            sweepAngle = sweepAngle,
            useCenter = false,
            style = Stroke(width = strokeWidthPx, cap = StrokeCap.Round),
            size = Size(arcRadius * 2, arcRadius * 2),
            topLeft = Offset((size.width - arcRadius * 2) / 2, (size.height - arcRadius * 2) / 2)
        )
    }
}