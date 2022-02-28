package irawan.electroshock.weatherforecast.network

import irawan.electroshock.weatherforecast.model.Weather
import irawan.electroshock.weatherforecast.util.Constants
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface WeatherApi {

    @GET("weather")
    suspend fun getWeather(
        @Query("lat") lat:Double = 52.23704,
        @Query("lon") lon:Double = 21.017532,
        @Query("appid") apiKey:String = Constants.API_KEY ): Weather

}