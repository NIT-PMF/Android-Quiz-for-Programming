package com.example.kvizprogramiranje1.screens.main.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.kvizprogramiranje1.R
import com.example.kvizprogramiranje1.dao.UserDatabaseDao
import com.example.kvizprogramiranje1.singleton.User

class userListAdapter(
    val ctx: Context,
    var resources: Int,
    var list: List<com.example.kvizprogramiranje1.entity.User>
) :
    ArrayAdapter<com.example.kvizprogramiranje1.entity.User?>(ctx, resources, list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater:LayoutInflater = LayoutInflater.from(context)
        val view:View = layoutInflater.inflate(resources, null)

        val userName: TextView = view.findViewById(R.id.textView_user)
        val scoreName: TextView = view.findViewById(R.id.textView_score) as TextView

        val mItem: com.example.kvizprogramiranje1.entity.User = list[position]


        userName.text = mItem?.username
        userName.setTextColor(Color.WHITE)
        scoreName.text = mItem?.userScore.toString()
        scoreName.setTextColor(Color.WHITE)

        return view
    }


}
