# Jetpack Compose Loading Bar
This library is designed to implement a variety of loading screens in Jetpack Compose.

## Add Dependency
Add the following dependency in your build.gradle.kts

```
dependencies {
    implementation("com.github.tmfrl1590:JetpackComposeLoadingBar:<version>")
}
```

```
dependencyResolutionManagement {
    repositories {
        maven { url = uri("https://jitpack.io") }
    }
}
```
---
## How to Use

### 1. CircularLoadingSpinner

Basic Example
```
@Composable
fun LoadingScreen() {
    Box {
        CircularLoadingSpinner()
    }
}
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

### 2. DotLoadingSpinner
   Basic Example
```
@Composable
fun LoadingScreen() {
    Box {
        DotLoadingSpinner()
    }
}
```
Usage in Compose Layout

```
@Composable
fun LoadingScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        DotLoadingSpinner(
            color = Color.Black,
            isReverse = true,
            dotCount = 3,
            animationDuration = 100,
            dotSize = 20.dp
        )
    }
}
```


|CircularLoadingSpinner|DotLoadingSpinner|
|------|---|
|https://github.com/user-attachments/assets/b83c647f-33fb-4945-bd40-916d1f8ac6d9|https://github.com/user-attachments/assets/0418db3f-a8bc-4112-bdbb-c787f7026ea5|





