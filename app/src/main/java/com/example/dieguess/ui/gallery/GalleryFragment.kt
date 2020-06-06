package com.example.dieguess.ui.gallery

import android.app.Activity
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.example.dieguess.R


class GalleryFragment : Fragment() {

    private lateinit var galleryViewModel: GalleryViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
        var score : Int = 0
        val submitGuessBtn = root.findViewById<Button>(R.id.guessSubmit)
        val myImage = root.findViewById<ImageView>(R.id.animateImage)
        val userGuessNum = root.findViewById<EditText>(R.id.guessNumber)
                submitGuessBtn.setOnClickListener {
            val value: Int=displayAnim(myImage,it)
            score= this.context?.let { it1 -> showResult(score,value,userGuessNum, it1) }!!
        }
        return root
    }
    private fun displayAnim(myImage: ImageView, view: View) :Int
    {
        val imm = this.context?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
        val random = (1..6).random()
            when(random)
            {
                1 -> myImage.setImageResource(R.drawable.dice_1)
                2 -> myImage.setImageResource(R.drawable.dice_2)
                3 -> myImage.setImageResource(R.drawable.dice_3)
                4 -> myImage.setImageResource(R.drawable.dice_4)
                5 -> myImage.setImageResource(R.drawable.dice_5)
                6 -> myImage.setImageResource(R.drawable.dice_6)
                else -> myImage.setImageResource(R.drawable.empty_dice)
            }
        return random
    }
    private fun showResult(score: Int, value: Int, userGuessNum: EditText, context: Context) :Int{
        val builder = AlertDialog.Builder(context)
        val userGuessable : Int = userGuessNum.text.toString().toInt()
        builder.setTitle(R.string.result)
        var my_score : Int = score
        if ( userGuessable<= 6 )
        {
            if (value == userGuessable){
                my_score += 1
                builder.setMessage(R.string.answerCorrect)

            }
            else
                builder.setMessage(R.string.answerWrong)
            builder.setMessage("Your Score is $my_score")
        }
        else
        {
            builder.setMessage("You can't cheat me\nCheating penalty: Restart the game\nYour score is set to zero again")
            my_score = 0
        }
        builder.setIcon(R.drawable.dice_6)

        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(true)
        alertDialog.show()

        return my_score
    }
}
