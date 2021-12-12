package com.jjariza.footballleaguesapp.domain

import com.jjariza.footballleaguesapp.data.TeamRepository
import com.jjariza.footballleaguesapp.data.model.Events
import com.jjariza.footballleaguesapp.data.model.Teams
import com.jjariza.footballleaguesapp.data.model.TeamsModel

class GetTeamsByLeague {

    private val repository = TeamRepository()

    suspend operator fun invoke(league: String): Teams{
        return repository.getAllTeams(league)
    }
}