package com.example.mjc.housekeeping

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mjc.R
import com.example.mjc.roomService.HousekeepingAdapter
import com.google.firebase.database.*

class HousekeepingFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_housekeeping, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        val rv_housekeeping_list: RecyclerView = itemView.findViewById(R.id.rv_housekeeping_list)
        val btncancel: Button =itemView.findViewById(R.id.button_housekeeping_cancel)
        val btnrequest: Button =itemView.findViewById(R.id.button_housekeeping_request)
       // val btnrequest: Button =itemView.findViewById(R.id.button_housekeeping_request)

        rv_housekeeping_list.apply {

            layoutManager = LinearLayoutManager(activity)
            adapter = HousekeepingAdapter()
        }

        btncancel.setOnClickListener {
            findNavController().navigate(R.id.action_nav_housekeeping_to_nav_roomService)
        }


        var num = 1
        val text= arrayOf("Shampoo", "Shower Gel", "Body Lotion", "Mouthwash", "Extra Towels", "Room Cleaning Service")
      //  val position:Int? = null
        var database: FirebaseDatabase = FirebaseDatabase.getInstance()
        var myRef: DatabaseReference = database.getReference("Housekeeping")
       // val numRef=myRef.child(num.toString())

        btnrequest.setOnClickListener {
            myRef.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                 //   myRef.child("text[0]").setValue("9")
                   // holder.itemView.findViewById<TextView>(R.id.textView3).setText("ERROR")
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })
        }
    }
}