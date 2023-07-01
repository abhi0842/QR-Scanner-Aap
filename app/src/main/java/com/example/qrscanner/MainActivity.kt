package com.example.qrscanner

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.zxing.integration.android.IntentIntegrator


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val scanbutton = findViewById<Button>(R.id.scanbutton)
        scanbutton.setOnClickListener{
            val scanner= IntentIntegrator(this)
            scanner.initiateScan()
        }
        
        
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode==Activity.RESULT_OK){
          val result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data)
     if(result != null) {
         if (result.contents == null) {

             Toast.makeText(this, "Scanning cancelled", Toast.LENGTH_LONG).show()
         } else {
             val name =result.contents
             val intent= Intent(this,ScanView::class.java)
             intent.putExtra(ScanView.NAME_EXTRA,name)
             startActivity(intent)

         }
     }
           }
       }
    }
