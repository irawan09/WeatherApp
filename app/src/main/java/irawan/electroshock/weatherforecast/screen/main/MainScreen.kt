package irawan.electroshock.weatherforecast.screen.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import irawan.electroshock.weatherforecast.data.DataOrException
import irawan.electroshock.weatherforecast.model.Weather

@Composable
fun MainScreen(navController: NavController, mainViewModel: MainViewModel){
    ShowData(mainViewModel)
}

@Composable
fun ShowData(mainViewModel: MainViewModel){
    val weatherData = produceState<DataOrException<Weather, Boolean, Exception>>(
        initialValue = DataOrException(loading = true)){
        value = mainViewModel.data.value
    }.value

    if (weatherData.loading == true){
        CircularProgressIndicator()
    } else if (weatherData.data != null) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 8.dp)) {

            Text("Main Screen data : ${weatherData.data?.sys?.country}")
        }

    }


}