package com.hipo.summerintern.members.data.di

import com.hipo.summerintern.core.database.SummerInternDatabase
import com.hipo.summerintern.members.data.dao.MemberDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object MemberDaoModule {

    @Provides
    fun provideMemberDao(database: SummerInternDatabase): MemberDao {
        return database.memberDao()
    }
}
