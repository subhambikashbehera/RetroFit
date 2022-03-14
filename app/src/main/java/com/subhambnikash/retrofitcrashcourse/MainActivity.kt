package com.subhambnikash.retrofitcrashcourse

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.subhambnikash.retrofitcrashcourse.apidetails.AlbumService
import com.subhambnikash.retrofitcrashcourse.apidetails.ApiCallBack
import com.subhambnikash.retrofitcrashcourse.databinding.ActivityMainBinding
import com.subhambnikash.retrofitcrashcourse.dataclasses.AlbumModelClass
import com.subhambnikash.retrofitcrashcourse.dataclasses.AlbumModelClassItem
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      binding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        val retService=ApiCallBack.getRetrofitInstance().create(AlbumService::class.java)
        val responseLiveData:LiveData<Response<AlbumModelClass>> = liveData {
            val responseLiveData = retService.getAlbumUser(3)
             emit(responseLiveData)
        }

        responseLiveData.observe(this){
            val albumList=it.body()?.listIterator()
            if (albumList!=null){
                while (albumList.hasNext()){
                    val listItem=albumList.next()
                    val result="id  "+listItem.id+"\n"+"userId  "+listItem.userId+"\n"+"tittle  "+listItem.title+"\n\n\n"
                 //   binding.textView.append(result)
                }
            }
        }

        //path parameter
        val pathResponse:LiveData<Response<AlbumModelClassItem>> = liveData {
            val response=retService.getAlbumPath(5)
            emit(response)
        }



        //upload body

        val bodyResponse:LiveData<Response<AlbumModelClassItem>> = liveData {
            val response=retService.uploadAlbum(AlbumModelClassItem(101,"subham",101))
            emit(response)
        }

        bodyResponse.observe(this){
            binding.textView.text=it.body()?.title.toString()+it.body()?.id.toString()+it.body()?.userId.toString()
        }







    }





}