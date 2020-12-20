package com.example.samplelibrary

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.PagerAdapter

class SamplePagerAdapter(private val context: Context) : PagerAdapter() {

    private data class Sample(
        /**
         * 表示内容
         */
        val text: String = "",
        /**
         * 表示色
         */
        val color: Int = 0

    )

    private val list: List<Sample> = listOf(
        Sample("パープル200", ContextCompat.getColor(context, R.color.purple_200)),
        Sample("パープル500", ContextCompat.getColor(context, R.color.purple_500)),
        Sample("パープル700", ContextCompat.getColor(context, R.color.purple_700))
    )

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(context)
        val data = list[position]
        val view = (inflater.inflate(R.layout.sample_layoput, container as? ViewGroup, false) as View).apply {
            findViewById<TextView>(R.id.sample_title).text = data.text
            findViewById<View>(R.id.sample_color_view).setBackgroundColor(data.color)
        }

        container.addView(view)
        return view
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as? View)
    }
}