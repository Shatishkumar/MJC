package com.example.mjc.roomService

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.mjc.R

class HousekeepingAdapter: RecyclerView.Adapter<CustomViewHolder>()  {
    val text= arrayOf("Shampoo", "Shower Gel", "Body Lotion", "Mouthwash", "Extra Towels", "Room Cleaning Service")

    override fun getItemCount(): Int {
        return text.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_housekeeping, parent, false)
        return CustomViewHolder(v)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val item: TextView =holder.v.findViewById(R.id.textview_housekeeping_item)
        val qty: TextView =holder.v.findViewById(R.id.textView_housekeeping_item_qty)
        val list_housekeeping: CardView =holder.v.findViewById(R.id.list_housekeeping)

        item.text=text[position]


    }

}

private fun TextView.setText(any: Any) {

}

class CustomViewHolder (val v: View): RecyclerView.ViewHolder(v){


}

