package com.raywenderlich.android.droidquiz.data.migrations

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class Migration2To3 : Migration(2, 3) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "CREATE TABLE question_new (question_id INTEGER NOT NULL, " +
                    "text TEXT NOT NULL, " +
                    "difficulty TEXT NOT NULL, " +
                    "PRIMARY KEY (question_id))"
        )

        database.execSQL("CREATE INDEX index_question_new_question_id ON question_new(question_id)")

        database.execSQL(
            "INSERT INTO question_new (question_id, text, difficulty) " +
                    "SELECT question_id, text, difficulty FROM questions"
        )

        database.execSQL("DROP TABLE questions")

        database.execSQL("ALTER TABLE question_new RENAME TO questions")

    }
}
