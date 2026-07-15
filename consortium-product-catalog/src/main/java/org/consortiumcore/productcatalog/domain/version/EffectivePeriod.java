package org.consortiumcore.productcatalog.domain.version;

import java.time.LocalDate;
import java.util.Objects;

public record EffectivePeriod(
        LocalDate from,
        LocalDate until
) {

    public EffectivePeriod {
        Objects.requireNonNull(from);

        if (until != null && until.isBefore(from)) {
            throw new InvalidEffectivePeriodException(from, until);
        }
    }

    public boolean includes(LocalDate date) {
        Objects.requireNonNull(date);

        boolean afterStart =
                date.isEqual(from) || date.isAfter(from);

        boolean beforeEnd =
                until == null ||
                        date.isEqual(until) ||
                        date.isBefore(until);

        return afterStart && beforeEnd;
    }

    public boolean overlaps(EffectivePeriod other) {
        LocalDate thisEnd =
                until == null ? LocalDate.MAX : until;

        LocalDate otherEnd =
                other.until == null ? LocalDate.MAX : other.until;

        return !thisEnd.isBefore(other.from)
                && !otherEnd.isBefore(from);
    }
}