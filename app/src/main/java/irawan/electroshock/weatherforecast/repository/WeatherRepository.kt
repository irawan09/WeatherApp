package irawan.electroshock.weatherforecast.repository

import android.provider.ContactsContract
import android.util.Log
import irawan.electroshock.weatherforecast.data.DataOrException
import irawan.electroshock.weatherforecast.model.Weather
import irawan.electroshock.weatherforecast.network.WeatherApi
import irawan.electroshock.weatherforecast.util.Constants
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api: WeatherApi) {

    suspend fun getWeather():DataOrException<Weather, Boolean, Exception>{
        val response = try {
            api.getWeather()
        }catch (e:Exception){
            Log.e(Constants.STATUS,"RETROFIT ERROR: ${e.message}" )
            return DataOrException(e=e)
        }
        return DataOrException(data=response)
    }
}