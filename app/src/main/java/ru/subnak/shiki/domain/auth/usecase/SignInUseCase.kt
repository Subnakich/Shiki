package ru.subnak.shiki.domain.auth.usecase

import ru.subnak.shiki.domain.auth.AuthRepository
import javax.inject.Inject

class SignInUseCase @Inject constructor(private val repository: AuthRepository) {

    operator fun invoke(authCode: String) = repository.signIn(authCode)
}