package com.hipo.summerintern.members.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.hipo.summerintern.members.data.model.entity.MemberEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MemberDao {

    @Query("SELECT * FROM member_entity")
    fun getMembers(): Flow<List<MemberEntity>>
}
