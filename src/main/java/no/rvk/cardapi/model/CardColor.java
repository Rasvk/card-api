package no.rvk.cardapi.model;

public enum CardColor {
    RED, BLACK, NONE;

    public static CardColor of(Suit suit) {
        return switch (suit) {
            case HEARTS, DIAMONDS -> RED;
            case CLUBS, SPADES -> BLACK;
        };
    }
}

