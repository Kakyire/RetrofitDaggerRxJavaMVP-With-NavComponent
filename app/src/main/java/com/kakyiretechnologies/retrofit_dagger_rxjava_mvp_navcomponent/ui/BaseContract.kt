package com.kakyiretechnologies.retrofit_dagger_rxjava_mvp_navcomponent.ui

import com.kakyiretechnologies.retrofit_dagger_rxjava_mvp_navcomponent.model.MovieResults
import com.kakyiretechnologies.retrofit_dagger_rxjava_mvp_navcomponent.ui.fragments.upcomingmovies.UpcomingMoviesContract

interface BaseContract {

    interface BaseView {
        fun showProgress()
        fun hideProgress()
        fun onFailed(t: Throwable)
        fun loadRecyclerView(results: List<MovieResults>)
    }

    interface Presenter {
        fun onSuccess(results: List<MovieResults>)
        fun onError(t: Throwable)
        fun onLoading()
        fun getMovies()
        fun loadMoreMovies(pageNo: Int)
    }

    interface Model {
        fun getMoviesFromServer(pageNo: Int, presenter: Presenter)


    }


}