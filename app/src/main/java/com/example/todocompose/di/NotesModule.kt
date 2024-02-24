package com.example.todocompose.di

import android.content.Context
import androidx.room.Room
import com.example.todocompose.db.NotesDatabase
import com.example.todocompose.repository.NotesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NotesModule {

    @Provides
    @Singleton
    fun providesDB(@ApplicationContext app:Context):NotesDatabase = NotesDatabase(app)

    @Provides
    @Singleton
    fun providesRepository(db:NotesDatabase) = NotesRepository(db)





}