package ru.subnak.shiki.data.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import ru.subnak.shiki.data.local.TokenRepository
import javax.inject.Inject

class TokenInterceptor @Inject constructor(
    private val repository: TokenRepository
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()

        val requestBuilder = original.newBuilder()
        if (repository.isTokenExists()) {
            requestBuilder.addHeader(
                TOKEN_HEADER,
                String.format(TOKEN_BEARER, repository.getToken()?.authToken)
            )
        }

        val request = requestBuilder.build()
        return chain.proceed(request)
    }

    companion object {
        private const val TOKEN_BEARER = "Bearer %s"
        private const val TOKEN_HEADER = "Authorization"
    }

}