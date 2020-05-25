package com.benchmate.sports.data.responsebean.PlacesResponse


import com.google.gson.annotations.SerializedName


data class Geometry(

	@field:SerializedName("viewport")
	val viewport: Viewport? = null,

	@field:SerializedName("location")
	val location: Location? = null
)