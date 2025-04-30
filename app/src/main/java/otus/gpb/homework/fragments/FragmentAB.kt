package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

private const val FRAG_AB_COLOR = "frag_ab_color"

class FragmentAB : Fragment() {
    private val fragABColor: Int by lazy { arguments?.getInt(FRAG_AB_COLOR, 0) ?: 0 }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.setBackgroundColor(fragABColor)
    }

    companion object {
        @JvmStatic
        fun newInstance(color: Int) =
            FragmentAB().apply {
                arguments = Bundle().apply {
                    putInt(FRAG_AB_COLOR, color)
                }
            }
    }
}