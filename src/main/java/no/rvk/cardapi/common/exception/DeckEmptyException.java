package no.rvk.cardapi.common.exception;

public final class DeckEmptyException extends DomainException {

    public DeckEmptyException() {
        super(ErrorCode.DECK_EMPTY, "Deck has no cards remaining");
    }
}
