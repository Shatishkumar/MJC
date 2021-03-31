package com.example.mjc.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mjc.R

class HomeAdapter: RecyclerView.Adapter<CustomViewHolder>() {

    val text= arrayOf("My Booking", "Check In/Out", "Booking Now", "Room Service")

    override fun getItemCount(): Int {
       return text.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_home, parent, false)
        return CustomViewHolder(v)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val item:TextView=holder.v.findViewById(R.id.textView_home_item)
        val image:ImageView=holder.v.findViewById(R.id.imageView_home)
        val list_home:CardView=holder.v.findViewById(R.id.list_home)
       /* item.setText(when(item.id){
            0->"My Booking"
            1->"Check In / Out"
            2->"Booking Now"
            3->"Room Service"

            else ->"Error"
        })
*/
        item.text=text[position]

        image.setImageResource(when(position){
            0->R.drawable.room
            1->R.drawable.checkinout
            2->R.drawable.booking
            3->R.drawable.roomservice

            else ->R.drawable.logo
        })

        list_home.setOnClickListener {

            when(position){
                0 -> it.findNavController().navigate(R.id.action_nav_home_to_nav_myBooking)
                1 -> it.findNavController().navigate(R.id.action_nav_home_to_checkInOutFragment)
                2 -> it.findNavController().navigate(R.id.action_nav_home_to_nav_reservation)
                3 -> it.findNavController().navigate(R.id.action_nav_home_to_nav_roomService)

            }
        }
    }

}

private fun TextView.setText(any: Any) {

}

class CustomViewHolder (val v: View): RecyclerView.ViewHolder(v){


}

