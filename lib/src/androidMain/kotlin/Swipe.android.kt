import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

@Composable
actual fun getScreenWidthPx(): Float = with(LocalConfiguration.current) {
    LocalDensity.current.run { screenWidthDp.dp.toPx() }
}