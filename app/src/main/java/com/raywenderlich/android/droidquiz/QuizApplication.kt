package com.raywenderlich.android.droidquiz

import android.app.Application
import androidx.room.Room
import com.raywenderlich.android.droidquiz.data.db.QuizDatabase
import com.raywenderlich.android.droidquiz.data.migrations.Migration1To2

class QuizApplication : Application() {

    private val DB_NAME = "quiz_database"

    companion object {
        lateinit var database: QuizDatabase
            private set
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, QuizDatabase::class.java, DB_NAME)
            .addMigrations(
                QuizDatabase.MIGRATION_1_TO_2,
                QuizDatabase.MIGRATION_2_TO_3,
                QuizDatabase.MIGRATION_1_TO_3
            )
            .build()


    }

}
