package com.starkindustires.timetable.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.starkindustires.timetable.R
import com.starkindustires.timetable.activities.MainActivity.statified.day
import com.starkindustires.timetable.adapter.MainScreenAdapter

class MainActivity : AppCompatActivity() {

    var dayRecycler: RecyclerView? = null

    object statified {
        var day = arrayListOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dayRecycler = findViewById(R.id.Recycler1)
        dayRecycler?.layoutManager = LinearLayoutManager(this)
        dayRecycler?.adapter = MainScreenAdapter(day, this)

    }
}
