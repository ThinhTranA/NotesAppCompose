package com.example.notesappcompose.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notesappcompose.data.model.ColorDbModel
import com.example.notesappcompose.database.dao.ColorDao
import com.example.notesappcompose.database.dao.NoteDao
import com.example.notesappcompose.database.model.NoteDbModel

/**
 * App's database.
 *
 * It contains two tables: Note table and Color table.
 */
@Database(entities = [NoteDbModel::class, ColorDbModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_NAME = "note-maker-database"
    }

    abstract fun noteDao(): NoteDao

    abstract fun colorDao(): ColorDao
}