package com.cua.katsuhub.model

import com.google.gson.annotations.SerializedName

data class Relationships(

	@field:SerializedName("castings")
	val castings: Castings? = null,

	@field:SerializedName("primaryMedia")
	val primaryMedia: PrimaryMedia? = null,

	@field:SerializedName("mediaCharacters")
	val mediaCharacters: MediaCharacters? = null,

	@field:SerializedName("quotes")
	val quotes: Quotes? = null
)