package com.example.mjc.myBooking

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mjc.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.fragment_my_booking.*


class MyBookingFragment : Fragment() {

    val TAG = "myBooking"
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_my_booking, container, false)
        val btnCancel: Button =root.findViewById(R.id.button_myBooking_cancel_reservation)

        btnCancel.setOnClickListener {
            findNavController().navigate(R.id.action_nav_myBooking_to_nav_home)
        }

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("Reservation")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {


              for(dss in dataSnapshot.children){
                  val rid=dss.child("rid").value.toString()
                  val roomNo=dss.child("roomNo").value.toString()
                  val roomType=dss.child("roomType").value.toString()
                  val stay=dss.child("stay").value.toString()
                  val guest=dss.child("guest").value.toString()
                  val price=dss.child("price").value.toString()
                  val chkin=dss.child("checkin").value.toString()
                  val chkout=dss.child("checkout").value.toString()
                  val userID=dss.child("userID").value

                  textView_myBooking_room_details1.text=
                          "Reservation ID : " +rid +"\n" +
                                  "Room No : " + roomNo +"\n" +
                                  "Room Type : " + roomType

                  textView_myBooking_room_details2.text=
                          "Stay : " + stay + "Night \n" +
                                  "Guest : " + guest + "\n" +
                                  "Price : RM " + price + "\n"  +
                                  "Check In : " + chkin + "\n" +
                                  "Check Out : " +chkout

                 /* if(roomNo=="A101"){
                      textView_myBooking_room_details1.text=
                              "Reservation ID : " +rid +"\n" +
                                      "Room No : " + roomNo +"\n" +
                                      "Room Type : " + roomType

                      textView_myBooking_room_details2.text=
                              "Stay : " + stay + "Night \n" +
                                      "Guest : " + guest + "\n" +
                                      "Price : RM " + price + "\n"  +
                                      "Check In : " + chkin + "\n" +
                                      "Check Out : " +chkout
                  }else{
                      textView_myBooking_room_details1.text=userID.toString()
                      textView_myBooking_room_details2.text="Let's make a booking now!"
                  }*/


              }
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })
        return root
    }

   
}