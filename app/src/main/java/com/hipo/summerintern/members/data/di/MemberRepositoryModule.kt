package com.hipo.summerintern.members.data.di

import com.hipo.summerintern.members.data.dao.MemberDao
import com.hipo.summerintern.members.data.mapper.MemberDTOMapper
import com.hipo.summerintern.members.data.repository.MemberRepositoryImpl
import com.hipo.summerintern.members.domain.repository.MemberRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object MemberRepositoryModule {

    @Provides
    @Named(MemberRepository.INJECTION_NAME)
    fun provideMemberRepository(
        memberDao: MemberDao,
        memberDTOMapper: MemberDTOMapper
    ): MemberRepository {
        return MemberRepositoryImpl(memberDao, memberDTOMapper)
    }
}
