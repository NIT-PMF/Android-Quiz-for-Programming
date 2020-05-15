package com.example.kvizprogramiranje1.logic

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import java.util.*


//Za konfigurisanje jezika, ova funkcija nije potrebna trenutno, ali korisna ukoliko zelimo jezik u fragmentima mijenjati
lateinit  var configuration: Configuration;

fun applyLanguage(context: Context, langauge: String, locale: Locale) {
    Locale.setDefault(locale)
    configuration = context.resources.configuration
    configuration.setLocale(locale)
    context.resources.updateConfiguration(configuration, context.resources.displayMetrics)
}
