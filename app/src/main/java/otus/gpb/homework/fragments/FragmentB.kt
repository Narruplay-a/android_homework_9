package otus.gpb.homework.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback

class FragmentB : Fragment() {
    override fun onAttach(context: Context) {
        super.onAttach(context)

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (childFragmentManager.backStackEntryCount > 1) {
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
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        childFragmentManager.beginTransaction()
            .replace(R.id.container_fragment_ba, FragmentBA.newInstance())
            .addToBackStack("fragmentBA")
            .commit()
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentB()
    }
}