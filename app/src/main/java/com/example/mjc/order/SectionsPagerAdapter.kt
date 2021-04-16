package com.example.mjc.order

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */

/*class SectionsPagerAdapter(private val context: Context, fm: FragmentManager)
    : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
      //  return PlaceholderFragment.newInstance(position + 1)

        val fragment : Fragment? = null
        switch(position){

        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 3 total pages.
        return 3
    }
}*/


private val mFragmentList = ArrayList<Fragment>()
private val mFragmentTitleList = ArrayList<String>()

class SectionsPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm!!) {
    override fun getItem(position: Int): Fragment {
       /* var fragment: Fragment? = null
        when (position) {
            0 -> fragment = OrderFragment1()
            1 -> fragment = OrderFragment2()
            2 -> fragment = OrderFragment3()
        }
        return fragment!!*/
        return mFragmentList.get(position)
    }

    override fun getCount(): Int {
        // Show 3 total pages.
     //   return 3
        return mFragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
      /*  when (position) {
            0 -> return "Local Food"
            1 -> return "Western Food"
            2 -> return "Korean Food"
        }
        return null*/
        return mFragmentTitleList.get(position)
    }

    fun addFragment(fragment: Fragment, title: String){
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }
}
