package org.consortiumcore.productcatalog.domain.definition;

/*
    The catalog stores only the index reference and application rule.
    Historical values are supplied by external integration.
 */
public record ReferenceIndexCode(String value) {

    public static final ReferenceIndexCode IPCA =
            new ReferenceIndexCode("IPCA");

    public static final ReferenceIndexCode INCC =
            new ReferenceIndexCode("INCC");
}
