package com.starkindustires.timetable.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import com.starkindustires.timetable.R
import com.starkindustires.timetable.TimeTable

class ScheduleScreenAdapter(_schedule: ArrayList<TimeTable>, _context: Context) : RecyclerView.Adapter<ScheduleScreenAdapter.ViewHolder>() {


    var schedule: ArrayList<TimeTable>? = null
    var mContext: Context? = null

    init {
        this.schedule = _schedule
        this.mContext = _context
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.row_custom_schedule, parent, false)

        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        if (schedule == null)
            return 0
        else
            return (schedule as ArrayList<TimeTable>).size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var timeTableObject = schedule?.get(position)
        holder.className?.text = timeTableObject?.className
        var temp = timeTableObject?.classTime as Int
        var tempTime: String

        if (temp == 12 || temp in 1..5) {
            tempTime = temp.toString() + ":00 PM"
        } else {
            tempTime = temp.toString() + ":00 AM"
        }

        holder.time?.text = tempTime
        holder.room?.text = timeTableObject?.classRoom
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        var className: TextView? = null
        var time: TextView? = null
        var room: TextView? = null
        var contentHolder: RelativeLayout? = null

        init {
            className = itemView?.findViewById(R.id.className)
            time = itemView?.findViewById(R.id.classTime)
            room = itemView?.findViewById(R.id.room)
            contentHolder = itemView?.findViewById(R.id.contentRow1)
        }
    }
}