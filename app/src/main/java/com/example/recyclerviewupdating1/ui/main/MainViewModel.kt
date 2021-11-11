package com.example.recyclerviewupdating1.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var numNewItem:Int=0

    private var _items: MutableList<String> = MutableList(30) { "item$it" }
    val items: List<String>
        get() = _items

    fun remove(pos:Int){
        _items.removeAt(pos)
    }

    fun addItem(){
        _items.add("newItem$numNewItem")
        numNewItem++
    }
}