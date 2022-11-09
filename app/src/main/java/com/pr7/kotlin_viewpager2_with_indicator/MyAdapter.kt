package com.pr7.kotlin_viewpager2_with_indicator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter constructor(
  val intArray: IntArray
):RecyclerView.Adapter<MyAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text="${intArray.get(position)}"
    }

    override fun getItemCount(): Int =intArray.size
    class MyViewHolder(itemview:View):RecyclerView.ViewHolder(itemview){
        val textView:TextView=itemview.findViewById(R.id.textview1)
        val linearLayout:LinearLayout=itemview.findViewById(R.id.linearlay1)
    }
}