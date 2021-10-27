package com.sec.android.app.comebackhome.setting.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.sec.android.app.comebackhome.R
import com.sec.android.app.comebackhome.setting.viewmodel.SnapshotViewModel
import kotlinx.android.synthetic.main.snapshot_add_fragment.view.*

class SnapshotAddFragment : Fragment(R.layout.snapshot_add_fragment) {

    lateinit var snapshotViewModel: SnapshotViewModel

    lateinit var snapshotInfo: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(R.layout.snapshot_add_fragment, container, false)

        snapshotViewModel = ViewModelProvider(this).get(SnapshotViewModel::class.java)

        view.btnAddSnapshot.setOnClickListener {

            snapshotInfo = """
            {
                "page_list": [
                {
                    "page_id": 0,
                    "icon_list": [
                    {
                        "icon_type": "app",
                        "icon_info": {
                        "package": "com.android.camera"
                    }
                    },
                    {
                        "icon_type": "folder",
                        "icon_info": {
                        "name": "game",
                        "app_list": [
                        "com.android.play",
                        "com.android.cardgame"
                        ]
                    }
                    }
                    ]
                },
                {
                    "page_id": 1,
                    "icon_list": [
                    {
                        "icon_type": "app",
                        "icon_info": {
                        "package": "com.android.photo"
                    }
                    },
                    {
                        "icon_type": "folder",
                        "icon_info": {
                        "name": "bank",
                        "app_list": [
                        "com.android.toss",
                        "com.android.wooribank"
                        ]
                    }
                    }
                    ]
                }
                ]
            }
            """

            if (snapshotInfo.isEmpty()) {
                view.lblInsertResponse.error = "invalid snapshot info"
            }
            else {
                snapshotViewModel.insertData(requireContext(), snapshotInfo)
                view.lblInsertResponse.text = "Inserted Successfully"
            }
        }

        return view
    }
}

