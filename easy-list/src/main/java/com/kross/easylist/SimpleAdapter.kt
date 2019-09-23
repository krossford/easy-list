package com.kross.easylist

import android.util.SparseArray
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.Collections.emptyList

/**
 * A simple adapter implements, it delegate his function to Cell
 * DO NOT extends this again, just instance one, and use it.
 * */
class SimpleAdapter : RecyclerView.Adapter<VH>() {

    var list: List<Cell<*>> = emptyList()

    var vt2cell: SparseArray<Cell<*>> = SparseArray()

    override fun getItemViewType(position: Int): Int {
        val code = list[position].getViewType()
        vt2cell.put(code, list[position])
        return code
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return vt2cell.get(viewType).onCreateViewHolder(parent)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: VH, position: Int) {

    }

    override fun onBindViewHolder(holder: VH, position: Int, payloads: MutableList<Any>) {
        list[position].onBindData(holder, payloads)
    }
}