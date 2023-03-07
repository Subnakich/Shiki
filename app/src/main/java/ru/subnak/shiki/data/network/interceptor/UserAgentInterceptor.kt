package ru.subnak.shiki.data.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class UserAgentInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()

        val request = original.newBuilder()
            .addHeader(USER_AGENT_HEADER, USER_AGENT_CLIENT)
            .build()

        return chain.proceed(request)
    }

    companion object {
        const val USER_AGENT_HEADER = "User-Agent"
        const val USER_AGENT_CLIENT = "ShikimoriAndroidApp"
    }
}