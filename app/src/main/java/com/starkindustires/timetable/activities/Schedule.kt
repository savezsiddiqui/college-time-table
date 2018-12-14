package com.starkindustires.timetable.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.starkindustires.timetable.R
import com.starkindustires.timetable.TimeTable
import com.starkindustires.timetable.activities.MainActivity.statified.day
import com.starkindustires.timetable.adapter.MainScreenAdapter.statified.pos
import com.starkindustires.timetable.adapter.ScheduleScreenAdapter

class Schedule : AppCompatActivity() {

    var scheduleRecycler: RecyclerView? = null
    var getschedule: ArrayList<TimeTable>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        title = day[pos]
        setContentView(R.layout.activity_schedule)
        getschedule = dataLoader()
        scheduleRecycler = findViewById(R.id.Recycler2)
        scheduleRecycler?.layoutManager = LinearLayoutManager(this)
        scheduleRecycler?.adapter = ScheduleScreenAdapter(getschedule as ArrayList<TimeTable>, this)
    }

    fun dataLoader(): ArrayList<TimeTable> {

        var arrayList = ArrayList<TimeTable>()

        when (pos) {
            0 -> {
                arrayList.add(TimeTable("Computer Organization And Architecture", 9, "G5"))
                arrayList.add(TimeTable("Introduction to Digital Systems", 10, "F8"))
                arrayList.add(TimeTable("Data Structures", 11, "FF5"))
                arrayList.add(TimeTable("Data Structures", 12, "TS9"))
                arrayList.add(TimeTable("Data Structures Lab", 2, "CL1"))
                arrayList.add(TimeTable("Introduction to Digital Systems", 4, "F4"))
            }

            1 -> {
                arrayList.add(TimeTable("Computer Organization And Architecture", 11, "G5"))
                arrayList.add(TimeTable("Computer Organization And Architecture", 12, "TS11"))
                arrayList.add(TimeTable("Database Systems And Web", 2, "G5"))
            }

            2 -> {
                arrayList.add(TimeTable("Financial Accounting", 9, "TS9"))
                arrayList.add(TimeTable("Introduction to Digital WebSystems", 10, "F8"))
                arrayList.add(TimeTable("Data Structures", 11, "G5"))
                arrayList.add(TimeTable("Database Systems And Web", 2, "G5"))
                arrayList.add(TimeTable("Financial Accounting ", 4, "FF5"))
            }

            3 -> {
                arrayList.add(TimeTable("Computer Organization And Architecture", 9, "FF3"))
                arrayList.add(TimeTable("Database Systems And Web", 10, "TS10"))
                arrayList.add(TimeTable("Computer Organization And Architecture Lab", 11, "CL2"))
                arrayList.add(TimeTable("Database Systems And Web Lab", 3, "MML"))
            }

            4 -> {
                arrayList.add(TimeTable("Database Systems And Web", 10, "FF5"))
                arrayList.add(TimeTable("Digital Systems Lab", 11, "JBSPL"))
                arrayList.add(TimeTable("Financial Accounting", 4, "FF5"))
            }

            5 -> {
                arrayList.add(TimeTable("Data Structures", 9, "FF2"))
                arrayList.add(TimeTable("Introduction to Digital Systems", 10, "F8"))
            }

        }


        return arrayList
    }

}
