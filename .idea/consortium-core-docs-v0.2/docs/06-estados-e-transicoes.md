# 6. Estados e transições

## 6.1 Grupo

```mermaid
stateDiagram-v2
    [*] --> DRAFT
    DRAFT --> FORMING: publicar configuração
    FORMING --> READY_FOR_FIRST_ASSEMBLY: viabilidade aprovada
    READY_FOR_FIRST_ASSEMBLY --> ACTIVE: primeira AGO homologada
    FORMING --> FORMATION_FAILED: prazo/condição não atendida
    ACTIVE --> SUSPENDED: decisão válida
    SUSPENDED --> ACTIVE: regularização
    ACTIVE --> CLOSING: prazo/última contemplação
    CLOSING --> OPERATIONALLY_CLOSED
    OPERATIONALLY_CLOSED --> ACCOUNTING_CLOSED
    ACCOUNTING_CLOSED --> [*]
```

### Comandos

- `CreateGroup`
- `PublishGroupConfiguration`
- `AssessGroupViability`
- `AuthorizeFirstAssembly`
- `ActivateGroup`
- `SuspendGroup`
- `ResumeGroup`
- `BeginGroupClosure`
- `CloseGroupOperationally`
- `CloseGroupAccounting`

## 6.2 Cota

```mermaid
stateDiagram-v2
    [*] --> AVAILABLE
    AVAILABLE --> RESERVED
    RESERVED --> ACTIVE_NOT_CONTEMPLATED
    RESERVED --> AVAILABLE: reserva expirada
    ACTIVE_NOT_CONTEMPLATED --> CONTEMPLATED
    ACTIVE_NOT_CONTEMPLATED --> EXCLUDED
    EXCLUDED --> ACTIVE_NOT_CONTEMPLATED: readmissão
    ACTIVE_NOT_CONTEMPLATED --> TRANSFER_PENDING
    CONTEMPLATED --> TRANSFER_PENDING
    TRANSFER_PENDING --> ACTIVE_NOT_CONTEMPLATED
    TRANSFER_PENDING --> CONTEMPLATED
    CONTEMPLATED --> SETTLED
    ACTIVE_NOT_CONTEMPLATED --> SETTLED
    SETTLED --> CLOSED
    EXCLUDED --> CLOSED
```

## 6.3 Assembleia

```mermaid
stateDiagram-v2
    [*] --> SCHEDULED
    SCHEDULED --> PREPARING
    PREPARING --> SNAPSHOT_FROZEN
    SNAPSHOT_FROZEN --> PROCESSING
    PROCESSING --> PROCESSED
    PROCESSED --> HOMOLOGATED
    PREPARING --> CANCELLED
    PROCESSED --> REJECTED
    HOMOLOGATED --> ANNULLED: procedimento excepcional
```

## 6.4 Contemplação

```text
REGISTERED
CONDITIONALLY_VALID
CONFIRMED
CANCELLED
CREDIT_AVAILABLE
CREDIT_USED
CLOSED
```

A liberação financeira externa não altera a existência histórica da contemplação.

## 6.5 Regras gerais de transição

Toda transição deve registrar:

- estado anterior;
- estado posterior;
- comando;
- ator ou sistema;
- regra aplicada;
- versão;
- data efetiva;
- instante;
- correlação;
- justificativa;
- evidências;
- eventos produzidos.

## 6.6 Concorrência

Agregados usam versão otimista. Comandos com versão defasada são rejeitados com erro de concorrência, sem mesclar decisões automaticamente.
