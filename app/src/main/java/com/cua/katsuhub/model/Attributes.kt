package com.cua.katsuhub.model
import com.google.gson.annotations.SerializedName

data class Attributes(

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("image")
	val image: Image? = null,

	@field:SerializedName("names")
	val names: Names? = null,

	@field:SerializedName("otherNames")
	val otherNames: List<Any?>? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("slug")
	val slug: String? = null,

	@field:SerializedName("malId")
	val malId: Int? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null,

	@field:SerializedName("canonicalName")
	val canonicalName: String? = null
)