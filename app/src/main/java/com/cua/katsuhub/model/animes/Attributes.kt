package com.cua.katsuhub.model.animes
import com.google.gson.annotations.SerializedName

data class Attributes(
	@field:SerializedName("posterImage")
	val posterImage: PosterImage? = null
)