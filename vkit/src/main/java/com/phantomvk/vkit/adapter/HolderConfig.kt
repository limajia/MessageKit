package com.phantomvk.vkit.adapter

import android.view.View
import androidx.annotation.LayoutRes
import com.phantomvk.vkit.adapter.holder.AbstractViewHolder

class HolderConfig constructor(@LayoutRes val layoutId: Int,
                               val holder: (View) -> AbstractViewHolder,
                               val unique: Boolean = false,
                               val maxRecycledViews: Int = 8)
