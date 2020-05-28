package com.example.mvvmdemo.ui.users.usersListAdapter

class UsersListEmptyViewModel(var mClickListener: PlacesEmptyViewHolderEmptyClickListener) {

    fun OnRetryClick() {
        mClickListener.onRetryClick()
    }

    interface PlacesEmptyViewHolderEmptyClickListener {
        fun onRetryClick()
    }
}