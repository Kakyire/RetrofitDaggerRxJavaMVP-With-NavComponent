package com.kakyiretechnologies.retrofit_dagger_rxjava_mvp_navcomponent.ui.fragments.popularmovies

import javax.inject.Inject

class PopularMoviesPresenter @Inject constructor(private var view: PopularMoviesContract.View?) :
    PopularMoviesContract.Presenter {

    @Inject
    lateinit var model: PopularMoviesModel


    override fun onSuccess(results: List<Any>) {
        view?.apply {
            hideProgress()
            loadRecyclerView(results)
        }
    }

    override fun onError(t: Throwable) {
        view?.apply {
            onFailed(t)
            hideProgress()
        }
    }

    override fun onLoading() {
        view?.showProgress()
    }

    override fun getMovies() {
        model.getMoviesFromServer(1, this)
    }

    override fun loadMoreMovies(pageNo: Int) {
        model.getMoviesFromServer(pageNo, this)
    }

    override fun onDestroy() {
        view = null
    }
}