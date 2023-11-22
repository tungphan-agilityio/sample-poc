package agility.tungphan.poc.mylibrary

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class IntroActivity : ComponentActivity() {
    val TAG = "~~~IntroActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { AppNavigation() { data ->
            Log.d(TAG, "onCreate: $data")
            intent.putExtra("responseData", data)
            setResult(RESULT_OK, intent)
            finish()
        } }
    }
}