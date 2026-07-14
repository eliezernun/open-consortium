# ADR-002 — Ledger imutável

- Status: Aceito
- Data: 2026-07-13

## Decisão

Toda alteração financeira relevante gera diário e lançamentos imutáveis. Correção usa reversão.

## Motivo

Saldos mutáveis não explicam histórico, dificultam auditoria e permitem perda de evidência.

## Consequências

- maior volume de dados;
- reconstrução histórica confiável;
- necessidade de checkpoints para desempenho;
- validação obrigatória de equilíbrio.
