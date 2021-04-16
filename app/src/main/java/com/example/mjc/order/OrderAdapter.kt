package com.example.mjc.order

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mjc.R
import com.example.mjc.roomService.CustomViewHolder
import kotlinx.android.synthetic.main.list_order.view.*

class OrderAdapter(i: Int) : RecyclerView.Adapter<CustomViewHolder>()  {
    var orderid = i
    var dataSource : DataSource = DataSource()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_order, parent, false)
        return CustomViewHolder(v)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        val food = dataSource.list.get(position)
        holder.v.imageView_order_food.setImageResource(food.img)
        holder.v.textView_order_food.text = food.name
        holder.v.textView_order_price.text = food.price.toString()

        holder.v.cardview_order.setOnClickListener {
            val id = food.id

           /* when(id){
                1000 -> it.findNavController().navigate(R.id.action_nav_order_to_orderFragment1)
                1002 -> it.findNavController().navigate(R.id.action_nav_order_to_orderFragment2)
                1003 -> it.findNavController().navigate(R.id.action_nav_order_to_orderFragment3)
            }*/

            if (id==orderid){
                when(id){
                    1000 -> it.findNavController().navigate(R.id.action_nav_order_to_orderFragment1)
                    1002 -> it.findNavController().navigate(R.id.action_nav_order_to_orderFragment2)
                    1003 -> it.findNavController().navigate(R.id.action_nav_order_to_orderFragment3)
                }
            }


        }
    }

    override fun getItemCount(): Int {
        return dataSource.list.size
    }
}