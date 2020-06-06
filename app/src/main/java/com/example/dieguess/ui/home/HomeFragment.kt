package com.example.dieguess.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.support.v4.app.Fragment
import android.arch.lifecycle.ViewModelProviders
import android.widget.Button
import androidx.navigation.findNavController
import com.example.dieguess.R
import com.example.dieguess.ui.gallery.GalleryFragment

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val image: ImageView = root.findViewById(R.id.diceView)
        when ((1..6).random()) {

                1 -> image.setImageResource(R.drawable.dice_1)
                2 -> image.setImageResource(R.drawable.dice_2)
                3 -> image.setImageResource(R.drawable.dice_3)
                4 -> image.setImageResource(R.drawable.dice_4)
                5 -> image.setImageResource(R.drawable.dice_5)
                6 -> image.setImageResource(R.drawable.dice_6)
            }


        val button : Button = root.findViewById(R.id.button)
        button.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_nav_home_to_nav_gallery) }
        return root
    }

}
