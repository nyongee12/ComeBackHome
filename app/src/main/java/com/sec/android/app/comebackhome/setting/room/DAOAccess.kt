package com.sec.android.app.comebackhome.setting.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sec.android.app.comebackhome.setting.model.SnapshotModel

@Dao
interface DAOAccess {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun InsertSnapshot(snapshotModel: SnapshotModel)

    @Query("SELECT * FROM Snapshot WHERE created_at =:createdAt")
    fun getSnapshotDetails(createdAt: Long?) : LiveData<SnapshotModel>

    @Query("SELECT * FROM Snapshot ORDER BY id DESC")
    fun getAllSnapshotDetails() : LiveData<List<SnapshotModel>>

}