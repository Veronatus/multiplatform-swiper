package io.github.veronatus.multiplatformswiper

import androidx.compose.foundation.layout.Box
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun App() {
    MaterialTheme {
        val textList = listOf("According", "To", "All", "Known", "Laws", "Of", "Aviation")
        val swiperState = rememberSwiperState()
        var index by mutableStateOf(0)

        Swiper(
            count = textList.size,
            state = swiperState,
            onSwiped = {
                print("Swiped")
                index++
            },
            onSwipeLeft = { println(" left!") },
            onSwipeRight = { println(" right!") },
        ) {
            Box {
                Text(textList[index])
            }
        }
    }
}
