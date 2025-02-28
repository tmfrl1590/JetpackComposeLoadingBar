# Jetpack Compose Loading Bar
This library is designed to implement various Jetpack Compose loading bars.

If you need a specific loading bar, feel free to reach out anytime.

For any inquiries or requests, please contact me at tmfrl1590@gmail.com. Thank you! 😊

<br>

| CircularLoadingSpinner | SquareSpinner |
|------------------------|--------------|
| <p align="center"><img src="https://github.com/user-attachments/assets/d62e186b-dbd2-458c-ac23-4a62e3c5bd60" width="150"></p> | <p align="center"><img src="https://github.com/user-attachments/assets/c9bfbe81-eb66-4fac-bb20-b8b22c59da55" width="150"></p> |

| DotLoadingSpinner | DotRippleSpinner |
|------------|------------------|
| <p align="center"><img src="https://github.com/user-attachments/assets/af4ea51f-e42e-4125-ae37-54726da93f3a" width="150"></p> | <p align="center"><img src="https://github.com/user-attachments/assets/ee878563-5f46-49ac-9bf0-d73da97ce427" width="150"></p> |




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


### 2️⃣ SquareSpinner

A square-shaped loading animation that gradually draws a rounded square in a clockwise direction.

🔹 Basic Usage
```
@Composable
fun LoadingScreen() {
    Box {
        SquareSpinner()
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
        SquareSpinner(
            strokeColor = Color.Blue,
            strokeWidth = 6.dp,
            size = 60.dp,
            animationDuration = 1500,
            cornerRadius = 12.dp
        )
    }
}
```

🔹 Properties:

strokeColor: Sets the color of the square outline (default: Black).

strokeWidth: Defines the thickness of the square stroke.

size: Adjusts the overall size of the spinner.

animationDuration: Controls how long it takes to complete drawing the square.

cornerRadius: Sets the radius of the rounded corners. If set to 0.dp, the spinner will be a perfect square.


### 3️⃣ DotLoadingSpinner

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


### 4️⃣ DotRippleSpinner

A dynamic dot-based ripple animation that adds a ripple effect to each dot, providing a visually engaging loading indicator.

🔹 Basic Usage
```
@Composable
fun LoadingScreen() {
    Box {
        DotRippleSpinner()
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
        DotRippleSpinner(
            color = Color.Black,
            dotCount = 4,
            rippleSpeed = 100,
            dotSize = 16.dp,
            dotSpacing = 8.dp,
            dotShape = CircleShape,
        )
    }
}
```

🔹 Properties

color: Changes the color of the dots (default: Black).

dotCount: Defines the number of dots in the animation.

rippleSpeed: Controls the speed of the ripple animation; the total animation duration is calculated as rippleSpeed * dotCount.

dotSize: Adjusts the size of each dot.

dotSpacing: Sets the spacing between the dots.

dotShape: Determines the shape of each dot in the animation (default: CircleShape).



