import androidx.compose.runtime.Composable
import java.awt.Toolkit

@Composable
actual fun getScreenWidthPx() = Toolkit.getDefaultToolkit().screenSize.width.toFloat()
