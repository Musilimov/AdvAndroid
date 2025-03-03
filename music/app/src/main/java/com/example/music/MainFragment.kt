package com.example.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.music.databinding.FragmentMainBinding
import com.example.music.R

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnIntents.setOnClickListener {
            findNavController().navigate(R.id.action_to_intentsFragment)
        }

        binding.btnForegroundService.setOnClickListener {
            findNavController().navigate(R.id.action_to_foregroundServiceFragment)
        }

        binding.btnBroadcastReceiver.setOnClickListener {
            findNavController().navigate(R.id.action_to_broadcastReceiverFragment)
        }

        binding.btnContentProvider.setOnClickListener {
            findNavController().navigate(R.id.action_to_contentProviderFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}