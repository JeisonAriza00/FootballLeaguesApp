package com.jjariza.footballleaguesapp.domain

import com.jjariza.footballleaguesapp.data.TeamRepository
import com.jjariza.footballleaguesapp.data.model.Events

class GetEventsByTeam {

    private val repository = TeamRepository()

    suspend operator fun invoke(idTeam: String): Events {
        return repository.getAllEvents(idTeam)
    }
}