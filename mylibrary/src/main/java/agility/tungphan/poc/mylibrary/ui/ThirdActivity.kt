package agility.tungphan.poc.mylibrary.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import agililty.tungphan.poc.mylibrary.R
import agility.tungphan.poc.mylibrary.AuthenticationManager
import agility.tungphan.poc.mylibrary.models.RegistrationData
import android.content.Intent
import android.widget.Button

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        findViewById<Button>(R.id.btn_finish).setOnClickListener {
           handleComplete()
        }
    }

    private fun handleComplete() {
        AuthenticationManager.getInstance().also {
            val startActivity = AuthenticationManager.getInstance().startActivity
            startActivity?.let { activity ->
                val intent = Intent(activity, activity.javaClass).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                }
                activity.startActivity(intent)
            }
            it.onOnboardingCompleted?.invoke(RegistrationData())
            it.cleanUp()
        }
    }
}