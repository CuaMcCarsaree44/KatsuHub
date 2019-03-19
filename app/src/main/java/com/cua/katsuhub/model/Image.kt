package com.cua.katsuhub.model

import com.google.gson.annotations.SerializedName

data class Image(

	@SerializedName("original")
	val original: String? = ""
)