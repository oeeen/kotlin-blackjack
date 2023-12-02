package blackjack.domain.state

import blackjack.domain.card.Cards
import blackjack.domain.card.Hands

class Bust(override val rate: Double = 0.0, override val hands: Hands) : Finished() {
    override fun getCards(): Cards {
        return Cards(hands.cards)
    }
}
