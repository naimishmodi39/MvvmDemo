package com.benchmate.sports.data.responsebean.PlacesResponse


import com.google.gson.annotations.SerializedName


data class PlacesResponse(


	@field:SerializedName("results")
	val results: List<ResultsItem>? = null,

	@field:SerializedName("next_page_token")
	val nextPageToken: String? = null

	)