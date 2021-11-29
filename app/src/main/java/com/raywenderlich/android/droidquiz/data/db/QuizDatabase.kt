package com.raywenderlich.android.droidquiz.data.db

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import com.raywenderlich.android.droidquiz.data.migrations.Migration1To2
import com.raywenderlich.android.droidquiz.data.migrations.Migration1To3
import com.raywenderlich.android.droidquiz.data.migrations.Migration2To3
import com.raywenderlich.android.droidquiz.data.migrations.Migration3To4
import com.raywenderlich.android.droidquiz.data.model.Answer
import com.raywenderlich.android.droidquiz.data.model.Question

@Database(
    entities = [(Question::class), (Answer::class)], version = 4, exportSchema = true,
    autoMigrations = [
        AutoMigration(
            from = 3,
            to = 4,
            spec = Migration3To4::class
        )
    ]

)
abstract class QuizDatabase : RoomDatabase() {
    abstract fun quizDao(): QuizDao

    companion object {
        val MIGRATION_1_TO_2 = Migration1To2()
        val MIGRATION_2_TO_3 = Migration2To3()
        val MIGRATION_1_TO_3 = Migration1To3()

    }
}
