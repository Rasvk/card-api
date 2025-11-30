package no.rvk.cardapi.model;

public enum Rank {
    ONE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING,
    ACE;

    public boolean isFace() {
        return this == JACK || this == QUEEN || this == KING;
    }

    public boolean isNumber() {
        return switch (this) {
            case TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN -> true;
            default -> false;
        };
    }
}
