package com.teamtreehouse.solitaire

import android.content.Context
import android.view.ViewManager
import android.widget.ImageView
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.imageResource
import org.jetbrains.anko.onClick


class DeckView(context: Context) : ImageView(context) {
    init {
        imageResource = cardBackDrawable
        onClick {
            GamePresenter.onDeckTap()
        }
    }

    fun update() {
        val cards = GameModel.deck.cardsInDeck
        imageResource = if (cards.size > 0) cardBackDrawable else emptyPileDrawable
    }
}

val DECKVIEW_FACTORY = { ctx: Context -> DeckView(ctx) }
fun ViewManager.deckView(init: DeckView.() -> Unit = {}) =
        ankoView(DECKVIEW_FACTORY, 0, init)