package com.cua.katsuhub.databinding

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.cua.katsuhub.R

class GlideBindingHandler {
    companion object {
        @BindingAdapter("imageUrl")
        fun setImage(img: ImageView, url:String)
        {
            val context: Context = img.getContext()
            val option:RequestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(context).setDefaultRequestOptions(option)
                .load(url)
                .into(img)
        }
    }
}