package com.example.samplelibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    /**
     * 画面の初期化
     */
    private fun initView() {
        findViewById<HorizontalInfiniteCycleViewPager>(R.id.infinite_cycle_view_pager).apply {
            adapter = SamplePagerAdapter(context)
        }
    }
}