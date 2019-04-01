package com.cua.katsuhub.model.anime

import com.google.gson.annotations.SerializedName

data class PosterImage(

	@field:SerializedName("small")
	val small: String? = "",

	@field:SerializedName("original")
	val original: String? = "",

	@field:SerializedName("large")
	val large: String? = "",

	@field:SerializedName("tiny")
	val tiny: String? = "",

	@field:SerializedName("medium")
	val medium: String? = ""
)