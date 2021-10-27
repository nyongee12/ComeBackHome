package com.sec.android.app.comebackhome.setting.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sec.android.app.comebackhome.R
import com.sec.android.app.comebackhome.adapter.JsonConverter
import com.sec.android.app.comebackhome.setting.viewmodel.SnapshotViewModel
import kotlinx.android.synthetic.main.snapshot_restore_fragment.view.*
import java.text.SimpleDateFormat
import java.util.*


class SnapshotRestoreFragment : Fragment(R.layout.snapshot_restore_fragment) {

    lateinit var snapshotViewModel: SnapshotViewModel

    var createdAt: Long = 0

    fun convertLongToTime(time: Long): String {
        val date = Date(time)
        val format = SimpleDateFormat("yyyy.MM.dd HH:mm:ss")
        return format.format(date)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(R.layout.snapshot_restore_fragment, container, false)

        snapshotViewModel = ViewModelProvider(this).get(SnapshotViewModel::class.java)

        snapshotViewModel.getAllSnapshotDetails(requireContext())!!.observe(this, Observer {

            if (it == null) {
                view.lblRestoreResponse.text = "Snapshot Not Found"
            }
            else {
                view.lblRestoreResponse.text = "Snapshot Found Successfully"

                for (snapshot in it) {
                    val verticalLinearLayout = LinearLayout(requireContext())
                    verticalLinearLayout.orientation = LinearLayout.VERTICAL

                    val createdAt = TextView(requireContext())
                    createdAt.text = convertLongToTime(snapshot.createdAt)

                    val snapshotInfo = TextView(requireContext())
                    snapshotInfo.text = snapshot.snapshotInfo

                    snapshotInfo.setOnClickListener {
                        JsonConverter.jsonToObject(snapshot.snapshotInfo)
                        view.lblRestoreResponse.text = "Update Screen with " + convertLongToTime(snapshot.createdAt)
                    }

                    verticalLinearLayout.addView(createdAt)
                    verticalLinearLayout.addView(snapshotInfo)
                    view.HorizontalLinearLayout.addView(verticalLinearLayout)
                }
            }
        })

        return view
    }
}

