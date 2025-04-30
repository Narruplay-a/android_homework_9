package otus.gpb.homework.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout

class FragmentBB : Fragment() {
    private val isPortrait: Boolean get() = resources.getBoolean(R.bool.isPortrait)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setBackgroundColor(ColorGenerator.generateColor())

        view.findViewById<Button>(R.id.button).setOnClickListener {
            parentFragmentManager.setFragmentResult(colorKey, Bundle().apply {
                putInt(colorKey, ColorGenerator.generateColor())
            })

            if (isPortrait) {
                parentFragmentManager.popBackStack()
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentBB()
        val colorKey = "COLOR_KEY"
    }
}