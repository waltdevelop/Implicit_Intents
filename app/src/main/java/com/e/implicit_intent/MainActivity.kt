package com.e.implicit_intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.app.ShareCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        website_button.setOnClickListener(){
            if (website.text.isEmpty()) {
                Toast.makeText(this, "Please enter website", Toast.LENGTH_SHORT).show()
            } else {
                openwebsite(website_button)
                website.text = null
            }
        }

        dialpad_button.setOnClickListener(){
            if (dialpad.text.isEmpty()) {
                Toast.makeText(this, "Please enter number", Toast.LENGTH_SHORT).show()
            } else {
                opendialpad(dialpad_button)
                dialpad.text = null
            }
        }

        map_button.setOnClickListener(){
            if (maps.text.isEmpty()) {
                Toast.makeText(this, "Please enter location", Toast.LENGTH_SHORT).show()
            } else {
                openmap(map_button)
                maps.text = null
            }
        }

        share_button.setOnClickListener(){
            if (share.text.isEmpty()) {
                Toast.makeText(this, "Please enter text", Toast.LENGTH_SHORT).show()
            } else {
                shareText(share_button)
                share.text = null
            }
        }
    }

    fun openwebsite(view: View) {
        val IntyA = Intent(Intent.ACTION_VIEW)
        IntyA.setData(Uri.parse("https://" + website.text.toString()))
        startActivity(IntyA)
    }
    fun opendialpad(view: View) {
        val IntyB = Intent(Intent.ACTION_VIEW)
        IntyB.setData(Uri.parse("tel:" + dialpad.text.toString()))
        startActivity(IntyB)
    }
    fun openmap(view: View) {
        val IntyC = Intent(Intent.ACTION_VIEW)
        IntyC.setData(Uri.parse("geo:0?q=" + maps.text.toString()))
        startActivity(IntyC)
    }
    fun shareText(view: View) {
        ShareCompat.IntentBuilder.from(this)
            .setText(share.text.toString())
            .setChooserTitle("Sharing Text")
            .setType("text/plain").startChooser()
    }
}
