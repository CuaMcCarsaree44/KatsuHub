package com.cua.katsuhub.model.animes

data class DataItem(
	val attributes: Attributes = Attributes(),
	val links: Links = Links(),
	val id: String = "",
	val type: String = ""
)