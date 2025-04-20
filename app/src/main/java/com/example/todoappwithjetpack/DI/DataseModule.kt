package com.example.todoappwithjetpack.DI

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.todoappwithjetpack.roomDb.ToDoDatabase
import com.example.todoappwithjetpack.utility.AppConstants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context)=
        Room.databaseBuilder(context, ToDoDatabase::class.java,DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideDao(database: ToDoDatabase)=database.toDoDao()
}