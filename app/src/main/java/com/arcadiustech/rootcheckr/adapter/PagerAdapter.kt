package com.arcadiustech.rootcheckr.adapter

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.arcadiustech.rootcheckr.DeviceInfoFragment
import com.arcadiustech.rootcheckr.RootStatusFragment

class PagerAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> { RootStatusFragment() }
            1 -> { DeviceInfoFragment() }
            else -> { throw Resources.NotFoundException("Position Not Found")}
        }

    }
}