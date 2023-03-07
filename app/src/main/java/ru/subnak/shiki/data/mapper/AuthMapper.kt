package ru.subnak.shiki.data.mapper

import ru.subnak.shiki.data.network.entity.TokenDTO
import ru.subnak.shiki.domain.entity.Token
import javax.inject.Inject

class AuthMapper @Inject constructor() {

    fun dtoToToken(tokenDTO: TokenDTO) = Token(tokenDTO.accessToken, tokenDTO.refreshToken)
}