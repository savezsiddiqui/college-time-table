package com.starkindustires.timetable.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import com.starkindustires.timetable.R
import com.starkindustires.timetable.activities.Schedule
import com.starkindustires.timetable.adapter.MainScreenAdapter.statified.pos

class MainScreenAdapter(_dayNames: MutableList<String>, _context: Context) : RecyclerView.Adapter<MainScreenAdapter.DayViewHolder>() {


    var dayNames: MutableList<String> = ArrayList()
    var mContext: Context? = null

    object statified {
        var pos: Int = 0
    }

    init {
        this.dayNames = _dayNames
        this.mContext = _context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayViewHolder {

        var itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.row_custom_mainscreen_adapter, parent, false)

        return DayViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dayNames.size
    }

    override fun onBindViewHolder(holder: DayViewHolder, position: Int) {
        var day = dayNames?.get(position)
        holder.dayName?.text = day
        holder.contentHolder?.setOnClickListener {

            pos = position
            var clickIntent = Intent(mContext, Schedule::class.java)
            mContext?.startActivity(clickIntent)
        }
    }


    class DayViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        var dayName: TextView? = null
        var contentHolder: RelativeLayout? = null

        init {
            dayName = itemView?.findViewById(R.id.dayTitle)
            contentHolder = itemView?.findViewById(R.id.contentRow)
        }
    }
}