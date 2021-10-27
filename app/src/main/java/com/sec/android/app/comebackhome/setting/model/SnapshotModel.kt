package com.sec.android.app.comebackhome.setting.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Snapshot")
data class SnapshotModel (

    @ColumnInfo(name = "created_at")
    var createdAt: Long,

    @ColumnInfo(name = "snapshot_info")
    var snapshotInfo: String

) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var Id: Int? = null

}