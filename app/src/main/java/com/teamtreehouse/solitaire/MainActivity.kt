package com.teamtreehouse.solitaire

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val cardWidth = (displayMetrics.widthPixels - dip(8)) / 7
        val cardHeight = cardWidth * 190 / 140

        verticalLayout {
            linearLayout {

            }
            linearLayout {

            }
        }
    }
}
