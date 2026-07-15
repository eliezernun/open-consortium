package org.consortiumcore.productcatalog.domain.type;
/*
    A ordem real deve ser validada regulatoriamente.
    O enum apenas suporta o modelo.
 */
public enum AssemblyProcessingOrder {
    DRAW_THEN_BIDS,
    BIDS_THEN_DRAW,
    CONTRACTUAL_ORDER
}