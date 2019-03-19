package com.cua.katsuhub.model

import com.google.gson.annotations.SerializedName

data class Names(

	@field:SerializedName("en")
	val en: String? = null,

	@field:SerializedName("ja_jp")
	val jaJp: String? = null
)