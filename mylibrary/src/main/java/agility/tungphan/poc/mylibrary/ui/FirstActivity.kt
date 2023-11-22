package agility.tungphan.poc.mylibrary.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import agililty.tungphan.poc.mylibrary.R
import android.content.Intent
import android.view.View
import android.widget.Button

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        findViewById<Button>(R.id.btn1_next).setOnClickListener {
            startActivity(Intent(this@FirstActivity, SecondActivity::class.java))
        }
    }
}