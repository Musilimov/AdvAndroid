package com.example.app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.music.R
import com.example.app.model.CalendarEvent
import java.text.SimpleDateFormat
import java.util.*

class CalendarEventsAdapter(private val events: List<CalendarEvent>) :
    RecyclerView.Adapter<CalendarEventsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.tvEventTitle)
        val date: TextView = view.findViewById(R.id.tvEventDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_calendar_event, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val event = events[position]
        holder.title.text = event.title
        holder.date.text = SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault())
            .format(Date(event.startTime))
    }

    override fun getItemCount() = events.size
}
