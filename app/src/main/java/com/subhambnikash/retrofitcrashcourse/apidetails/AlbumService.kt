package com.subhambnikash.retrofitcrashcourse.apidetails

import com.subhambnikash.retrofitcrashcourse.dataclasses.AlbumModelClass
import com.subhambnikash.retrofitcrashcourse.dataclasses.AlbumModelClassItem
import retrofit2.Response
import retrofit2.http.*

interface AlbumService {


    @GET("/albums")
    suspend fun getAlbums(): Response<AlbumModelClass>

    @GET("/albums")
    suspend fun getAlbumUser(@Query("userId") userId:Int):Response<AlbumModelClass>

    @GET("/albums/{id}")
    suspend fun getAlbumPath(@Path("id") albumId:Int):Response<AlbumModelClassItem>

    @POST("/albums")
    suspend fun uploadAlbum(@Body item: AlbumModelClassItem):Response<AlbumModelClassItem>

}