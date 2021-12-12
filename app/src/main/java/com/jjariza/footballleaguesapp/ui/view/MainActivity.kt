package com.jjariza.footballleaguesapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.jjariza.footballleaguesapp.data.model.Teams
import com.jjariza.footballleaguesapp.data.model.TeamsModel
import com.jjariza.footballleaguesapp.databinding.ActivityMainBinding
import com.jjariza.footballleaguesapp.ui.view.adapters.TeamsAdapter
import com.jjariza.footballleaguesapp.ui.viewModel.TeamsViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val teamsViewModel: TeamsViewModel by viewModels()
    lateinit var adapter: TeamsAdapter
    private var list = listOf<Teams>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        teamsViewModel.onCreate("Spanish La Liga")

        teamsViewModel.teams.observe(this, Observer {
            Log.e("teams -> ", it.teams.toString())
            adapter = TeamsAdapter()
            adapter.submitList(it.teams.toMutableList())
            binding.recyclerTeams.adapter = adapter
            adapter.onClickItem = ::onClickItem

        })
        teamsViewModel.isLoading.observe(this, Observer {
            binding.progress.isVisible = it
        })

    }

    fun onClickItem(teamsModel: TeamsModel){
        Log.e("Team: ", teamsModel.strTeam + teamsModel.intFormedYear)
        TeamDetailActivity.startActivity(this, teamsModel)
    }
}