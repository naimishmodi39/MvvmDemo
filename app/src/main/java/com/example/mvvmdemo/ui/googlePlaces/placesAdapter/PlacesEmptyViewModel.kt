package com.example.mvvmdemo.ui.googlePlaces.placesAdapter

class PlacesEmptyViewModel(var mClickListener: PlacesEmptyViewHolderEmptyClickListener) {

    fun OnRetryClick() {
        mClickListener.onRetryClick()
    }

    interface PlacesEmptyViewHolderEmptyClickListener {
        fun onRetryClick()
    }
}