package com.jjariza.footballleaguesapp.ui.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jjariza.footballleaguesapp.data.model.EventModel
import com.jjariza.footballleaguesapp.databinding.HolderEventsBinding
import com.squareup.picasso.Picasso

class EventAdapter: ListAdapter<EventModel, EventAdapter.HolderEvent>(
    DiffUtilCallbackEvent()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderEvent {
        return HolderEvent(HolderEventsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: HolderEvent, position: Int) {
        holder.onBind(getItem(position))
    }

    class HolderEvent(val binding: HolderEventsBinding): RecyclerView.ViewHolder(binding.root){
        fun onBind(model: EventModel){
            binding.textViewLeague.text = model.strLeague
            binding.textViewVenue.text = model.strVenue
            binding.textViewHomeTeam.text = model.strHomeTeam
            binding.textViewAwayTeam.text = model.strAwayTeam
            binding.textViewHomeScore.text = model.intHomeScore
            binding.textViewAwayScore.text = model.intAwayScore

            Picasso.get()
                .load(model.strThumb)
                .into(binding.imageViewThumb)
        }
    }

}

private class DiffUtilCallbackEvent: DiffUtil.ItemCallback<EventModel>(){
    override fun areItemsTheSame(oldItem: EventModel, newItem: EventModel): Boolean = oldItem.idEvent == newItem.idEvent

    override fun areContentsTheSame(oldItem: EventModel, newItem: EventModel): Boolean = oldItem == newItem

}