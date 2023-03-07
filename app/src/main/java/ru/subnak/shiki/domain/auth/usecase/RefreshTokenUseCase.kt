package ru.subnak.shiki.domain.auth.usecase

import ru.subnak.shiki.domain.auth.AuthRepository
import javax.inject.Inject

class RefreshTokenUseCase @Inject constructor(private val repository: AuthRepository) {

    operator fun invoke(refreshToken: String) = repository.refreshToken(refreshToken)
}