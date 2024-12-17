# Multiplatform Swiper for [Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform)

This Compose Multiplatform/Kotlin Multiplatform Library, based on and developed off the [Jetpack Compose Swiper](https://github.com/lhoyong/swiper) as well as the [Compose Multiplatform Library Template](https://github.com/KevinnZou/compose-multiplatform-library-template), provides an easy and intuitive way of integrating a Tinder-like Swiper in your Jetpack Compose[^1]/Compose Multiplatform/Compose for Desktop.

## Dependencies
| Compose Multiplatform (in commonMain source set)                   | Jetpack Compose[^1]                                                        | Compose for Desktop                                                        |
|--------------------------------------------------------------------|----------------------------------------------------------------------------|----------------------------------------------------------------------------|
| `implementation("io.github.veronatus:multiplatform-swiper:0.0.2")` | `implementation("io.github.veronatus:multiplatform-swiper-android:0.0.2")` | `implementation("io.github.veronatus:multiplatform-swiper-desktop:0.0.2")` |

For more details, platforms and dependency managers visit [the according Maven Central Repository pages](https://central.sonatype.com/artifact/io.github.veronatus/multiplatform-swiper).

## Usage
We recommend the use of the library in small decision-making games. The component can be used as seen in the sample or for a larger example as in the [upstream repository](https://github.com/lhoyong/swiper).

## Plans
The library will be actively maintained, as it is used in our own projects. Planned features include:
- [Updating the old Swipable to the new Foundation Anchored Draggable APIs](https://developer.android.com/develop/ui/compose/touch-input/pointer-input/migrate-swipeable?hl=de)
- Adding more swiping directions, especially Up
- Updating Kotlin and Compose versions
  
If you have other feature requests/bugs or want to help with the ones above, we would be grateful for submitting them as an issue or PR!

[^1]: Should work, but I am genuinely too lazy to test. If in doubt, use the mentioned Jetpack Compose component or alternatives.
