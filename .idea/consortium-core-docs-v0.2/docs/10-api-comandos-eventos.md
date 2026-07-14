# 10. API, comandos e eventos

## 10.1 Princípios

- comandos no imperativo;
- consultas sem efeitos colaterais;
- eventos no passado;
- versionamento explícito;
- idempotência para comandos externos;
- erros de domínio estruturados.

## 10.2 Endpoints iniciais

### Grupos

```http
POST /v1/groups
POST /v1/groups/{id}/configuration-versions
POST /v1/groups/{id}/publish
POST /v1/groups/{id}/viability-assessments
POST /v1/groups/{id}/authorize-first-assembly
POST /v1/groups/{id}/begin-closure
GET  /v1/groups/{id}
GET  /v1/groups/{id}/position?asOf=YYYY-MM-DD
```

### Cotas

```http
POST /v1/groups/{groupId}/quotas
POST /v1/quotas/{id}/reserve
POST /v1/quotas/{id}/activate
POST /v1/quotas/{id}/exclude
POST /v1/quotas/{id}/readmit
POST /v1/quotas/{id}/transfers
GET  /v1/quotas/{id}
GET  /v1/quotas/{id}/position
```

### Obrigações

```http
POST /v1/groups/{id}/obligations/generate
POST /v1/payments/confirmations
POST /v1/payments/confirmations/{id}/reverse
GET  /v1/quotas/{id}/obligations
```

### Assembleias

```http
POST /v1/groups/{id}/assemblies
POST /v1/assemblies/{id}/freeze
POST /v1/assemblies/{id}/bids
POST /v1/assemblies/{id}/process
POST /v1/assemblies/{id}/homologate
POST /v1/assemblies/{id}/annul
GET  /v1/assemblies/{id}
GET  /v1/assemblies/{id}/explain
```

## 10.3 Cabeçalhos

```text
Idempotency-Key
X-Correlation-Id
If-Match
```

## 10.4 Erro de domínio

```json
{
  "code": "QUOTA_NOT_ELIGIBLE",
  "message": "A cota não está elegível para esta assembleia.",
  "details": [
    {
      "rule": "ELG-002",
      "reason": "OVERDUE_OBLIGATION",
      "referenceDate": "2026-07-10"
    }
  ],
  "correlationId": "..."
}
```

## 10.5 Eventos

### Grupo

- `GroupCreated`
- `GroupConfigurationPublished`
- `GroupViabilityApproved`
- `GroupViabilityRejected`
- `GroupActivated`
- `GroupSuspended`
- `GroupClosureStarted`
- `GroupOperationallyClosed`
- `GroupAccountingClosed`

### Cota

- `QuotaCreated`
- `QuotaReserved`
- `QuotaActivated`
- `QuotaExcluded`
- `QuotaReadmitted`
- `QuotaTransferRegistered`
- `QuotaSettled`
- `QuotaClosed`

### Financeiro

- `QuotaObligationGenerated`
- `PaymentConfirmed`
- `ContributionAllocated`
- `ContributionReversed`
- `GroupFinancialPositionChanged`

### Assembleia

- `AssemblyScheduled`
- `AssemblySnapshotFrozen`
- `BidRegistered`
- `AssemblyProcessed`
- `AssemblyHomologated`
- `AssemblyAnnulled`
- `QuotaContemplated`
- `ContemplationCancelled`

## 10.6 Envelope

```json
{
  "eventId": "uuid",
  "eventType": "QuotaContemplated",
  "eventVersion": 1,
  "aggregateType": "Quota",
  "aggregateId": "uuid",
  "aggregateVersion": 15,
  "occurredAt": "2026-07-13T22:00:00Z",
  "effectiveDate": "2026-07-13",
  "correlationId": "uuid",
  "causationId": "uuid",
  "ruleSetVersion": "2026.07.0",
  "data": {}
}
```
