package ar.scacchipa.animation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ar.scacchipa.animation.databinding.FragmentMenuBinding

class FragmentMenu: Fragment() {

    private var binding: FragmentMenuBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater, container, false)

        binding?.bitmapButton?.setOnClickListener {
            findNavController().navigate(R.id.action_graph_fragment_menu_to_graph_fragment_anim_drawable)
        }

        binding?.fadeOnButton?.setOnClickListener {
            binding?.root?.apply {
                alpha = 0f
                visibility = View.VISIBLE
                animate()
                    .alpha(1f)
                    .setDuration(2000)
                    .setListener( null )
            }
        }

        binding?.horizontalButton?.setOnClickListener {
            binding?.horizontalButton?.apply {
                animate()
                    .translationXBy(200f)
                    .setDuration(2000)
                    .withEndAction {
                        animate()
                            .translationXBy(-200f)
                            .duration = 2000
                    }
            }
        }

        binding?.transitionButton?.setOnClickListener {
            findNavController().navigate(R.id.action_graph_fragment_menu_to_graph_fragment_anim_drawable_with_transition)
        }

        binding?.pollButton?.setOnClickListener {
            findNavController().navigate(R.id.action_graph_fragment_menu_to_graph_fragment_poll)
        }

        binding?.endButton?.setOnClickListener {
            findNavController().navigate(R.id.action_graph_fragment_menu_to_graph_fragment_end)
        }

        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}