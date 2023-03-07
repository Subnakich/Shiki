package ru.subnak.shiki.domain.auth

import ru.subnak.shiki.domain.entity.Token

interface AuthRepository {

    fun signIn(authCode: String): Token

    fun refreshToken(refreshToken: String): Token
}