package com.hipo.summerintern.core.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context): SummerInternDatabase {
        return Room
            .databaseBuilder(appContext, SummerInternDatabase::class.java, SummerInternDatabase.DATABASE_NAME)
            .createFromAsset("summer_intern_db")
            .fallbackToDestructiveMigration()
            .build()
    }
}
