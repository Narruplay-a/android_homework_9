package otus.gpb.homework.fragments

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback

class FragmentA : Fragment() {
    override fun onAttach(context: Context) {
        super.onAttach(context)

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (childFragmentManager.backStackEntryCount > 0) {
                    childFragmentManager.popBackStack()
                } else {
                    isEnabled = false
                    @Suppress("DEPRECATION")
                    requireActivity().onBackPressed()
                }
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(callback)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.setBackgroundColor(Color.WHITE)

        view.findViewById<Button>(R.id.button).setOnClickListener {
            childFragmentManager.beginTransaction()
                .replace(R.id.fragment_view_container_a, FragmentAA.newInstance(ColorGenerator.generateColor()))
                .addToBackStack("fragment_aa")
                .commit()
        }
    }
    companion object {
        @JvmStatic
        fun newInstance() = FragmentA()
    }
}