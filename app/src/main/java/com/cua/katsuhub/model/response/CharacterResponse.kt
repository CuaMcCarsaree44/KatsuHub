package com.cua.katsuhub.model.response

import com.cua.katsuhub.model.CharacterData
import com.cua.katsuhub.model.Links
import com.cua.katsuhub.model.Meta

data class CharacterResponse(
    val data: List<CharacterData> = emptyList(),
    val meta: Meta = Meta(),
    val links: Links = Links()
)