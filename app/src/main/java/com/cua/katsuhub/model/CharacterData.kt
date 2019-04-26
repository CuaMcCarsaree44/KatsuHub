package com.cua.katsuhub.model

import com.google.gson.annotations.SerializedName

data class CharacterData(
    val id: String = "",
    val type: String = "",
    val links: Links = Links(),
    @SerializedName("attributes")
    val character: Character = Character()
)

data class Character(
    val name: String = "",
    val description: String = "",
    val image: Image? = Image()
){
    fun getImageUrl() : String {
        image?.let {
            return it.original ?: ""
        }?: return ""
    }
}