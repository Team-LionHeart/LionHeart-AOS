package com.lionheart.data.repository

import com.lionheart.domain.entity.AuthToken
import com.lionheart.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(

) : AuthRepository {

    override suspend fun reissueToken(): AuthToken {
        TODO("Not yet implemented")
    }

    override suspend fun logout(): Boolean {
        TODO("Not yet implemented")
    }
}