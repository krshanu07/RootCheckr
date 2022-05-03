package com.arcadiustech.rootcheckr

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arcadiustech.rootcheckr.databinding.FragmentRootStatusBinding

class RootStatusFragment : Fragment() {

    private var binding: FragmentRootStatusBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        val fragmentBinding = FragmentRootStatusBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onStart() {
        super.onStart()
        getInfo()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.verifyBtn?.setOnClickListener{
            try {
                Runtime.getRuntime().exec("su")
                binding?.apply {
                    verifyRootStatus.apply {
                        text = getString(R.string.rooted)
                        setTextColor(Color.parseColor("#66bb6a"))
                    }
                    deviceImage.setImageResource(R.drawable.smartphone_green)
                    verifyBtn.visibility = View.INVISIBLE
                }

            } catch (e: Exception) {
                binding?.apply {
                    verifyRootStatus.apply {
                        text = getString(R.string.not_rooted)
                        setTextColor(Color.parseColor("#ef5350"))
                    }
                    deviceImage.setImageResource(R.drawable.smartphone_red)
                    verifyBtn.visibility = View.INVISIBLE
                }
            }
        }
    }

    private fun getInfo() {
        binding?.apply {
            device.text = Build.MODEL.toString()
            version.text = getString(R.string.android, Build.VERSION.RELEASE)
        }
    }
}