package com.example.mjc.roomService

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mjc.R

class RoomServiceFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root= inflater.inflate(R.layout.fragment_room_service, container, false)
        val buttonOrder: Button =root.findViewById(R.id.button_order_meal)
        val buttonHk:Button=root.findViewById(R.id.button_housekeeping)

        buttonOrder.setOnClickListener {
            findNavController().navigate(R.id.action_nav_roomService_to_nav_order)
        }

        buttonHk.setOnClickListener {
            findNavController().navigate(R.id.action_nav_roomService_to_nav_housekeeping)
        }


        return root
    }

}