package fragments
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.navigation.R


class HomeFragment : Fragment(R.layout.fragment_home) {
    private var counter = 0
    private lateinit var counterTextView: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        counterTextView = view.findViewById(R.id.counterTextView)
        val incrementButton: Button = view.findViewById(R.id.incrementButton)

        incrementButton.setOnClickListener {
            counter++
            counterTextView.text = counter.toString()
        }

        savedInstanceState?.let {
            counter = it.getInt("counter", 0)
            counterTextView.text = counter.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("counter", counter)
    }
}
