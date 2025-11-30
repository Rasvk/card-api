package no.rvk.cardapi.model;

public record Card(Suit suit, Rank rank, boolean joker) {

    public static Card normal(Suit suit, Rank rank) {
        return new Card(suit, rank, false);
    }

    public static Card jokerCard() {
        return new Card(null, null, true);
    }

    public boolean isJoker() {
        return joker;
    }

    public CardColor color() {
        return joker ? CardColor.NONE : CardColor.of(suit);
    }

    public boolean isRed() {
        return color() == CardColor.RED;
    }

    public boolean isBlack() {
        return color() == CardColor.BLACK;
    }

    public boolean isFaceCard() {
        return !joker && rank.isFace();
    }

    public boolean isNumberCard() {
        return !joker && rank.isNumber();
    }


    @Override
    public String toString() {
        return joker ? "JOKER" : (rank + " of " + suit);
    }


}
