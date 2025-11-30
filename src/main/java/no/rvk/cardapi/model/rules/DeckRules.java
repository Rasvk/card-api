package no.rvk.cardapi.model.rules;

import no.rvk.cardapi.model.Card;
import no.rvk.cardapi.common.exception.InvalidDeckConfigurationException;

import java.util.List;
import java.util.function.Predicate;

import static no.rvk.cardapi.common.validation.ValidationUtils.*;

public final class DeckRules {

    public static final int MIN_DECKS = 1;
    public static final int MIN_JOKERS_PER_DECK = 0;
    public static final int MAX_JOKERS_PER_DECK = 8; // tweak later if needed

    private DeckRules() {
        throw new AssertionError("No instances of DeckRules allowed");
    }

    public static void validateDeckParameters(int deckCount, int jokersPerDeck) {
        try {
            requireAtLeast("deckCount", deckCount, MIN_DECKS);
            requireAtLeast("jokersPerDeck", jokersPerDeck, MIN_JOKERS_PER_DECK);
            requireAtMost("jokersPerDeck", jokersPerDeck, MAX_JOKERS_PER_DECK);
        } catch (IllegalArgumentException e) {
            throw new InvalidDeckConfigurationException(e.getMessage(), deckCount, jokersPerDeck);
        }
    }

    public static List<Card> applyFilter(List<Card> base, Predicate<Card> filter) {
        try {
            requireNonNull(base, "base");
            requireNonNull(filter, "filter");
        } catch (IllegalArgumentException e) {
            throw new InvalidDeckConfigurationException(e.getMessage(), null, null);
        }

        return base.stream()
                .filter(filter)
                .toList();
    }

    public static void validateTemplate(List<Card> template,
                                        int deckCount,
                                        int jokersPerDeck) {
        try {
            requireNonEmpty(template, "template");
        } catch (IllegalArgumentException e) {
            throw new InvalidDeckConfigurationException(e.getMessage(), deckCount, jokersPerDeck);
        }
    }

    public static int calculateTotalCards(int deckCount,
                                          int templateSize,
                                          int jokersPerDeck) {
        return (templateSize + jokersPerDeck) * deckCount;
    }
}
