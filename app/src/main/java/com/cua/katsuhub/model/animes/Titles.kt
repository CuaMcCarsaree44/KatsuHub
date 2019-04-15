package com.cua.katsuhub.model.animes

import com.google.gson.annotations.SerializedName
data class Titles(

	@field:SerializedName("en")
	val en: String? = "",

	@field:SerializedName("en_jp")
	val jp: String? = ""
)