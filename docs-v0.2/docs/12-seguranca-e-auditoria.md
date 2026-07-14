# 12. Segurança e auditoria

## 12.1 Ameaças prioritárias

- alteração indevida de assembleia;
- inserção ou remoção de lance;
- manipulação da elegibilidade;
- pagamento duplicado;
- reversão não autorizada;
- alteração retroativa de regra;
- fraude em sorteio;
- quebra de segregação entre grupos;
- acesso a dados de outra administradora;
- apagamento de evidências.

## 12.2 Controles

- autenticação OIDC;
- autorização por ação e escopo;
- segregação por administradora e grupo;
- dupla aprovação para operações críticas;
- MFA delegado ao IAM;
- idempotência;
- locks;
- assinatura/hash de snapshots;
- encadeamento de evidências;
- criptografia;
- rotação de segredos;
- backup e restauração testados.

## 12.3 Ações críticas

Exigem privilégio específico e justificativa:

- homologar assembleia;
- anular assembleia;
- cancelar contemplação;
- reverter contribuição;
- alterar configuração futura;
- iniciar encerramento;
- fechar grupo;
- instalar nova versão regulatória.

## 12.4 Evidência

```text
AuditEvidence
├── evidenceId
├── action
├── actor
├── subject
├── beforeHash
├── afterHash
├── ruleExecution
├── justification
├── approvals
├── effectiveDate
├── recordedAt
└── correlationId
```

## 12.5 Privacidade

O core deve minimizar dados pessoais. Preferir:

- `partyReference`;
- dados estritamente necessários ao domínio;
- pseudonimização em ambientes não produtivos;
- retenção definida;
- exportação e bloqueio conforme obrigação legal.

## 12.6 Integridade do sorteio

A especificação final deve escolher um método verificável, incluindo:

- fonte pública ou semente;
- instante de captura;
- algoritmo;
- ordenação das cotas;
- tratamento de impedidos;
- hash de entrada e saída;
- procedimento de contingência.

## 12.7 Auditoria operacional

Consultas obrigatórias:

- explicar saldo;
- explicar elegibilidade;
- explicar contemplação;
- reconstruir assembleia;
- listar mudanças de configuração;
- listar reversões;
- comparar posição atual com posição histórica.
