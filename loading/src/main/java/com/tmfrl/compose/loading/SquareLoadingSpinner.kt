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
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.min

/**
 * SquareSpinner Composable
 *
 * A customizable square-shaped loading animation for Jetpack Compose.
 * The spinner gradually draws a rounded square in a clockwise direction.
 *
 * @param modifier Modifier to apply to the composable.
 * @param strokeColor The color of the square outline (default: Black).
 * @param strokeWidth The thickness of the stroke in dp (default: 4.dp).
 * @param size The overall size of the spinner (default: 50.dp).
 * @param animationDuration The duration for the square to complete drawing (default: 1200ms).
 * @param cornerRadius The radius of the rounded corners. Set to 0.dp for a perfect square, or a positive value for rounded corners (default: 10.dp).
 *
 * Example usage:
 * ```
 * @Composable
 * fun LoadingScreen() {
 *     Box(
 *         modifier = Modifier.fillMaxSize(),
 *         contentAlignment = Alignment.Center
 *     ) {
 *         SquareDrawingSpinner(
 *             strokeColor = Color.Blue,
 *             strokeWidth = 6.dp,
 *             size = 60.dp,
 *             animationDuration = 1500,
 *             cornerRadius = 12.dp
 *         )
 *     }
 * }
 * ```
 */
@Composable
fun SquareSpinner(
    modifier: Modifier = Modifier,
    strokeColor: Color = Color.Black,
    strokeWidth: Dp = 4.dp,
    size: Dp = 50.dp,
    animationDuration: Int = 1200,
    cornerRadius: Dp = 10.dp,
) {
    val infiniteTransition = rememberInfiniteTransition(label = "")

    val progress by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = animationDuration, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = ""
    )

    Canvas(
        modifier = modifier.size(size)
    ) {
        val strokeWidthPx = strokeWidth.toPx()
        val squareSize = size.toPx() - strokeWidthPx
        val radiusPx = cornerRadius.toPx() // Rounded corner radius

        val path = Path()

        val topLeft = Offset(strokeWidthPx / 2, strokeWidthPx / 2)
        val topRight = Offset(squareSize + strokeWidthPx / 2, strokeWidthPx / 2)
        val bottomRight = Offset(squareSize + strokeWidthPx / 2, squareSize + strokeWidthPx / 2)
        val bottomLeft = Offset(strokeWidthPx / 2, squareSize + strokeWidthPx / 2)

        val totalLength = squareSize * 4 // Total perimeter of the square
        val currentLength = totalLength * progress // Current drawn length

        var remainingLength = currentLength

        path.moveTo(topLeft.x + radiusPx, topLeft.y)

        // Draw top edge
        if (remainingLength > 0) {
            val segment = min(remainingLength, squareSize - 2 * radiusPx)
            path.lineTo(topLeft.x + radiusPx + segment, topLeft.y)
            remainingLength -= segment
        }

        // Round top-right corner
        if (remainingLength > 0) {
            path.arcTo(
                rect = Rect(
                    topRight.x - 2 * radiusPx,
                    topRight.y,
                    topRight.x,
                    topRight.y + 2 * radiusPx
                ),
                startAngleDegrees = 270f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
            remainingLength -= radiusPx
        }

        // Draw right edge
        if (remainingLength > 0) {
            val segment = min(remainingLength, squareSize - 2 * radiusPx)
            path.lineTo(topRight.x, topRight.y + radiusPx + segment)
            remainingLength -= segment
        }

        // Round bottom-right corner
        if (remainingLength > 0) {
            path.arcTo(
                rect = Rect(
                    bottomRight.x - 2 * radiusPx,
                    bottomRight.y - 2 * radiusPx,
                    bottomRight.x,
                    bottomRight.y
                ),
                startAngleDegrees = 0f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
            remainingLength -= radiusPx
        }

        // Draw bottom edge
        if (remainingLength > 0) {
            val segment = min(remainingLength, squareSize - 2 * radiusPx)
            path.lineTo(bottomRight.x - radiusPx - segment, bottomRight.y)
            remainingLength -= segment
        }

        // Round bottom-left corner
        if (remainingLength > 0) {
            path.arcTo(
                rect = Rect(
                    bottomLeft.x,
                    bottomLeft.y - 2 * radiusPx,
                    bottomLeft.x + 2 * radiusPx,
                    bottomLeft.y
                ),
                startAngleDegrees = 90f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
            remainingLength -= radiusPx
        }

        // Draw left edge
        if (remainingLength > 0) {
            val segment = min(remainingLength, squareSize - 2 * radiusPx)
            path.lineTo(bottomLeft.x, bottomLeft.y - radiusPx - segment)
            remainingLength -= segment
        }

        // Round top-left corner
        if (remainingLength > 0) {
            path.arcTo(
                rect = Rect(
                    topLeft.x,
                    topLeft.y,
                    topLeft.x + 2 * radiusPx,
                    topLeft.y + 2 * radiusPx
                ),
                startAngleDegrees = 180f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
            remainingLength -= radiusPx
        }

        drawPath(
            path = path,
            color = strokeColor,
            style = Stroke(width = strokeWidthPx, cap = StrokeCap.Round)
        )
    }
}