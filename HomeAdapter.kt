package com.rd.pageindicatorview.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.viewpager.widget.PagerAdapter

import com.rd.pageindicatorview.sample.R
import com.rd.pageindicatorview.sample.databinding.CarouselTemplateBinding

class HomeAdapter(private val context: Context, private val carouselContents: List<CarouselContent>) : PagerAdapter() {

    override fun instantiateItem(collection: ViewGroup, position: Int): Any {
        val layoutInflater = LayoutInflater.from(context)
        val viewDataBinding: ViewDataBinding = DataBindingUtil.inflate(
                layoutInflater, R.layout.carousel_template, collection, false)
        (viewDataBinding as CarouselTemplateBinding).carouselContent = carouselContents[position]
        collection.addView(viewDataBinding.root)
        return viewDataBinding.root
    }

    override fun destroyItem(collection: ViewGroup, position: Int, view: Any) {
        collection.removeView(view as View)
    }

    override fun getCount(): Int {
        return carouselContents.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun getItemPosition(`object`: Any): Int {
        return POSITION_NONE
    }
}