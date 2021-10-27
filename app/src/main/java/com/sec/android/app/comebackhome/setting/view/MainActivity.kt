package com.sec.android.app.comebackhome.setting.view

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sec.android.app.comebackhome.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView.setOnNavigationItemSelectedListener(this)

        supportFragmentManager.beginTransaction().add(R.id.linearLayout, SnapshotAddFragment()).commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.snapshot_add -> {
                supportFragmentManager.beginTransaction().replace(R.id.linearLayout , SnapshotAddFragment()).commitAllowingStateLoss()
                return true
            }
            R.id.snapshot_restore -> {
                supportFragmentManager.beginTransaction().replace(R.id.linearLayout, SnapshotRestoreFragment()).commitAllowingStateLoss()
                return true
            }
        }

        return false
    }
}