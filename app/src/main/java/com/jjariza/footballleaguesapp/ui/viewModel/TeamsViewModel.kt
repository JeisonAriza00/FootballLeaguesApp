package com.jjariza.footballleaguesapp.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jjariza.footballleaguesapp.data.model.Teams
import com.jjariza.footballleaguesapp.domain.GetTeamsByLeague
import kotlinx.coroutines.launch

class TeamsViewModel: ViewModel() {

    val teams = MutableLiveData<Teams>()
    val isLoading = MutableLiveData<Boolean>()

    var getTeams = GetTeamsByLeague()


    fun onCreate(league: String) {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getTeams(league)
            teams.postValue(result)
            isLoading.postValue(false)
        }
    }
}