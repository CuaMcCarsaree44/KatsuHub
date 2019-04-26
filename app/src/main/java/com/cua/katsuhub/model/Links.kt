package com.cua.katsuhub.model

import com.google.gson.annotations.SerializedName

data class Links(

	@SerializedName("last")
	val last: String? = "",

	@SerializedName("first")
	val first: String? = "",

	@SerializedName("self")
	val self: String? = "",

	@SerializedName("related")
	val related: String? = ""
)