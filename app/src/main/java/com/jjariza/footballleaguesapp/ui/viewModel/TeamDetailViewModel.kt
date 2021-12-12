package com.jjariza.footballleaguesapp.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jjariza.footballleaguesapp.data.model.Events
import com.jjariza.footballleaguesapp.domain.GetEventsByTeam
import kotlinx.coroutines.launch

class TeamDetailViewModel: ViewModel() {

    val events = MutableLiveData<Events>()
    var getEvents = GetEventsByTeam()

    fun onCreate(idTeam: String){
        viewModelScope.launch {
            val result = getEvents(idTeam)
            events.postValue(result)
        }
    }
}