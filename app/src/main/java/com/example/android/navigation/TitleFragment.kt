package com.example.android.navigation

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding: FragmentTitleBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)

        binding.playButton.setOnClickListener {

            it.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment())
            //Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_gameFragment)
            //it.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)

            //Navigation.findNavController(it).navigate(R.id.action_titleFragment_to_gameFragment2)
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        view?.let {
            return NavigationUI.onNavDestinationSelected(item, it.findNavController()) || super.onOptionsItemSelected(item)
        }
        return super.onOptionsItemSelected(item)

    }


}