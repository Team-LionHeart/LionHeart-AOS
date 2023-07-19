package com.lionheart.data.repository

import com.lionheart.domain.entity.AuthToken
import com.lionheart.domain.entity.SignUpInfo
import com.lionheart.domain.entity.SocialType
import com.lionheart.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
//    private val authDataSource: AuthDataSource,
) : AuthRepository {
    override suspend fun socialLogin(
        socialType: SocialType,
        token: String,
        fcmToken: String,
    ): AuthToken {
        TODO("Not yet implemented")
    }

    override suspend fun logout(): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun reissueToken(): AuthToken {
        TODO("Not yet implemented")
    }

    override suspend fun signUp(signUpInfo: SignUpInfo): AuthToken {
        TODO("Not yet implemented")
    }
}
