package academy.alexfirst.app

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class ActivitySecond : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val intentService = Intent(this, MyIntentService::class.java)
        startService(intentService)

    }
    override fun onStart() {
        super.onStart()
          registerReceiver(receiver, IntentFilter(LOK_BRODCAST));
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }

    private val receiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            Log.i("Ok", "->Broadcast->ActivytySecond")
            val intent = Intent(context, MainActivity::class.java)
            //intent.putExtra("key", intent?.getStringExtra("text"))
            startActivity(intent)
        }}


}