package com.cua.katsuhub.model

data class Attributes(
    val canonicalName: String,
    val createdAt: String,
    val description: String,
    val image: Image,
    val malId: Int,
    val name: String,
    val names: Names,
    val otherNames: List<Any>,
    val slug: String,
    val updatedAt: String
)