package com.example.task5.data.mapper

interface Mapper<in Model_A,out Model_B> {
    fun mapModel(item:Model_A):Model_B
    fun mapToList(itemList: List<Model_A>):List<Model_B>{
        return itemList.map { mapModel(it) }
    }
}