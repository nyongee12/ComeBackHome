package com.sec.android.app.comebackhome.setting.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.sec.android.app.comebackhome.setting.model.SnapshotModel
import com.sec.android.app.comebackhome.setting.room.SnapshotDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class SnapshotRepository {

    companion object {

        var snapshotDatabase: SnapshotDatabase? = null

        fun initializeDB(context: Context) : SnapshotDatabase {
            return SnapshotDatabase.getDataseClient(context)
        }

        fun insertSnapshot(context: Context, snapshotInfo: String) {

            snapshotDatabase = initializeDB(context)

            CoroutineScope(IO).launch {
                val snapshot = SnapshotModel(System.currentTimeMillis(), snapshotInfo)
                snapshotDatabase!!.snapshotDao().InsertSnapshot(snapshot)
            }

        }

        fun getSnapshotDetails(context: Context, createdAt: Long) : LiveData<SnapshotModel>? {

            snapshotDatabase = initializeDB(context)

            return snapshotDatabase!!.snapshotDao().getSnapshotDetails(createdAt)
        }

        fun getAllSnapshotDetails(context: Context) : LiveData<List<SnapshotModel>>? {

            snapshotDatabase = initializeDB(context)

            return snapshotDatabase!!.snapshotDao().getAllSnapshotDetails()
        }

    }
}