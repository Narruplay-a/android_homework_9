package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.setFragmentResultListener

class FragmentBA : Fragment() {
    private val isPortrait: Boolean get() = resources.getBoolean(R.bool.isPortrait)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener(FragmentBB.colorKey) { key, bundle ->
            val color = bundle.getInt(FragmentBB.colorKey)

            view.setBackgroundColor(color)
        }

        view.setBackgroundColor(ColorGenerator.generateColor())

        view.findViewById<Button>(R.id.button).setOnClickListener {
            if (isPortrait) {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.container_fragment_ba, FragmentBB.newInstance())
                    .addToBackStack("fragmentBB")
                    .commit()
            } else {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.container_fragment_bb, FragmentBB.newInstance())
                    .addToBackStack("fragmentBB")
                    .commit()
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentBA()
    }
}