package com.example.mjc.helper

import android.content.Context
import android.widget.Toast

object Utils {

    fun toast(context: Context, msg: String, duration: Int){ // duration : 0 = short || >= 1 Long

        // Utils.toast(this,"TEXT",1)   = call toast in activity
        // Utils.toast(requireActivity(), "TEXT", 0) = call toast in fragment

        if(duration === 0){
            return Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }else{
            return Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
        }
    }
}