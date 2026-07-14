# 1. Visão e princípios

## 1.1 Visão

Criar uma implementação aberta e verificável do domínio central de consórcios, capaz de:

1. representar grupos e cotas sem dependência de canais ou fornecedores;
2. executar regras regulatórias e contratuais de forma determinística;
3. explicar qualquer resultado produzido;
4. reproduzir assembleias, saldos e transições históricas;
5. permitir extensão por módulos externos sem contaminar o núcleo.

## 1.2 Proposta de valor

O projeto não é um ERP. É um **motor de domínio**.

Seu produto principal é uma combinação de:

- modelo canônico;
- políticas versionadas;
- máquina de estados;
- ledger de grupo e cota;
- motor de assembleia;
- APIs e eventos;
- evidências de auditoria;
- suíte pública de conformidade.

## 1.3 Princípios

### P1 — Regulação rastreável

Toda regra obrigatória deve apontar para:

- norma;
- artigo, inciso ou parágrafo;
- vigência;
- interpretação adotada;
- teste correspondente.

### P2 — Determinismo

A mesma versão da regra, com as mesmas entradas, produz o mesmo resultado.

### P3 — Temporalidade

O sistema deve distinguir:

- data de competência;
- data de eficácia;
- data de processamento;
- instante de registro;
- vigência da regra.

### P4 — Imutabilidade histórica

Correções usam reversão, compensação ou nova versão. Não há edição silenciosa de fatos processados.

### P5 — Núcleo pequeno

O core conhece referências externas, mas não implementa CRM, banco, cobrança, portal, análise de crédito ou pagamento ao fornecedor.

### P6 — Parametrização limitada

Regras contratuais podem ser parametrizadas. Regras legais não podem ser desligadas por configuração comum.

### P7 — Auditabilidade por construção

Auditoria não é um log textual posterior. É parte do modelo transacional.

### P8 — Extensão por contratos estáveis

Integrações usam APIs e eventos versionados. O banco interno não é contrato de integração.

## 1.4 Usuários do projeto

- software houses do setor;
- administradoras com estratégia de modernização;
- equipes internas de tecnologia;
- consultorias regulatórias;
- pesquisadores e universidades;
- fornecedores de módulos complementares.

## 1.5 Não objetivos

- substituir análise jurídica;
- certificar automaticamente uma administradora;
- garantir conformidade apenas pela instalação;
- definir práticas contábeis sem validação especializada;
- suportar todos os produtos no primeiro release.
