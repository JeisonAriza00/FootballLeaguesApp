package com.jjariza.footballleaguesapp.core

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import com.jjariza.footballleaguesapp.databinding.ActivityWebBinding

class WebActivity : AppCompatActivity() {

    companion object{
        fun startActivity(context: Context, url: String){
            val intent = Intent(context, WebActivity::class.java)
            intent.putExtra("url", url)
            context.startActivity(intent)
        }
    }

    lateinit var binding: ActivityWebBinding

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.webView.webViewClient = WebViewClient()
        binding.webView.apply {
            loadUrl(intent.getStringExtra("url") ?: "")
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true
        }
    }

    override fun onBackPressed() {
        if(binding.webView.canGoBack()) binding.webView.goBack() else super.onBackPressed()
    }
}