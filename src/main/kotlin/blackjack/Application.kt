package blackjack

import blackjack.domain.card.CardDeck
import blackjack.domain.player.Name
import blackjack.domain.player.Player
import blackjack.view.InputView
import blackjack.view.OutputView

fun main() {
    val playersName = InputView.getPlayersName()
    val players = playersName.map { Player(Name(it)) }
    val cardDeck = CardDeck()
    players.forEach {
        it.receiveCard(cardDeck.draw())
        it.receiveCard(cardDeck.draw())
    }
    OutputView.printCardState(players)
    players.forEach { player ->
        getMoreCard(player, cardDeck)
    }
    players.forEach { player ->
        OutputView.printResult(player)
    }
}

private fun getMoreCard(player: Player, cardDeck: CardDeck) {
    while (InputView.getNeedOneMoreCard(player)) {
        player.receiveCard(cardDeck.draw())
        OutputView.printCurrentCardState(player)
        if (player.isFinished()) break
    }
}
