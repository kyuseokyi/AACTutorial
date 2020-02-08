package com.example.aacroomtutorial

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Word::class), version = 1, exportSchema = false)
public abstract class WordRoomDatabase : RoomDatabase() {

    abstract fun wordDao(): WordDao

    companion object {

        @Volatile
        private var INSTANCE: WordRoomDatabase? = null

        fun getDatabase(context: Context): WordRoomDatabase {
            val tempInatance = INSTANCE
            if (tempInatance != null) {
                return tempInatance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext, WordRoomDatabase::class.java, "word_databse").build()
                INSTANCE = instance
                return instance
            }
        }
    }
}