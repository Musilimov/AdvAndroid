package com.example.app.fragments

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.CalendarContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app.adapter.CalendarEventsAdapter
import com.example.music.databinding.FragmentContentProviderBinding
import com.example.app.model.CalendarEvent

class ContentProviderFragment : Fragment() {
    private var _binding: FragmentContentProviderBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContentProviderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.READ_CALENDAR)
            == PackageManager.PERMISSION_GRANTED) {
            loadCalendarEvents()
        }
    }

    private fun loadCalendarEvents() {
        val events = mutableListOf<CalendarEvent>()
        val projection = arrayOf(CalendarContract.Events.TITLE, CalendarContract.Events.DTSTART)
        val cursor = requireContext().contentResolver.query(
            CalendarContract.Events.CONTENT_URI, projection,
            null, null, "${CalendarContract.Events.DTSTART} ASC"
        )

        cursor?.use {
            while (it.moveToNext()) {
                val title = it.getString(0)
                val date = it.getLong(1)
                events.add(CalendarEvent(title, date))
            }
        }

        binding.recyclerViewCalendarEvents.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = CalendarEventsAdapter(events)
        }
    }
}
