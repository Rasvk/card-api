import no.rvk.cardapi.model.Card;
import no.rvk.cardapi.model.Rank;
import no.rvk.cardapi.model.Suit;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;

public final class Deck {

    public static final int NO_JOKERS = 0;
    private static final int STANDARD_DECK_SIZE_52 =
            Suit.values().length * Rank.values().length;

    private static final List<Card> STANDARD_52 = createStandard52Deck();

    private final List<Card> cards;

    private Deck(List<Card> cards) {
        this.cards = List.copyOf(cards);
    }

    public static Deck standard() {
        return build(1, NO_JOKERS, false, card -> true, ThreadLocalRandom.current());
    }

    public static Deck standardShuffled() {
        return build(1, NO_JOKERS, true, card -> true, ThreadLocalRandom.current());
    }

    public static Deck withJokers(int jokerCount) {
        return build(1, jokerCount, false, card -> true, ThreadLocalRandom.current());
    }

    public static Deck multiple(int deckCount, int jokersPerDeck, boolean shuffle) {
        return build(deckCount, jokersPerDeck, shuffle, card -> true, ThreadLocalRandom.current());
    }

    public static Deck custom(int deckCount,
                              int jokersPerDeck,
                              boolean shuffle,
                              Predicate<Card> filter) {
        return build(deckCount, jokersPerDeck, shuffle, filter, ThreadLocalRandom.current());
    }

    private static Deck build(int deckCount,
                              int jokersPerDeck,
                              boolean shuffle,
                              Predicate<Card> filter,
                              Random random) {

        if (deckCount < 1 || jokersPerDeck < NO_JOKERS) {
            throw new IllegalArgumentException("Invalid deck or joker count");
        }

        List<Card> template = STANDARD_52.stream()
                .filter(filter)
                .toList();

        List<Card> allCards = new ArrayList<>(deckCount * (template.size() + jokersPerDeck));

        for (int i = 0; i < deckCount; i++) {
            allCards.addAll(template);
            for (int j = 0; j < jokersPerDeck; j++) {
                allCards.add(Card.jokerCard());
            }
        }

        if (shuffle) {
            Collections.shuffle(allCards, random);
        }

        return new Deck(allCards);
    }

    private static List<Card> createStandard52Deck() {
        List<Card> cards = new ArrayList<>(STANDARD_DECK_SIZE_52);
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(Card.normal(suit, rank));
            }
        }
        return List.copyOf(cards);
    }

    public List<Card> cards() { return cards; }
    public int size() { return cards.size(); }
}
