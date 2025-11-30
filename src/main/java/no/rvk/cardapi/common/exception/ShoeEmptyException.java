package no.rvk.cardapi.common.exception;

/**
 * Thrown when attempting to draw a card from an empty shoe.
 */
public final class ShoeEmptyException extends DomainException {

    private final long shoeId;

    public ShoeEmptyException(long shoeId) {
        super(ErrorCode.SHOE_EMPTY, "Shoe with id %d is empty".formatted(shoeId));
        this.shoeId = shoeId;
    }

    public long getShoeId() {
        return shoeId;
    }
}
