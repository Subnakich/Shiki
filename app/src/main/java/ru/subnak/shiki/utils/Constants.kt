package ru.subnak.shiki.utils

object Constants {

    const val AUTH_URL = "https://shikimori.one/oauth/authorize?" +
            "client_id=gyijmf-nL2U6M9qmkwth9N6e3oIppzVdJLRG-LSNm4g&" +
            "redirect_uri=urn%3Aietf%3Awg%3Aoauth%3A2.0%3Aoob&response_type=code"

    const val REDIRECT_URI = "urn:ietf:wg:oauth:2.0:oob"

    const val TIMEOUT_DEFAULT = 15L
}