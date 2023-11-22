package agility.tungphan.poc.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import agility.tungphan.poc.myapp.ui.theme.MyApplicationTheme
import agility.tungphan.poc.mylibrary.IntroActivity
import android.app.Activity
import android.content.Intent
import android.util.Log
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    val TAG = "~~~MainActivity"

    private val startForResult =
        registerForActivityResult(StartActivityForResult()) { result: ActivityResult ->
            Log.d(TAG, "registerForActivityResult: result.resultCode=${result.resultCode}")
            if (result.resultCode == Activity.RESULT_OK) {
                val intent = result.data
                val data = intent?.getStringExtra("responseData")
                Log.d(
                    TAG,
                    "registerForActivityResult: result.resultCode=${result.resultCode} ;;; data = $data"
                )
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Button(onClick = {
                            val intent = Intent(this@MainActivity, IntroActivity::class.java)
                            intent.putExtra("requestCode", "SomeUniqueID")
                            startForResult.launch(intent)
                        }) {
                            Text(text = "Next to Intro flow")
                        }
                    }
                }
            }
        }
    }
}