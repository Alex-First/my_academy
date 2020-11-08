package academy.alexfirst.app

import android.app.IntentService
import android.content.Intent
import android.util.Log

// Константа-ключ может быть любой, но принято так ...
const val LOK_BRODCAST = "academy.alexfirst.app.action.TEXT"

class MyIntentService : IntentService("MyIntentService") {

    override fun onHandleIntent(intent: Intent?) {
        Log.i("Ok", "->MyIntentService->onHandleIntent")
        locBrodcast()
    }

    private fun locBrodcast() {

        Log.i("Ok", "->MyIntentService->locBroadcast")

        val intent = Intent(LOK_BRODCAST)
        intent.putExtra("key", "Тут выгружаем из MyIntentService")
        sendBroadcast(intent)

    }
}