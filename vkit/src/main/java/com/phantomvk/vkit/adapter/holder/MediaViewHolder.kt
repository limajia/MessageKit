package com.phantomvk.vkit.adapter.holder

import android.content.Context
import android.graphics.Point
import android.view.View
import android.widget.ImageView
import com.phantomvk.vkit.model.IMessage
import com.phantomvk.vkit.model.Message
import kotlinx.android.synthetic.main.vkit_layout_msg_media.view.*

class MediaViewHolder(itemView: View) : BaseViewHolder(itemView) {

    /**
     * ImageView to display a thumbnail.
     */
    private val imageView: ImageView = itemView.image

    /**
     * An icon to indicate that this is a VideoMessage.
     */
    private val iconPlay: ImageView = itemView.play

    override fun onBind(context: Context, message: IMessage) {
        val msgType = message.getMsgType()
        if (msgType == Message.MESSAGE_TYPE_IMAGE) {
            iconPlay.visibility = View.GONE
        } else {
            iconPlay.visibility = View.VISIBLE
        }
    }

    /**
     * Calculate the size of thumbnail ImageView.
     */
    private fun resize(point: Point,
                       width: Int, height: Int,
                       maxWidth: Int, maxHeight: Int,
                       minSize: Float, maxSize: Float) {
        var scale = if (width / height > maxWidth / maxHeight) {
            maxWidth.toFloat() / width
        } else {
            maxHeight.toFloat() / height
        }

        var maxScale = if (width > height) maxSize / width else maxSize / height
        maxScale = Math.max(1F, maxScale)

        scale = Math.min(maxScale, scale)
        point.x = Math.max(minSize, width * scale).toInt()
        point.y = Math.max(minSize, height * scale).toInt()
    }
}
