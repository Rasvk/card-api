package no.rvk.cardapi.common.exception;

/**
 * Thrown when a shoe with the given id does not exist in the domain/persistence.
 */
public final class ShoeNotFoundException extends DomainException {

    private final long shoeId;

    public ShoeNotFoundException(long shoeId) {
        super(ErrorCode.SHOE_NOT_FOUND, "Shoe with id %d was not found".formatted(shoeId));
        this.shoeId = shoeId;
    }

    public long getShoeId() {
        return shoeId;
    }
}
