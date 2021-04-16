package com.example.mjc.roomService

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mjc.R
import com.example.mjc.helper.AutoRepeatButton
import com.example.mjc.helper.Utils
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_housekeeping.view.*
import kotlinx.android.synthetic.main.list_housekeeping.view.*

class HousekeepingAdapter(

): RecyclerView.Adapter<HousekeepingAdapter.CustomViewHolder>()  {

    val text= arrayOf("Shampoo", "Shower Gel", "Body Lotion", "Mouthwash", "Extra Towels", "Room Cleaning Service")


    private var database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private var myRef: DatabaseReference = database.getReference("Housekeeping")

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val prodName: TextView = itemView.textview_housekeeping_item
        val counter: TextView = itemView.textView_housekeeping_item_qty
        val plusBtn: Button = itemView.housekeeping_btn_plus
        val minusBtn: Button = itemView.housekeeping_btn_minus
        val requestBtn: Button = itemView.button_housekeeping_request
    }

    override fun getItemCount(): Int {
        return text.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_housekeeping, parent, false)
        return CustomViewHolder(v)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        /*val item: TextView =holder.v.findViewById(R.id.textview_housekeeping_item)
        val qty: TextView =holder.v.findViewById(R.id.textView_housekeeping_item_qty)
        val list_housekeeping: CardView =holder.v.findViewById(R.id.list_housekeeping)

        item.text=text[position]*/

        holder.plusBtn.id = position
        holder.minusBtn.id = position
        holder.counter.id = position
        holder.prodName.setText(text[position])

        holder.minusBtn.setOnTouchListener(
                AutoRepeatButton(400, 100,
                        View.OnClickListener { minusCounter(holder) })
        )

        holder.plusBtn.setOnTouchListener(
                AutoRepeatButton(400, 100,
                        View.OnClickListener { plusCounter(holder) })
        )





       /* val btnrequest: Button =holder.itemView.findViewById(R.id.button_housekeeping_request)
        var num = 1
        val numRef=myRef.child(num.toString())

        btnrequest.setOnClickListener {
            numRef.addValueEventListener(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    numRef.child(text[position]).setValue(10)
                    holder.itemView.findViewById<TextView>(R.id.textView3).setText("ERROR")
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })
        }
*/
    }


    private fun plusCounter(holder: CustomViewHolder) {

        val position = holder.plusBtn.id
        val product = holder.prodName.text.toString()
        var count : Int = holder.counter.text.toString().toInt()
        val maxQty : Int = 20
        if(count == maxQty){
            count = maxQty
            Utils.toast(holder.itemView.context, "Maximum quantity has been exceeded for $product", 0);
        }else{
            count++
        }
        holder.counter.text = count.toString()
   //     mutableList[product] = count
    //    fbCallback.pushHousekeepingItemQty(mutableList)
    }

    private fun minusCounter(holder: CustomViewHolder) {
        var product = holder.prodName.text.toString()
        var count: Int = holder.counter.text.toString().toInt()
        var x: Int
        if (count != 0) {
            x = --count
            holder.counter.text = x.toString()
            // product = x.toString()
        }
      //  fbCallback.pushHousekeepingItemQty(mutableList)
    }
}

private fun TextView.setText(any: Any) {

}

class CustomViewHolder (val v: View): RecyclerView.ViewHolder(v){


}

