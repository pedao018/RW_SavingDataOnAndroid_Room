package com.raywenderlich.android.droidquiz.data.migrations

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class Migration1To3 : Migration(1, 3) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE questions ADD COLUMN difficulty TEXT NOT NULL DEFAULT '0'")
    }
}
