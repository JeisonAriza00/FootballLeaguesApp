package com.jjariza.footballleaguesapp.data.network

import com.jjariza.footballleaguesapp.data.model.Events
import com.jjariza.footballleaguesapp.data.model.Teams
import com.jjariza.footballleaguesapp.data.model.TeamsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TeamsApiClient {

    @GET("search_all_teams.php?l=")
    suspend fun getAllTeams(@Query("l") q: String):Response<Teams>

    @GET("eventslast.php?id=")
    suspend fun getLastEventsByTeam(@Query("id") id: String): Response<Events>
}