package com.cua.katsuhub.model.anime
import com.google.gson.annotations.SerializedName

data class Attributes(
	@field:SerializedName("createdAt")
	val createdAt: String? = "",

	@field:SerializedName("averageRating")
	val averageRating: String? = "",

	@field:SerializedName("showType")
	val showType: String? = "",

	@field:SerializedName("episodeLength")
	val episodeLength: Int? = 0,

	@field:SerializedName("synopsis")
	val synopsis: String? = "",

	@field:SerializedName("titles")
	val titles: Titles? = Titles(),

	@field:SerializedName("ageRating")
	val ageRating: String? = "",

	@field:SerializedName("totalLength")
	val totalLength: Int? = 0,

	@field:SerializedName("status")
	val status: String? = ""
)