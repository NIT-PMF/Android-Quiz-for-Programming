package com.example.kvizprogramiranje1.logic

import android.content.Context
import android.widget.Toast
import com.example.kvizprogramiranje1.R

fun showToast(context: Context, msg: String) {
    val showMessage: Toast = Toast.makeText(
        context,
        msg,
        Toast.LENGTH_SHORT
    )
    showMessage.show()
}