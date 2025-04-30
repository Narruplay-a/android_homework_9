package otus.gpb.homework.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

private const val FRAG_AA_COLOR = "frag_aa_color"

class FragmentAA : Fragment() {
    private val fragAAColor: Int by lazy { arguments?.getInt(FRAG_AA_COLOR, 0) ?: 0 }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.setBackgroundColor(fragAAColor)

        view.findViewById<Button>(R.id.button).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .add(R.id.fragment_view_container_ab, FragmentAB.newInstance(ColorGenerator.generateColor()))
                .addToBackStack("fragment AB")
                .commit()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(color: Int) =
            FragmentAA().apply {
                arguments = Bundle().apply {
                    putInt(FRAG_AA_COLOR, color)
                }
            }
    }
}