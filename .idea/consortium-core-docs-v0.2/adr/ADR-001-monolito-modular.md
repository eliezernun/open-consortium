# ADR-001 — Monólito modular

- Status: Aceito
- Data: 2026-07-13

## Contexto

O domínio exige consistência forte entre grupo, cota, assembleia e posição financeira. Microserviços prematuros aumentariam falhas distribuídas e complexidade regulatória.

## Decisão

Adotar monólito modular com limites internos verificáveis.

## Consequências

- transações locais mais simples;
- implantação inicial simples;
- menor custo operacional;
- módulos podem ser extraídos após métricas reais;
- disciplina arquitetural deve ser garantida por testes.
