package com.example.kvizprogramiranje1.logic

import android.content.Context
import android.content.res.Configuration
import java.util.*

lateinit var locale: Locale;
lateinit  var configuration: Configuration;

fun applyLanguage(context: Context, langauge: String) {
    locale = Locale(langauge)
    Locale.setDefault(locale)
    configuration = context.resources.configuration
    configuration.setLocale(locale)
    context.resources.updateConfiguration(configuration, context.resources.displayMetrics)
}