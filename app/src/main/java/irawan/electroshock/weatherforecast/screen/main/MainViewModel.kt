package irawan.electroshock.weatherforecast.screen.main

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import irawan.electroshock.weatherforecast.data.DataOrException
import irawan.electroshock.weatherforecast.model.Weather
import irawan.electroshock.weatherforecast.repository.WeatherRepository
import irawan.electroshock.weatherforecast.util.Constants
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: WeatherRepository): ViewModel() {

    val data:MutableState<DataOrException<Weather, Boolean, Exception>> =
        mutableStateOf(DataOrException(null, true, Exception("")))

    init {
        loadWeather()
    }

    private fun loadWeather() {
        viewModelScope.launch {
            data.value.loading = true
            data.value = repository.getWeather()
            if (data.value.data.toString().isNotEmpty()) {
                data.value.loading = false
            }
        }
        Log.d(Constants.STATUS, "Data : ${data.value.data}")
    }
}