package com.example.dieguess.ui.slideshow

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class SlideshowViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "1. First, Select a Number between 1 - 6\n\n"+
                "2.Press \"Check my Guess button\"\n\n"+
                "3.Computer also guess a number\n\n"+
                "4.Computer Guess appears as a Die Image\n\n"+
                "5.If your guess and computer guess is same, you will be awarded a point\n\n"+
                "6.Error 404: A Rule is Missing. You need to find the missing rule.\n\nHint:Play Game, Have fun."

    }
    val text: LiveData<String> = _text
}
