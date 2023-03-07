package ru.subnak.shiki.data.network.apiservice

import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query
import ru.subnak.shiki.BuildConfig
import ru.subnak.shiki.data.network.entity.TokenDTO
import ru.subnak.shiki.utils.Constants

interface ApiAuth {
    @POST("/oauth/token")
    fun getToken(
        @Query("grant_type") grantType: String,
        @Query("client_id") clientId: String = BuildConfig.ShikimoriClientId,
        @Query("client_secret") clientSecret: String = BuildConfig.ShikimoriClientSecret,
        @Query("code") code: String? = null,
        @Query("redirect_uri") redirectUri: String? = Constants.REDIRECT_URI,
        @Query("refresh_token") refreshToken: String? = null
    ): TokenDTO
}