package com.sec.android.app.comebackhome.setting.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sec.android.app.comebackhome.setting.model.SnapshotModel
import com.sec.android.app.comebackhome.setting.repository.SnapshotRepository

class SnapshotViewModel : ViewModel() {

    fun insertData(context: Context, snapshotInfo: String) {
       SnapshotRepository.insertSnapshot(context, snapshotInfo)
    }

    fun getSnapshotDetails(context: Context, createdAt: Long) : LiveData<SnapshotModel>? {
        return SnapshotRepository.getSnapshotDetails(context, createdAt)
    }

    fun getAllSnapshotDetails(context: Context) : LiveData<List<SnapshotModel>>? {
        return SnapshotRepository.getAllSnapshotDetails(context)
    }

}