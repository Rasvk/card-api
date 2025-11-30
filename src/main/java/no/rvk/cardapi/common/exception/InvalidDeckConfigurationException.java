package no.rvk.cardapi.common.exception;

public final class InvalidDeckConfigurationException extends DomainException {

    private final Integer deckCount;
    private final Integer jokersPerDeck;

    public InvalidDeckConfigurationException(String message) {
        this(message, null, null);
    }

    public InvalidDeckConfigurationException(String message, Integer deckCount, Integer jokersPerDeck) {
        super(ErrorCode.INVALID_DECK_CONFIG, message);
        this.deckCount = deckCount;
        this.jokersPerDeck = jokersPerDeck;
    }

    public Integer getDeckCount() {
        return deckCount;
    }

    public Integer getJokersPerDeck() {
        return jokersPerDeck;
    }
}
