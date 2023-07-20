package com.lionheart.domain.repository

interface FcmRepository {
    fun getFCMToken(fcmToken: (String) -> Unit): Any
}