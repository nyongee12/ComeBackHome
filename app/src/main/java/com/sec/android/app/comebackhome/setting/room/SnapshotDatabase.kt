package com.sec.android.app.comebackhome.setting.room

import android.content.Context
import androidx.room.*
import com.sec.android.app.comebackhome.setting.model.SnapshotModel

@Database(entities = arrayOf(SnapshotModel::class), version = 1, exportSchema = false)
abstract class SnapshotDatabase : RoomDatabase() {

    abstract fun snapshotDao() : DAOAccess

    companion object {

        @Volatile
        private var INSTANCE: SnapshotDatabase? = null

        fun getDataseClient(context: Context) : SnapshotDatabase {

            if (INSTANCE != null) return INSTANCE!!

            synchronized(this) {

                INSTANCE = Room
                    .databaseBuilder(context, SnapshotDatabase::class.java, "SNAPSHOT_DATABASE")
                    .fallbackToDestructiveMigration()
                    .build()

                return INSTANCE!!

            }
        }

    }

}