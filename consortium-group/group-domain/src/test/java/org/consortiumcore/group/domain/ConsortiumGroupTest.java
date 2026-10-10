package org.consortiumcore.group.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;
import java.util.UUID;
import org.consortiumcore.productcatalog.api.ProductConfigurationSnapshot;
import org.consortiumcore.productcatalog.api.PublishedProductVersion;
import org.junit.jupiter.api.Test;

class ConsortiumGroupTest {

    @Test
    void createsDraftGroupFromPublishedProductVersion() {
        PublishedProductVersion productVersion = publishedProductVersion();

        ConsortiumGroup group = ConsortiumGroup.create(
                GroupId.generate(),
                new GroupCode("GRP_001"),
                productVersion
        );

        assertEquals(GroupStatus.DRAFT, group.status());
        assertEquals(GroupConfigurationVersion.initial(), group.configurationVersion());
        assertEquals(productVersion.productId(), group.configuration().productId());
        assertEquals(productVersion.productVersionId(), group.configuration().productVersionId());
        assertEquals(new GroupCapacity(10, 120), group.configuration().capacity());
        assertEquals(new GroupDuration(12, 80), group.configuration().duration());
        assertEquals("MOVABLE_GOODS", group.configuration().productType());
    }

    @Test
    void rejectsInvalidGroupCode() {
        assertThrows(GroupDomainException.class, () -> new GroupCode("ab"));
    }

    private static PublishedProductVersion publishedProductVersion() {
        Currency brl = Currency.getInstance("BRL");
        return new PublishedProductVersion(
                UUID.randomUUID(),
                UUID.randomUUID(),
                "CAR_GROUP",
                "MOVABLE_GOODS",
                1,
                LocalDate.parse("2026-09-01"),
                null,
                new ProductConfigurationSnapshot(
                        new ProductConfigurationSnapshot.GroupConfiguration(10, 120, true),
                        new ProductConfigurationSnapshot.CreditConfiguration(
                                new BigDecimal("10000"),
                                new BigDecimal("80000"),
                                brl,
                                true
                        ),
                        new ProductConfigurationSnapshot.DurationConfiguration(12, 80),
                        new ProductConfigurationSnapshot.PercentageRangeConfiguration(
                                new BigDecimal("0.10"),
                                new BigDecimal("0.20")
                        ),
                        new ProductConfigurationSnapshot.ReserveFundConfiguration(
                                true,
                                new BigDecimal("0.01"),
                                new BigDecimal("0.05")
                        ),
                        new ProductConfigurationSnapshot.AdjustmentConfiguration("PRICE_INDEX", "IPCA"),
                        new ProductConfigurationSnapshot.AssemblyConfiguration(true)
                ),
                "hash"
        );
    }
}
