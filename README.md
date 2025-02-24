# Jetpack Compose Loading Bar

### Add Dependency
Add the following dependency in your build.gradle.kts

```
dependencies {
    implementation("com.github.tmfrl1590:ComposeLoadingBar:<version>")
}
```

```
dependencyResolutionManagement {
    repositories {
        maven { url = uri("https://jitpack.io") }
    }
}
```

### Use

Basic Example

```
CircularLoadingSpinner()
```

Usage in Compose Layout

```
@Composable
fun LoadingScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularLoadingSpinner(
            color = Color.Green,
            strokeWidth = 5.dp,
            diameter = 70.dp,
            sweepAngle = 240f,
            rotationSpeed = 1000
        )
    }
}
```
