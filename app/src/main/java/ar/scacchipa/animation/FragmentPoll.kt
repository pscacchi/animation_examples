package ar.scacchipa.animation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ar.scacchipa.animation.databinding.FragmentPollBinding

class FragmentPoll: Fragment() {

    private var binding: FragmentPollBinding? = null

    private val viewModelPoll: ViewModelPoll by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPollBinding.inflate(inflater, container, false)

        binding?.agreeButton?.setOnClickListener {
            viewModelPoll.onClickAgreeButton()
        }

        binding?.disagreeButton?.setOnClickListener {
            viewModelPoll.onClickDisagreeButton()
        }
        viewModelPoll.agreePoint.observe(viewLifecycleOwner) {
            binding?.agreeCounterView?.text = viewModelPoll.agreePoint.value?.toString()
            binding?.disagreeCounterView?.text = "0"
        }

        viewModelPoll.disagreeButtonPosition.observe(viewLifecycleOwner) { position ->
            if (position) {
                binding?.disagreeButton
                    ?.animate()
                    ?.translationYBy(-300f)
                    ?.duration = 100
            } else {
                binding?.disagreeButton
                    ?.animate()
                    ?.translationYBy(300f)
                    ?.duration = 100
            }
        }
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}

