package com.example.notesappcompose.dependencyinjection

import android.content.Context
import androidx.room.Room
import com.example.notesappcompose.database.AppDatabase
import com.example.notesappcompose.database.dbmapper.DbMapper
import com.example.notesappcompose.database.dbmapper.DbMapperImpl
import com.example.notesappcompose.repository.Repository
import com.example.notesappcompose.repository.RepositoryImpl

class DependencyInjector(applicationContext: Context) {

    val repository: Repository by lazy { provideRepository(database) }

    private val database: AppDatabase by lazy { provideDatabase(applicationContext) }

    private val dbMapper: DbMapper = DbMapperImpl()

    private fun provideDatabase(applicationContext: Context): AppDatabase =
        Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).build()

    private fun provideRepository(database: AppDatabase): Repository {
        val noteDao = database.noteDao()
        val colorDao = database.colorDao()

        return RepositoryImpl(noteDao, colorDao, dbMapper)
    }

}