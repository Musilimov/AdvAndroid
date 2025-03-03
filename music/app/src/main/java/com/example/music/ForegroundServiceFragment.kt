package com.example.music.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.music.databinding.FragmentForegroundServiceBinding
import com.example.music.services.MusicService

class ForegroundServiceFragment : Fragment() {
    private var _binding: FragmentForegroundServiceBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentForegroundServiceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnStartService.setOnClickListener {
            val intent = Intent(requireContext(), MusicService::class.java).apply {
                action = "START"
            }
            requireActivity().startService(intent)
        }

        binding.btnStopService.setOnClickListener {
            val intent = Intent(requireContext(), MusicService::class.java).apply {
                action = "STOP"
            }
            requireActivity().startService(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
