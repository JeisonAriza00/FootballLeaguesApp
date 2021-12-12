package com.jjariza.footballleaguesapp.data.model

import com.google.gson.annotations.SerializedName

data class Events (
     @SerializedName("results")
     val events : ArrayList<EventModel> = ArrayList()

)