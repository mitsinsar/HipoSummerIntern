package com.hipo.summerintern.members.data.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = MemberEntity.ENTITY_NAME)
data class MemberEntity(

    @PrimaryKey
    @ColumnInfo(name = "github_username")
    val githubUsername: String,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "birth_year")
    val birthYear: Int,

    @ColumnInfo(name = "location")
    val location: String,

    @ColumnInfo(name = "position")
    val position: String,

    @ColumnInfo(name = "start_year")
    val startYear: Int
) {

    companion object {
        const val ENTITY_NAME = "member_entity"
    }
}
