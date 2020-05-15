package com.example.kvizprogramiranje1.logic

import android.content.Context
import android.widget.Toast

//Pomocna funkcija za vracanje toast poruke bez repeticije koda
fun showToast(context: Context, msg: String) {
    val showMessage: Toast = Toast.makeText(
        context,
        msg,
        Toast.LENGTH_SHORT
    )
    showMessage.show()
}