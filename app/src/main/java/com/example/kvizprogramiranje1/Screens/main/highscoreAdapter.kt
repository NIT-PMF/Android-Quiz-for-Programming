package com.example.kvizprogramiranje1.screens.main

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.kvizprogramiranje1.R
import com.example.kvizprogramiranje1.singleton.User

class userListAdapter (
    val ctx: Context,
    var resources: Int,
    var list: List<User?>
) :
    ArrayAdapter<User?>(ctx, resources, list) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater:LayoutInflater = LayoutInflater.from(context)
        val view:View = layoutInflater.inflate(resources, null)

        val userName: TextView = view.findViewById(R.id.textView_user)
        val scoreName: TextView = view.findViewById(R.id.textView_score) as TextView

        val mItem: User? = list[position]

        userName.text = mItem?.username
        userName.setTextColor(Color.WHITE)
        scoreName.text = mItem?.score.toString()
        scoreName.setTextColor(Color.WHITE)

        return view
    }
}
