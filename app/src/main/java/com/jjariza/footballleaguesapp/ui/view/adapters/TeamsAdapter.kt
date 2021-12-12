package com.jjariza.footballleaguesapp.ui.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jjariza.footballleaguesapp.data.model.TeamsModel
import com.jjariza.footballleaguesapp.databinding.HolderTeamsBinding
import com.squareup.picasso.Picasso

class TeamsAdapter: ListAdapter<TeamsModel, TeamsAdapter.HolderTeam>(
    DiffUtilCallback()
) {

    var onClickItem: (p0: TeamsModel) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderTeam {
        return HolderTeam(HolderTeamsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: HolderTeam, position: Int) {
        holder.onBind(getItem(position), onClickItem)
    }

    class HolderTeam(val binding: HolderTeamsBinding): RecyclerView.ViewHolder(binding.root){
        fun onBind(model: TeamsModel, onClickItem: (p0: TeamsModel) -> Unit){
            binding.textViewTeamName.text = model.strTeam
            binding.textViewStadium.text =  model.strStadium
            Picasso.get()
                .load(model.strTeamBadge)
                .into(binding.imageViewBadgeTeam)

            binding.constraintTeam.setOnClickListener {
                onClickItem(model)
            }
        }
    }
}

private class DiffUtilCallback: DiffUtil.ItemCallback<TeamsModel>(){
    override fun areItemsTheSame(oldItem: TeamsModel, newItem: TeamsModel): Boolean = oldItem.idTeam == newItem.idTeam

    override fun areContentsTheSame(oldItem: TeamsModel, newItem: TeamsModel): Boolean = oldItem == newItem
}