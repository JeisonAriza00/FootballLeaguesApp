package com.jjariza.footballleaguesapp.data

import com.jjariza.footballleaguesapp.data.model.Events
import com.jjariza.footballleaguesapp.data.model.Teams
import com.jjariza.footballleaguesapp.data.model.TeamsModel
import com.jjariza.footballleaguesapp.data.model.TeamsProvider
import com.jjariza.footballleaguesapp.data.network.TeamsService

class TeamRepository {

    private val api = TeamsService()

    suspend fun getAllTeams(league: String): Teams {
        val response = api.getTeams(league)
        TeamsProvider.teams = response
        return response
    }

    suspend fun getAllEvents(idTeam: String): Events {
        val response = api.getEvents(idTeam)
        TeamsProvider.events = response
        return response
    }
}