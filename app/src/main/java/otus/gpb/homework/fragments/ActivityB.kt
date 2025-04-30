package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityB : AppCompatActivity() {
    private val isPortrait: Boolean get() = resources.getBoolean(R.bool.isPortrait)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container_fragment_b, FragmentB.newInstance())
            .commit()
    }
}