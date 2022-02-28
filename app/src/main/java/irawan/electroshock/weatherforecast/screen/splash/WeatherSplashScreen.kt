package irawan.electroshock.weatherforecast.screen.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieCompositionSpec
import irawan.electroshock.weatherforecast.R
import irawan.electroshock.weatherforecast.navigation.WeatherScreens
import irawan.electroshock.weatherforecast.widget.Animation
import kotlinx.coroutines.delay

@Composable
fun WeatherSplashScreen(navController: NavController){
    LaunchedEffect(key1 = true){
        delay(925L)
        navController.popBackStack()
        navController.navigate(WeatherScreens.MainScreen.name)
    }
    Animation(source = LottieCompositionSpec.RawRes(R.raw.logo), size = 200)
}