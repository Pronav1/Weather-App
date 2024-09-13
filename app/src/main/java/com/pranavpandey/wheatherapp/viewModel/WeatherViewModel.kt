package com.pranavpandey.wheatherapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pranavpandey.wheatherapp.api.Constant
import com.pranavpandey.wheatherapp.api.NetworkResponse
import com.pranavpandey.wheatherapp.api.RetrofitInstance
import com.pranavpandey.wheatherapp.api.WeatherModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeatherViewModel: ViewModel() {
private val weatherApi = RetrofitInstance.weatherApi
    private val _weatherResult = MutableLiveData<NetworkResponse<WeatherModel>>()
 val weatherResult : LiveData<NetworkResponse<WeatherModel>> = _weatherResult
    fun getData(city: String){
        _weatherResult.value = NetworkResponse.Loding
        viewModelScope.launch {
            try {
                val response = weatherApi.getWeather(Constant.apiKey, city)
                if (response.isSuccessful) {
                    _weatherResult.value = NetworkResponse.Success(response.body()!!)
                } else {
                    _weatherResult.value = NetworkResponse.Error("Failed to load data")
                }
            } catch (e: Exception) {
                _weatherResult.value = NetworkResponse.Error("Failed to load data")
            }
        }
    }
}