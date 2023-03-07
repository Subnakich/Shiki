package ru.subnak.shiki.data.network.impl

import ru.subnak.shiki.data.mapper.AuthMapper
import ru.subnak.shiki.data.network.ApiFactory
import ru.subnak.shiki.data.network.apiservice.ApiAuth
import ru.subnak.shiki.domain.auth.AuthRepository
import ru.subnak.shiki.domain.entity.Token
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val mapper: AuthMapper
    ) : AuthRepository{

    private val apiAuth = ApiFactory.apiAuth

    override fun signIn(authCode: String): Token {
        return mapper.dtoToToken(apiAuth.getToken(AUTH_CODE, code = authCode))
    }

    override fun refreshToken(refreshToken: String): Token {
        return mapper.dtoToToken(apiAuth.getToken(REFRESH_TOKEN, refreshToken = refreshToken))
    }

    companion object {
        private const val AUTH_CODE = "authorization_code"
        private const val REFRESH_TOKEN = "refresh_token"
    }
}