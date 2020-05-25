package com.example.mvvmdemo.ui.googlePlaces.placesAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.benchmate.sports.data.responsebean.PlacesResponse.ResultsItem
import com.example.mvvmdemo.databinding.ItemEmptyPlacesBinding
import com.example.mvvmdemo.databinding.ItemPlaceBinding
import com.example.mvvmdemo.ui.base.BaseViewHolder

class PlacesAdapter : RecyclerView.Adapter<BaseViewHolder>() {

    val VIEW_TYPE_NORMAL: Int = 1
    val VIEW_TYPE_Empty: Int = 0

    var listOfPlaces: ArrayList<ResultsItem> = arrayListOf()
    lateinit var mListener: BlogAdapterListener

    override fun getItemViewType(position: Int): Int {
        return if (listOfPlaces.size > 0) VIEW_TYPE_NORMAL else VIEW_TYPE_Empty
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        when (viewType) {
            VIEW_TYPE_Empty -> {

                val mbinding = ItemEmptyPlacesBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return EmptyViewHolder(mbinding)
            }
            else -> {
                val mbinding =
                    ItemPlaceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return PlacesViewHolder(mbinding)
            }
        }
    }

    fun addItems(list: List<ResultsItem>) {
        listOfPlaces = list as ArrayList<ResultsItem>
        notifyDataSetChanged()
    }

    fun clearItems() {
        listOfPlaces.clear()
    }

    fun setListner(mListener: BlogAdapterListener) {
        this.mListener = mListener
    }

    interface BlogAdapterListener {
        fun onRetryClick()
    }

    override fun getItemCount(): Int {
        return if (listOfPlaces.size > 0) listOfPlaces.size else 1

    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position)
    }


    inner class EmptyViewHolder constructor(binding: ItemEmptyPlacesBinding) :
        BaseViewHolder(binding.root), PlacesEmptyViewModel.PlacesEmptyViewHolderEmptyClickListener {

        var mbinding: ItemEmptyPlacesBinding
        lateinit var mPlacesEmptyViewModel: PlacesEmptyViewModel

        override fun onBind(Position: Int) {
            mPlacesEmptyViewModel = PlacesEmptyViewModel(this)
            mbinding.viewModel = mPlacesEmptyViewModel
        }

        override fun onRetryClick() {
            mListener.onRetryClick()
        }

        init {
            this.mbinding = binding
        }
    }


    inner class PlacesViewHolder(binding: ItemPlaceBinding) : BaseViewHolder(binding.root),
        PlacesViewModel.PlacesItemViewModelListener {

        var mbinding: ItemPlaceBinding
        lateinit var mPlacesViewModel: PlacesViewModel

        override fun onBind(Position: Int) {
            val result: ResultsItem = listOfPlaces.get(Position)
            mbinding.viewModel = PlacesViewModel(this, result)
            mbinding.executePendingBindings()
        }

        override fun OnItemClickListener() {
//            Toast.makeText()
        }

        init {
            this.mbinding = binding
        }
    }

}