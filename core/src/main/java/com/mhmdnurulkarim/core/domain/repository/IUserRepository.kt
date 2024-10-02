package com.mhmdnurulkarim.core.domain.repository

import com.mhmdnurulkarim.core.data.Resource
import com.mhmdnurulkarim.core.domain.model.User
import kotlinx.coroutines.flow.Flow

interface IUserRepository {
    fun searchUser(query: String?): Flow<Resource<List<User>>>

    fun getDetailUser(username: String): Flow<Resource<User>>

    fun getUserFollowers(username: String): Flow<Resource<List<User>>>

    fun getUserFollowing(username: String): Flow<Resource<List<User>>>

    fun getFavoriteListUser(): Flow<List<User>>

    fun getFavoriteDetailState(username: String): Flow<User>?

    suspend fun insertFavoriteUser(user: User)

    suspend fun deleteFavoriteUser(user: User): Int
}