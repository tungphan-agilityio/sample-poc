package agility.tungphan.poc.mylibrary.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import agililty.tungphan.poc.mylibrary.R
import agility.tungphan.poc.mylibrary.AuthenticationManager
import agility.tungphan.poc.mylibrary.models.RegistrationData
import android.widget.Button

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        findViewById<Button>(R.id.btn_finish).setOnClickListener {
            AuthenticationManager.getInstance().onOnboardingCompleted?.invoke(RegistrationData())
        }
    }
}