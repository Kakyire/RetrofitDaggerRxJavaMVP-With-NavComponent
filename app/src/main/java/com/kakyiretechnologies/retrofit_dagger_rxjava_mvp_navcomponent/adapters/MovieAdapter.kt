package com.kakyiretechnologies.retrofit_dagger_rxjava_mvp_navcomponent.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kakyiretechnologies.retrofit_dagger_rxjava_mvp_navcomponent.R
import com.kakyiretechnologies.retrofit_dagger_rxjava_mvp_navcomponent.di.context.ActivityContext
import com.kakyiretechnologies.retrofit_dagger_rxjava_mvp_navcomponent.model.MovieResults
import com.kakyiretechnologies.retrofit_dagger_rxjava_mvp_navcomponent.utils.ClickListener
import com.kakyiretechnologies.retrofit_dagger_rxjava_mvp_navcomponent.utils.Constants.IMAGE_URL
import com.kakyiretechnologies.retrofit_dagger_rxjava_mvp_navcomponent.utils.LoadImageWithGlide.loadImage
import kotlinx.android.synthetic.main.movies_list.view.*
import javax.inject.Inject

class MovieAdapter @Inject constructor(
    @ActivityContext private val context: Context,
    private val clickListener: ClickListener
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private val list: MutableList<Any> = ArrayList()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movies_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {

        val movieResults = list[position] as MovieResults

        holder.itemView.tvOverview.text = movieResults.overview
        holder.itemView.tvReleaseDate.text = movieResults.releaseDate
        holder.itemView.tvMovieTitle.text = movieResults.title

        val image = "$IMAGE_URL${movieResults.posterPath}"
        loadImage(context, holder.itemView.movie_thumbnail, image)

        holder.itemView.setOnClickListener { clickListener.onClick(position) }

    }

    override fun getItemCount(): Int {
        return list.size
    }


    fun loadData(movieResults: List<Any>) {

        list.addAll(movieResults)
        notifyDataSetChanged()
    }

}