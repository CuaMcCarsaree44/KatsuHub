package com.cua.katsuhub.model
import com.google.gson.annotations.SerializedName

data class Data(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("meta")
	val meta: Meta? = null,

	@field:SerializedName("links")
	val links: Links? = null
)