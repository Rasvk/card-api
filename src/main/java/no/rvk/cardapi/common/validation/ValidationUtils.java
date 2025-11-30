package no.rvk.cardapi.common.validation;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/**
 * Lightweight validation helpers for arguments and internal state.
 *
 * Pure Java, so it can be used from domain, services, mappers, etc.
 * Throws IllegalArgumentException for bad arguments and IllegalStateException for bad state.
 */
public final class ValidationUtils {

    private ValidationUtils() {
        throw new AssertionError("No instances of " + ValidationUtils.class.getName());
    }

    /* =========================================================
       Generic predicates
       ========================================================= */

    /**
     * Validates a condition on method arguments.
     *
     * @throws IllegalArgumentException if condition is false
     */
    public static void requireArgument(boolean condition, String message) {
        if (!condition) {
            throw new IllegalArgumentException(
                    Objects.requireNonNullElse(message, "Invalid argument")
            );
        }
    }

    /**
     * Validates a condition on internal state.
     *
     * @throws IllegalStateException if condition is false
     */
    public static void requireState(boolean condition, String message) {
        if (!condition) {
            throw new IllegalStateException(
                    Objects.requireNonNullElse(message, "Invalid state")
            );
        }
    }

    /* =========================================================
       Null / String
       ========================================================= */

    public static <T> T requireNonNull(T value, String name) {
        if (value == null) {
            throw new IllegalArgumentException(param(name) + " must not be null");
        }
        return value;
    }

    public static String requireNonBlank(String value, String name) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(param(name) + " must not be null or blank");
        }
        return value;
    }

    /* =========================================================
       Collections / Maps
       ========================================================= */

    public static <C extends Collection<?>> C requireNonEmpty(C value, String name) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(param(name) + " must not be null or empty");
        }
        return value;
    }

    public static <M extends Map<?, ?>> M requireNonEmpty(M value, String name) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(param(name) + " must not be null or empty");
        }
        return value;
    }

    /* =========================================================
       Numeric
       ========================================================= */

    public static int requireAtLeast(String name, int value, int minInclusive) {
        if (value < minInclusive) {
            throw new IllegalArgumentException(
                    param(name) + " must be >= " + minInclusive + " but was " + value
            );
        }
        return value;
    }

    public static long requireAtLeast(String name, long value, long minInclusive) {
        if (value < minInclusive) {
            throw new IllegalArgumentException(
                    param(name) + " must be >= " + minInclusive + " but was " + value
            );
        }
        return value;
    }

    public static int requireAtMost(String name, int value, int maxInclusive) {
        if (value > maxInclusive) {
            throw new IllegalArgumentException(
                    param(name) + " must be <= " + maxInclusive + " but was " + value
            );
        }
        return value;
    }

    public static long requireAtMost(String name, long value, long maxInclusive) {
        if (value > maxInclusive) {
            throw new IllegalArgumentException(
                    param(name) + " must be <= " + maxInclusive + " but was " + value
            );
        }
        return value;
    }

    public static int requireNonNegative(String name, int value) {
        if (value < 0) {
            throw new IllegalArgumentException(
                    param(name) + " must be >= 0 but was " + value
            );
        }
        return value;
    }

    public static long requireNonNegative(String name, long value) {
        if (value < 0L) {
            throw new IllegalArgumentException(
                    param(name) + " must be >= 0 but was " + value
            );
        }
        return value;
    }

    public static int requirePositive(String name, int value) {
        if (value <= 0) {
            throw new IllegalArgumentException(
                    param(name) + " must be > 0 but was " + value
            );
        }
        return value;
    }

    public static long requirePositive(String name, long value) {
        if (value <= 0L) {
            throw new IllegalArgumentException(
                    param(name) + " must be > 0 but was " + value
            );
        }
        return value;
    }

    public static int requireInRange(String name, int value, int minInclusive, int maxInclusive) {
        if (value < minInclusive || value > maxInclusive) {
            throw new IllegalArgumentException(
                    param(name) + " must be between " + minInclusive + " and " + maxInclusive
                            + " (inclusive) but was " + value
            );
        }
        return value;
    }

    public static long requireInRange(String name, long value, long minInclusive, long maxInclusive) {
        if (value < minInclusive || value > maxInclusive) {
            throw new IllegalArgumentException(
                    param(name) + " must be between " + minInclusive + " and " + maxInclusive
                            + " (inclusive) but was " + value
            );
        }
        return value;
    }

    /* =========================================================
       Internal
       ========================================================= */

    private static String param(String name) {
        return (name == null || name.isBlank()) ? "parameter" : name;
    }
}
