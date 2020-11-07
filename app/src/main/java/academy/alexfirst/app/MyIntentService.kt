package academy.alexfirst.app

import android.app.IntentService
import android.content.Intent
import android.util.Log


class MyIntentService : IntentService("MyIntentService") {

    override fun onHandleIntent(intent: Intent?) {
        sendMes()
        locBrodcast()
    }

    private fun sendMes() {
        Log.i("Ok", "->MyIntentService")
    }

    private fun locBrodcast() {

        Log.i("Ok", "->MyIntentService->Broadcast")

        val intent = Intent("locBrodcast")
        intent.putExtra("key", "Тут выгружаем из MyIntentService")
        sendBroadcast(intent)
    }
}