package com.cua.katsuhub.model.anime

import com.google.gson.annotations.SerializedName
data class Data(

	@field:SerializedName("attributes")
	val attributes: Attributes = Attributes(),

	@field:SerializedName("id")
	val id: String = "",

	@field:SerializedName("type")
	val type: String? = ""
)