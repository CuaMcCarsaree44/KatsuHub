package com.cua.katsuhub.model

data class Data(
    val attributes: Attributes,
    val id: String,
    val links: LinksX,
    val relationships: Relationships,
    val type: String
)