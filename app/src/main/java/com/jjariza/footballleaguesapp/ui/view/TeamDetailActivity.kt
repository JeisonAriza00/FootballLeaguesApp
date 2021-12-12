package com.jjariza.footballleaguesapp.ui.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.jjariza.footballleaguesapp.core.WebActivity
import com.jjariza.footballleaguesapp.core.get
import com.jjariza.footballleaguesapp.core.put
import com.jjariza.footballleaguesapp.data.model.TeamsModel
import com.jjariza.footballleaguesapp.databinding.ActivityTeamDetailBinding
import com.jjariza.footballleaguesapp.ui.view.adapters.EventAdapter
import com.jjariza.footballleaguesapp.ui.viewModel.TeamDetailViewModel
import com.squareup.picasso.Picasso

class TeamDetailActivity : AppCompatActivity() {

    companion object{
        fun startActivity(context: Context, teamsModel: TeamsModel){
            val intent = Intent(context, TeamDetailActivity::class.java)
            intent.put(teamsModel)
            context.startActivity(intent)
        }
    }

    val teamsModel: TeamsModel by lazy {
        get(TeamsModel::class.java)
    }


    lateinit var binding: ActivityTeamDetailBinding
    private val teamDetailViewModel: TeamDetailViewModel by viewModels()
    lateinit var adapter: EventAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeamDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.model = teamsModel
        Picasso.get()
            .load(teamsModel.strTeamBadge)
            .into(binding.imageViewTeamBadge)
        Picasso.get()
            .load(teamsModel.strTeamJersey)
            .into(binding.imageViewTeamJersey)

        binding.btnLastEvents.setOnClickListener {
            teamDetailViewModel.onCreate(teamsModel.idTeam)
        }

        teamDetailViewModel.events.observe(this, Observer {
            Log.e("events ->> ", it.toString())
            adapter = EventAdapter()
            adapter.submitList(it.events.toMutableList())
            binding.recyclerEvents.adapter = adapter
            binding.recyclerEvents.visibility = View.VISIBLE
        })

        binding.imageViewFacebook.setOnClickListener {
            WebActivity.startActivity(this, teamsModel.strFacebook)
        }

        binding.imageViewInstagram.setOnClickListener {
            WebActivity.startActivity(this, teamsModel.strInstagram)
        }

        binding.imageViewTwitter.setOnClickListener {
            WebActivity.startActivity(this, teamsModel.strTwitter)
        }

        binding.imageViewYoutube.setOnClickListener {
            WebActivity.startActivity(this, teamsModel.strYoutube)
        }

        binding.imageViewWebsite.setOnClickListener {
            WebActivity.startActivity(this, teamsModel.strWebsite)
        }
    }
}