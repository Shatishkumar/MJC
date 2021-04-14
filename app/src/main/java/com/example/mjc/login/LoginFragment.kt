package com.example.mjc.login

import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.Navigation.*
import com.example.mjc.R

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_login, container, false)

        val registerNav: TextView = root.findViewById(R.id.loginCreateAccount)
        registerNav.setOnClickListener {findNavController(root).navigate(R.id.action_nav_login_to_register)}
//        val registerNav: TextView = root.findViewById(R.id.loginCreateAccount)
//        val text = "Create Account"
//        val ss = SpannableString(text)
//
//        val clickableSpan1: ClickableSpan = object : ClickableSpan() {
//
//            override fun onClick(widget: View) {
//                findNavController(root).navigate(R.id.action_nav_login_to_register)
//            }
//        }
//
//        ss.setSpan(clickableSpan1, 0, 14, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
//        with(registerNav) {
//
//            setText(ss)
//            movementMethod = LinkMovementMethod.getInstance()
//
//        }

//        val btnlogin: Button = root.findViewById(R.id.button_login)
//        btnlogin.setOnClickListener {
//            findNavController().navigate(R.id.action_nav_login_to_nav_home)
//        }


        return root
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }

}