package com.example.qrscanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ScanView : AppCompatActivity() {
    companion object {
        const val NAME_EXTRA="name_extra"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan_view)
        val url=intent.getStringExtra(NAME_EXTRA)
        val view=findViewById<TextView>(R.id.textView)
        view.text = "$url"
    }
}