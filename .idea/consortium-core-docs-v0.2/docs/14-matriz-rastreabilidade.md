# 14. Matriz de rastreabilidade

## 14.1 Estrutura

| ID | Requisito | Fonte | Tipo | Módulo | Implementação | Teste | Status |
|---|---|---|---|---|---|---|---|
| REG-GRP-001 | Grupo possui regulamento | Lei 11.795/2008 e Res. BCB 285/2023 | Obrigatória | group | RegulationVersion | CT-GRP-001 | A validar |
| REG-GRP-002 | Viabilidade antes da primeira AGO | Regulação de grupos | Obrigatória | group | ViabilityPolicy | CT-GRP-002 | A validar |
| REG-QTA-001 | Cota representa participação no grupo | Lei 11.795/2008 | Obrigatória | quota | Quota aggregate | CT-QTA-001 | A validar |
| REG-ASM-001 | Contemplação por sorteio/lance | Lei 11.795/2008 | Obrigatória | assembly | ContemplationPolicy | CT-ASM-001 | A validar |
| REG-FIN-001 | Recursos identificáveis por grupo/cota | Regulação de grupos | Obrigatória | ledger | LedgerJournal | CT-FIN-001 | A validar |
| REG-EXC-001 | Exclusão segue hipótese e contrato | Lei/regulação | Obrigatória | quota | ExclusionPolicy | CT-EXC-001 | A validar |
| REG-CLS-001 | Encerramento preserva pendências | Lei/regulação | Obrigatória | closure | ClosurePolicy | CT-CLS-001 | A validar |

## 14.2 Estados de validação

- `DRAFT`
- `PENDENTE_JURIDICO`
- `VALIDADO_JURIDICO`
- `IMPLEMENTADO`
- `TESTADO`
- `DEPRECATED`

## 14.3 Definition of Done de uma regra

Uma regra só está concluída quando:

1. possui fonte normativa;
2. possui interpretação registrada;
3. possui decisão sobre parametrização;
4. possui código;
5. possui teste positivo;
6. possui teste negativo;
7. registra evidência;
8. aparece no changelog regulatório;
9. foi revisada por pessoa diferente do autor;
10. tem vigência e estratégia de migração.
