# Jetpack Compose Loading Bar
This library is designed to implement various Jetpack Compose loading bars.

If you need a specific loading bar, feel free to reach out anytime.

For any inquiries or requests, please contact me at tmfrl1590@gmail.com. Thank you! 😊

<br>

| CircularLoadingSpinner | DotLoadingSpinner |
|------------------------|------------------|
| <p align="center">&nbsp;&nbsp;&nbsp;&nbsp;<img src="https://github.com/user-attachments/assets/08f10d4e-b5de-460e-93f5-7efd5a2872d5" width="150">&nbsp;&nbsp;&nbsp;&nbsp;</p> | <p align="center">&nbsp;&nbsp;&nbsp;&nbsp;<img src="https://github.com/user-attachments/assets/af4ea51f-e42e-4125-ae37-54726da93f3a" width="150">&nbsp;&nbsp;&nbsp;&nbsp;</p> |


## 📦 Installation
Add the following dependency to your **`build.gradle.kts`**:

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

## 🛠 How to Use

### 1️⃣ CircularLoadingSpinner

A smooth circular loading animation, customizable with stroke width, rotation speed, and colors.

🔹 Basic Usage
```
@Composable
fun LoadingScreen() {
    Box {
        CircularLoadingSpinner()
    }
}
```
🔹 Customizable Example

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

🔹 Properties:

color: Sets the spinner color (default: Black).

strokeWidth: Defines the thickness of the circular stroke.

diameter: Adjusts the spinner size.

sweepAngle: Controls how much of the circle is visible.

rotationSpeed: Determines the animation speed (in milliseconds).


### 2️⃣ DotLoadingSpinner

A minimalist dot-based loading animation, perfect for indicating progress subtly.

🔹 Basic Usage
```
@Composable
fun LoadingScreen() {
    Box {
        DotLoadingSpinner()
    }
}
```
🔹 Customizable Example

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

🔹 Properties:

color: Changes the color of the dots.

isReverse: Flips the animation direction.

dotCount: Defines the number of dots in the animation.

animationDuration: Controls how fast the dots animate.

dotSize: Adjusts the size of each dot.









