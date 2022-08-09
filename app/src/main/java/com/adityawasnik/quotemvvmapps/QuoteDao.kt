package com.adityawasnik.quotemvvmapps


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuoteDao {

    @Query("SELECT * from quote")
    fun getQuotes() : LiveData<List<Quote>>

    @Insert
    suspend fun insertQuote(quote: Quote)
}