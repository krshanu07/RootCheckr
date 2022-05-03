package com.arcadiustech.rootcheckr

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arcadiustech.rootcheckr.databinding.FragmentDeviceInfoBinding

class DeviceInfoFragment : Fragment() {

    private var binding : FragmentDeviceInfoBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        val fragmentBinding = FragmentDeviceInfoBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onStart() {
        super.onStart()
        getDetails()
    }

    private fun getDetails(){
        binding?.apply {
            deviceName.text = Build.DEVICE.toString()
            brandName.text = Build.BRAND.toString()
            manufacturerName.text = Build.MANUFACTURER.toString()
            modelName.text = Build.MODEL.toString()
            androidVerName.text = Build.VERSION.RELEASE.toString()
            bootloaderName.text = Build.BOOTLOADER.toString()
            displayName.text = Build.DISPLAY.toString()
            fingerprintName.text = Build.FINGERPRINT.toString()
            hardwareName.text = Build.HARDWARE.toString()
        }
    }
}