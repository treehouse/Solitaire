package com.teamtreehouse.solitaire

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import org.jetbrains.anko.*

val cardBackDrawable = R.drawable.cardback_green5
val emptyPileDrawable = R.drawable.cardback_blue1
fun View.getResIdForCard(card: Card): Int {
    val resourceName = "card${card.suit}${cardsMap[card.value]}".toLowerCase()
    return context.resources.getIdentifier(resourceName, "drawable", context.packageName)
}

class MainActivity : AppCompatActivity(), GameView {
    var deckView: DeckView? = null
    var wastePileView: WastePileView? = null
    val foundationPileViews: Array<FoundationPileView?> = arrayOfNulls(4)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        GamePresenter.setGameView(this)
        GameModel.resetGame()

        val cardWidth = (displayMetrics.widthPixels - dip(8)) / 7
        val cardHeight = cardWidth * 190 / 140

        verticalLayout {
            leftPadding = dip(4)
            rightPadding = dip(4)
            topPadding = dip(8)

            linearLayout {
                deckView = deckView().lparams(cardWidth, cardHeight)
                wastePileView = wastePileView().lparams(cardWidth, cardHeight)
                view().lparams(cardWidth, 0)
                for (i in 0..3) {
                    foundationPileViews[i] = foundationPileView(i).lparams(cardWidth, cardHeight)
                }
            }
            linearLayout {

            }
        }
    }

    override fun update(gameModel: GameModel) {
        deckView!!.update()
        wastePileView!!.update()
        foundationPileViews.forEach {
            it!!.update()
        }
    }
}
