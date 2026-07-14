# 9. Modelo de dados

## 9.1 Convenções

- tabelas em `snake_case`;
- chave primária UUID;
- `created_at`, `created_by`, `correlation_id`;
- `version` para lock otimista;
- datas efetivas separadas de timestamps;
- constraints no banco para invariantes simples;
- nenhuma exclusão física de fatos financeiros.

## 9.2 Tabelas principais

### group_module

```text
consortium_group
group_configuration_version
group_regulation_version
group_viability_assessment
group_status_history
group_representative
group_closure
```

### quota_module

```text
quota
quota_status_history
quota_ownership
quota_admission
quota_exclusion
quota_readmission
quota_transfer
credit_plan
payment_plan
```

### contribution_module

```text
quota_obligation
obligation_component
payment_confirmation
contribution_allocation
contribution_reversal
```

### assembly_module

```text
assembly
assembly_processing_attempt
assembly_snapshot
assembly_snapshot_quota
assembly_snapshot_financial_position
draw
draw_candidate
bid
bid_classification
contemplation
deliberation
```

### ledger_module

```text
ledger_account
ledger_journal
ledger_entry
ledger_reversal
ledger_balance_checkpoint
```

### audit_module

```text
domain_event
outbox_event
audit_evidence
rule_execution
idempotency_record
```

## 9.3 Ledger

Um diário deve equilibrar débitos e créditos na unidade definida.

```sql
create table ledger_journal (
    id uuid primary key,
    group_id uuid not null,
    source_type varchar(80) not null,
    source_id uuid not null,
    effective_date date not null,
    recorded_at timestamptz not null,
    reversal_of uuid null,
    rule_execution_id uuid not null,
    correlation_id uuid not null,
    unique (source_type, source_id)
);
```

```sql
create table ledger_entry (
    id uuid primary key,
    journal_id uuid not null references ledger_journal(id),
    account_id uuid not null references ledger_account(id),
    direction varchar(6) not null check (direction in ('DEBIT','CREDIT')),
    amount numeric(24,8) not null check (amount > 0),
    quota_id uuid null,
    component_type varchar(60) null
);
```

Validação obrigatória:

```text
soma(débitos) = soma(créditos)
```

## 9.4 Snapshot

O snapshot deve ser autocontido o suficiente para reprodução:

- cotas e estados;
- obrigações;
- contribuições;
- elegibilidade;
- fundos;
- recursos vinculados;
- lances válidos;
- regra e versão;
- data de corte;
- hash.

## 9.5 Histórico

Não usar tabelas de auditoria genéricas como única fonte. Eventos e históricos de estado devem ter semântica do domínio.

## 9.6 Multiadministradora

O modelo inclui `administrator_reference`, mas o isolamento completo SaaS será uma decisão posterior. O domínio nunca presume uma única administradora global.
