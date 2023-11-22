package agility.tungphan.poc.mylibrary.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import agililty.tungphan.poc.mylibrary.R
import android.content.Intent
import android.view.View
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        findViewById<Button>(R.id.btn2_next).setOnClickListener {
            startActivity(Intent(this@SecondActivity, ThirdActivity::class.java))
        }
    }
}