package academy.alexfirst.app

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class ActivitySecond : AppCompatActivity() {
    private lateinit var receiver: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val intentService: Intent = Intent(this, MyIntentService::class.java)
        startService(intentService)


    }

    override fun onStart() {
        super.onStart()
         receiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                when (intent?.action) {
                    "locBrodcast" -> handleSomethingHappened()
                }
            }
        }
    }

    private fun handleSomethingHappened() {
        Log.i("Ok", "->Broadcast->ActivytySecond")
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }

}