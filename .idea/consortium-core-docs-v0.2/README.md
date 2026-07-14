# Consortium Core

Núcleo open source, regulatório, determinístico e auditável para executar o ciclo de vida de **grupos e cotas de consórcio** no Brasil.

> Status: especificação inicial v0.1.0.  
> Esta documentação não substitui parecer jurídico, contábil, atuarial ou regulatório.

## Objetivo

Implementar exclusivamente o domínio essencial de consórcio:

- constituição e configuração de grupos;
- formação, ativação, funcionamento e encerramento de grupos;
- criação e ciclo de vida de cotas;
- obrigações e contribuições das cotas;
- assembleias ordinárias e extraordinárias;
- sorteios, lances e contemplações;
- exclusão, readmissão e transferência;
- reajustes e diferenças de prestação;
- fundos e posição financeira do grupo;
- trilha histórica, auditoria e reprodução dos cálculos.

## Fora do escopo inicial

CRM, vendas, boleto, Pix, conciliação bancária, cobrança operacional, cadastro completo de clientes, PLD/FT, análise de crédito, garantias, pagamento de fornecedores, portal, aplicativo, assinatura eletrônica, comissionamento e contabilidade corporativa.

Esses sistemas se integram ao core por comandos, consultas e eventos.

## Documentos

1. [Visão e princípios](docs/01-visao-e-principios.md)
2. [Escopo e fronteiras](docs/02-escopo-e-fronteiras.md)
3. [Base regulatória](docs/03-base-regulatoria.md)
4. [Glossário do domínio](docs/04-glossario.md)
5. [Modelo de domínio](docs/05-modelo-de-dominio.md)
6. [Estados e transições](docs/06-estados-e-transicoes.md)
7. [Regras de negócio](docs/07-regras-de-negocio.md)
8. [Arquitetura](docs/08-arquitetura.md)
9. [Modelo de dados](docs/09-modelo-de-dados.md)
10. [API, comandos e eventos](docs/10-api-comandos-eventos.md)
11. [Testes e qualidade](docs/11-testes-e-qualidade.md)
12. [Segurança e auditoria](docs/12-seguranca-e-auditoria.md)
13. [Roadmap](docs/13-roadmap.md)
14. [Matriz de rastreabilidade](docs/14-matriz-rastreabilidade.md)
15. [Questões em aberto](docs/15-questoes-em-aberto.md)
16. [Licenciamento e governança](docs/16-licenciamento-e-governanca.md)

## Decisões arquiteturais

- [ADR-001 — Monólito modular](adr/ADR-001-monolito-modular.md)
- [ADR-002 — Ledger imutável](adr/ADR-002-ledger-imutavel.md)
- [ADR-003 — Regras versionadas](adr/ADR-003-regras-versionadas.md)
- [ADR-004 — PostgreSQL como fonte transacional](adr/ADR-004-postgresql.md)
- [ADR-005 — Licenciamento](adr/ADR-005-licenciamento.md)

## Fontes normativas principais

- Lei nº 11.795, de 8 de outubro de 2008.
- Resolução BCB nº 285, de 19 de janeiro de 2023, vigente para constituição e funcionamento dos grupos desde 1º de julho de 2024.
- Resolução BCB nº 234, de 27 de julho de 2022, quando houver dependência de regra institucional da administradora.
- Demais normas, instruções e leiautes aplicáveis devem ser catalogados antes de cada release regulatório.

## Convenções

- Valores monetários: `BigDecimal`, sem `double`.
- Percentuais: valor decimal explícito e escala definida por tipo.
- Datas civis: `LocalDate`.
- Instantes auditáveis: `Instant` em UTC.
- Identificadores: UUID/ULID.
- Nenhum registro financeiro histórico é apagado ou sobrescrito.
- Toda decisão relevante registra regra, versão, entradas e resultado.
