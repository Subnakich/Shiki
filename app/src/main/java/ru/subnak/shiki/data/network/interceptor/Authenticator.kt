package ru.subnak.shiki.data.network.interceptor

import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route

class ShikimoriAuthenticator : Authenticator {

    override fun authenticate(route: Route?, response: Response): Request? {
        //val storedToken = "Bearer ${holder.getToken()?.authToken}"
        val requestToken = response.request.header(TOKEN_HEADER)

        val builder = response.request.newBuilder()

//        if (storedToken == requestToken) {
//            holder.refresh()
//        }
//        val b = builder.header(TOKEN_HEADER, "Bearer ${holder.getToken()?.authToken}").build()
        return b
    }

    companion object {
        private const val TOKEN_BEARER = "Bearer %s"
        private const val TOKEN_HEADER = "Authorization"
    }
}