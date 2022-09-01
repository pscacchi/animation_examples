package ar.scacchipa.animation

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ar.scacchipa.animation.databinding.FragmentAnimDrawableBinding

class FragmentAnimDrawable: Fragment() {

    var binding: FragmentAnimDrawableBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnimDrawableBinding.inflate(layoutInflater, container, false)

        binding?.stopAnimDrawableButton?.setOnClickListener {
            (binding?.imageDrawableView?.background
                    as? AnimationDrawable)?.stop()
        }

        binding?.startAnimDrawableButton?.setOnClickListener {
            (binding?.imageDrawableView?.background
                    as? AnimationDrawable)?.start()
        }
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}