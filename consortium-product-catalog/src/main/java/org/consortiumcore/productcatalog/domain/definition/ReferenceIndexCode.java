package org.consortiumcore.productcatalog.domain.definition;
/*
    O catálogo não deve armazenar o valor do índice. Apenas a referência e a regra de aplicação.
    Os valores históricos virão de integração externa.
 */
public record ReferenceIndexCode(String value) {

    public static final ReferenceIndexCode IPCA =
            new ReferenceIndexCode("IPCA");

    public static final ReferenceIndexCode INCC =
            new ReferenceIndexCode("INCC");
}