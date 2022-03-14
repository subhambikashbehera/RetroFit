package com.subhambnikash.retrofitcrashcourse.apidetails

import com.google.gson.GsonBuilder
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiCallBack {

    companion object{
        private val interceptor=HttpLoggingInterceptor().apply {
            this.level=HttpLoggingInterceptor.Level.BODY
        }
        private val client=OkHttpClient.Builder().apply {
            this.addInterceptor(interceptor)
                .connectTimeout(30,TimeUnit.SECONDS)
                .readTimeout(20,TimeUnit.SECONDS)
                .writeTimeout(25,TimeUnit.SECONDS)
        }.build()

      private const val baseUrL="https://jsonplaceholder.typicode.com/"
            fun getRetrofitInstance():Retrofit{
                return Retrofit.Builder()
                    .baseUrl(baseUrL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                    .build()
            }
    }
}