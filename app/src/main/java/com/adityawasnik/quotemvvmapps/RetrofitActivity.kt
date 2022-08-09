package com.adityawasnik.quotemvvmapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.create

class RetrofitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        val quotesAPI = RetrofitHelper.getInstance().create(QuoteAPI::class.java)
        GlobalScope.launch {
            val result = quotesAPI.getQuotes(1)
            if(result != null){

                val quoteList = result.body()
                if(quoteList != null){
                    quoteList.results.forEach {

                        Log.d("ADITYA",it.content)
                    }
                }



            }
        }







    }
}