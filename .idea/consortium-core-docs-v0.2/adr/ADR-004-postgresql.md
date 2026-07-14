# ADR-004 — PostgreSQL como fonte transacional

- Status: Aceito
- Data: 2026-07-13

## Decisão

Usar PostgreSQL como fonte de verdade transacional do primeiro release.

## Motivo

Suporte a transações, constraints, precisão numérica, índices, particionamento, JSON quando necessário e ampla disponibilidade operacional.

## Consequências

- migrations com Flyway;
- evitar dependência de recursos exóticos sem abstração;
- consultas críticas podem usar SQL explícito;
- testes de integração usarão PostgreSQL real via Testcontainers.
