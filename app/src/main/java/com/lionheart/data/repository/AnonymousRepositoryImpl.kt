package com.lionheart.data.repository

import com.lionheart.data.datasource.AuthDataSource
import com.lionheart.domain.entity.AuthToken
import com.lionheart.domain.entity.SignUpInfo
import com.lionheart.domain.entity.SocialType
import com.lionheart.domain.repository.AnonymousRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AnonymousRepositoryImpl @Inject constructor(
    private val authDataSource: AuthDataSource
) : AnonymousRepository {

    override suspend fun socialLogin(
        socialType: SocialType,
        token: String,
        fcmToken: String
    ) = flow {
        authDataSource.socialLogin(socialType.name, token, fcmToken).data?.toAuthToken()
            ?.let { emit(it) }
    }

    override suspend fun signUp(signUpInfo: SignUpInfo): Flow<AuthToken> = flow {
        authDataSource.signUp(
            signUpInfo.socialType.name,
            signUpInfo.token,
            signUpInfo.fcmToken,
            signUpInfo.pregnantWeek,
            signUpInfo.babyNickname
        ).data?.toAuthToken()?.let { emit(it) }
    }
}