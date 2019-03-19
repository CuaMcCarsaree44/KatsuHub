package com.cua.katsuhub.model

import com.google.gson.annotations.SerializedName

data class Image(

	@field:SerializedName("original")
	val original: String? = null,

	@field:SerializedName("meta")
	val meta: Meta? = null
)