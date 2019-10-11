package com.kross.easylist

import android.view.ViewGroup

/**
 * Cell means a item view in recyclerView
 * */
abstract class Cell<T> {

    var data: Any? = null

    fun getViewType(): Int {
        return this.javaClass.hashCode()
    }

    constructor() {}

    constructor(d: T) {
        data = d
    }

    fun id(): Long {
        return 0L
    }

    /**
     * create view holder and view
     * */
    abstract fun onCreateViewHolder(parentView: ViewGroup): VH

    /**
     * bind data to views
     * */
    abstract fun onBindData(vh: VH, payload: MutableList<Any>)
}