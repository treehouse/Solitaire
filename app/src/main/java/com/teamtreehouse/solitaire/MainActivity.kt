package com.teamtreehouse.solitaire

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.button
import org.jetbrains.anko.onClick
import org.jetbrains.anko.relativeLayout
import org.jetbrains.anko.textView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var counter = 0
        relativeLayout {
            val counterTextView = textView {
                text = "0"
                textSize = 24f
            }
            button {
                onClick {
                    counter++
                    counterTextView.text = counter.toString()
                }
            }
        }
    }
}
