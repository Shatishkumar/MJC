package com.example.mjc.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mjc.R

class OrderFragment1 : Fragment() {
    private var dataSource: DataSource = DataSource()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_order1, container, false)


        return root
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        val rv_order_list1: RecyclerView = itemView.findViewById(R.id.rv_order_list1)
     //   val food = dataSource.list.get(position)

        rv_order_list1.apply {

            layoutManager = LinearLayoutManager(activity)
            adapter = OrderAdapter(1000)
         //   val id = food.id
        }
    }
}