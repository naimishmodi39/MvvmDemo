package com.benchmate.sports.data.responsebean.PlacesResponse

import com.google.gson.annotations.SerializedName

data class ResultsItem(
	@field:SerializedName("icon")
	val icon: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("geometry")
	val geometry: Geometry? = null,

	@field:SerializedName("vicinity")
	val vicinity: String? = null,

	@field:SerializedName("place_id")
	val placeId: String? = null

)