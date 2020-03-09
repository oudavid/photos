package com.acs.photos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import kotlinx.android.synthetic.main.camera_item.view.*

class PhotoAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<PhotoAdapter.ListViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var lists = emptyList<Photo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView = inflater.inflate(R.layout.camera_item, parent, false)
        return ListViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: ListViewHolder, position: Int) {
        viewHolder.bind(lists[position])
    }

    internal fun setLists(lists: List<Photo>) {
        this.lists = lists
        notifyDataSetChanged()
    }

    override fun getItemCount() = lists.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val listItemView: TextView = itemView.item_title

        fun bind(photo: Photo) {
            listItemView.text = photo.camera.name
        }
    }
}





