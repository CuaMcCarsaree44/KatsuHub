package com.cua.katsuhub.model

import com.google.gson.annotations.SerializedName

data class Meta(

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("dimensions")
	val dimensions: Dimensions? = null
)