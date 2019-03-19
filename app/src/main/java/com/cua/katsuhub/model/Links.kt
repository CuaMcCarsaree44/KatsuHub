package com.cua.katsuhub.model

import com.google.gson.annotations.SerializedName

data class Links(

	@field:SerializedName("last")
	val last: String? = null,

	@field:SerializedName("first")
	val first: String? = null,

	@field:SerializedName("self")
	val self: String? = null,

	@field:SerializedName("related")
	val related: String? = null
)