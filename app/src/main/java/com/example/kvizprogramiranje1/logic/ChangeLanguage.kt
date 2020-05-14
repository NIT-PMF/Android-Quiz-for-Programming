package com.example.kvizprogramiranje1.logic

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import java.util.*


lateinit  var configuration: Configuration;

fun applyLanguage(context: Context, langauge: String, locale: Locale) {
    Locale.setDefault(locale)
    configuration = context.resources.configuration
    configuration.setLocale(locale)
    context.resources.updateConfiguration(configuration, context.resources.displayMetrics)
}
