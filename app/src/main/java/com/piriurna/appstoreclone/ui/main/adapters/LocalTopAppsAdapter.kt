package com.piriurna.appstoreclone.ui.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.piriurna.appstoreclone.R
import com.piriurna.domain.models.App

class LocalTopAppsAdapter(items : List<App>) : RecyclerView.Adapter<LocalTopAppsAdapter.ViewHolder>() {

    var items : List<App> = items
        set(newItems) {
            field = newItems
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.asc_app_card_layout, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        with(items[position]) {
            viewHolder.appName.text = name
            viewHolder.appRating.text = rating.toString()
            viewHolder.appImage.load(this.icon)
        }
    }


    override fun getItemCount() = items.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val appName: TextView

        val appRating : TextView

        val appImage : ImageView

        init {
            // Define click listener for the ViewHolder's View.
            appName = view.findViewById(R.id.txt_app_name)

            appRating = view.findViewById(R.id.txt_rating)

            appImage = view.findViewById(R.id.img_app_image)
        }
    }
}