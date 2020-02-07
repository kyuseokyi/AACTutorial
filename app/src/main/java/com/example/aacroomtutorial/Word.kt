package com.example.aacroomtutorial

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//data class Word(val word: String)   // normal class

//use room component
@Entity(tableName = "word_table")
class Word(@PrimaryKey @ColumnInfo(name = "word") val word: String)
