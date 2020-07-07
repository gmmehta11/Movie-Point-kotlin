package com.example.movieapp.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movieapp.data.api.TheMovieDBInterface
import com.example.movieapp.data.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MovieDetailsNetworkDataSource(private val apiService: TheMovieDBInterface,
        private val compositeDesposable: CompositeDisposable) {

    private val _networkstate = MutableLiveData<NetworkState>()
    val networkstate: LiveData<NetworkState>
        get() = _networkstate

    private val _downloadedMovieDetailsResponse = MutableLiveData<MovieDetails>()
    val downloadedMovieresponse: LiveData<MovieDetails>
        get() =_downloadedMovieDetailsResponse

    fun fetchMovieDetails(movieId: Int){
        _networkstate.postValue(NetworkState.LOADING)

        try{
        compositeDesposable.add(
            apiService.getMovieDetails(movieId)
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                      _downloadedMovieDetailsResponse.postValue(it)
                        _networkstate.postValue(NetworkState.LOADED)
                    },
                    {
                        _networkstate.postValue(NetworkState.ERROR)
                        Log.e("MovieDetailDataSource", it.message.toString())
                    }
                )
        )
        }catch (e: Exception){
            Log.e("MovieDetailsDataSource", e.message.toString())
        }
    }
}