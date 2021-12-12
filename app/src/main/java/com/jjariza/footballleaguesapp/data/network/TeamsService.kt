package com.jjariza.footballleaguesapp.data.network

import com.jjariza.footballleaguesapp.core.RetrofitHelper
import com.jjariza.footballleaguesapp.data.model.Events
import com.jjariza.footballleaguesapp.data.model.Teams
import com.jjariza.footballleaguesapp.data.model.TeamsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TeamsService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getTeams(league: String): Teams{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(TeamsApiClient::class.java).getAllTeams(league)
            response.body()!!
        }
    }

    suspend fun getEvents(idTeam: String): Events{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(TeamsApiClient::class.java).getLastEventsByTeam(idTeam)
            response.body()!!
        }
    }
}