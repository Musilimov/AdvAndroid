
package com.example.music.fragments

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.app.receiver.AirplaneModeReceiver
import com.example.music.databinding.FragmentBroadcastReceiverBinding


class BroadcastReceiverFragment : Fragment() {
    private var _binding: FragmentBroadcastReceiverBinding? = null
    private val binding get() = _binding!!

    private lateinit var airplaneModeReceiver: AirplaneModeReceiver

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBroadcastReceiverBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        airplaneModeReceiver = AirplaneModeReceiver { isEnabled ->
            binding.tvAirplaneStatus.text = if (isEnabled) "Режим в самолёте ВКЛЮЧЕН" else "Режим в самолёте ВЫКЛЮЧЕН"
        }

        requireActivity().registerReceiver(
            airplaneModeReceiver,
            IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        requireActivity().unregisterReceiver(airplaneModeReceiver)
        _binding = null
    }
}
