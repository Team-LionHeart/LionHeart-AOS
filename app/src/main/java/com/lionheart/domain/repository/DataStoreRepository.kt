package com.lionheart.domain.repository

import com.lionheart.domain.entity.Authentication

interface DataStoreRepository {
    suspend fun setAuthentication(authentication: Authentication)
    suspend fun getAuthentication(): Authentication
}