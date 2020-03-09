package com.acs.photos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    private lateinit var listAdapter: PhotoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listAdapter = PhotoAdapter(this).also {
            it.setLists(getPhotos())
        }

        camera_list?.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = listAdapter
            isNestedScrollingEnabled = false
            addItemDecoration(DividerItemDecoration(context, LinearLayout.VERTICAL))
        }
    }

    private fun getPhotos():List<Photo> {
        var photos: List<Photo> = listOf()
        runBlocking {
            val service = PhotosApi.create()
            val request = service.getPhotosAsync(10)
            val response = request.await()
            if (response.isSuccessful) {
                response.body()?.let {
                    photos = it.photos
                }
            }
        }
        return photos
    }
}

