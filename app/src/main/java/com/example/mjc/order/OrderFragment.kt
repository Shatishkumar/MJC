package com.example.mjc.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.mjc.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_order.*


class OrderFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_order, container, false)
       // val sectionsPagerAdapter = SectionsPagerAdapter(fragment, supportFragmentManager)
        val tab : TabLayout= root.findViewById(R.id.tab_layout_order)
        val pager : ViewPager = root.findViewById(R.id.pager_order)

        return root
    }

/*    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        val rv_order_list: RecyclerView = itemView.findViewById(R.id.rv_order_list)

        rv_order_list.apply {

            layoutManager = LinearLayoutManager(activity)
            adapter = OrderAdapter()
        }

    }*/

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setUpViewPager(pager_order)
        tab_layout_order.setupWithViewPager(pager_order)

        tab_layout_order.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
               // pager_order.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }

        })
    }

    private fun setUpViewPager(viewPager: ViewPager?) {
        //val show = SectionsPagerAdapter(childFragmentManager)
       // viewPager!!.adapter = show
        val show:SectionsPagerAdapter = SectionsPagerAdapter(childFragmentManager)

        show.addFragment(OrderFragment1(), "Local Food")
        show.addFragment(OrderFragment2(),"Western Food")
        show.addFragment(OrderFragment3(),"Korean Food")

        viewPager?.adapter = show

    }

}

