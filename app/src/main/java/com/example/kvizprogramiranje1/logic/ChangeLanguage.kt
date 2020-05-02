package com.example.kvizprogramiranje1.logic

import android.content.Context
import java.util.*

fun applyLanguage(context: Context, langauge: String) {
    val locale = Locale(langauge)
    Locale.setDefault(locale)
    val configuration = context.resources.configuration
    configuration.setLocale(locale)
    context.resources.updateConfiguration(configuration, context.resources.displayMetrics)
}