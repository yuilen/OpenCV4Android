package com.ealax.opencvdemo.fliters

import org.opencv.core.Core
import org.opencv.core.Mat

/**
 * Created by linwuyi on 2018/10/25
 * Explanation:
 */
class RecolorRcFilter : Filter{

    private var mChannels = arrayOfNulls<Mat>(4).toMutableList()

    override fun apply(src: Mat, dst: Mat) {
        Core.split(src, mChannels)
        val g = mChannels[1]
        val b = mChannels[2]
        Core.addWeighted(g,0.5,b,0.5,0.0,g)
        mChannels[2] = g
        Core.merge(mChannels,dst)
    }

}