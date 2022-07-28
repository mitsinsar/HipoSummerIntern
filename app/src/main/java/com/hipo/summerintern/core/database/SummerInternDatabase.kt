package com.hipo.summerintern.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hipo.summerintern.core.database.SummerInternDatabase.Companion.LATEST_DB_VERSION
import com.hipo.summerintern.members.data.dao.MemberDao

@Database(
    version = LATEST_DB_VERSION,
    exportSchema = true
)
abstract class SummerInternDatabase : RoomDatabase() {

    abstract fun memberDao(): MemberDao

    companion object {
        const val LATEST_DB_VERSION = 1

        const val DATABASE_NAME = "summer_intern_db"
    }
}
