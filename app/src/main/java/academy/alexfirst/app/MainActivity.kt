package academy.alexfirst.app

import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moveToMovieDetailsActivity()
    }

    fun moveToMovieDetailsActivity(){
        val intent = Intent(this, MovieDetailsActivity::class.java)
        startActivity(intent)
    }


}