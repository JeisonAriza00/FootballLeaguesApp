package com.jjariza.footballleaguesapp.core

import android.app.Activity
import android.content.Intent
import com.google.gson.Gson


fun toJson(any: Any): String = Gson().toJson(any)

fun <T> fromJson(json: String, classOfT: Class<T>): T {
    return try {
        Gson().fromJson(json, classOfT)
    } catch (error: Exception) {
        Gson().fromJson("{}", classOfT)
    }
}

fun Intent.put(any: Any) {
    this.putExtra(any::class.java.name, toJson(any))
}

fun <T> Activity.get(classOfT: Class<T>): T {
    val json = this.intent.extras?.getString(classOfT.name, "{}") ?: "{}"
    return fromJson(json, classOfT)
}