package com.acs.photos

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotosApi {

    @GET("photos?api_key=${Constants.API_KEY}")
    fun getPhotosAsync(@Query("sol") count: Int): Deferred<Response<PhotoResponse>>

    companion object {
        fun create(): PhotosApi {
            val retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
            return retrofit.create(PhotosApi::class.java)
        }
    }
}