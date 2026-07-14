# 11. Testes e qualidade

## 11.1 Pirâmide

- testes unitários de domínio;
- testes baseados em propriedades;
- testes de contrato;
- testes de persistência;
- testes de integração;
- testes de ponta a ponta do ciclo do grupo;
- suíte regulatória.

## 11.2 Propriedades financeiras

Exemplos:

1. ledger sempre equilibrado;
2. reversão integral neutraliza o movimento original;
3. saldo em data T é soma dos movimentos eficazes até T;
4. nenhuma contemplação confirmada excede o limite calculado;
5. o mesmo snapshot e regra geram o mesmo hash;
6. total apropriado não excede pagamento confirmado;
7. total de componentes de obrigação corresponde ao total da obrigação;
8. resíduos seguem política explícita.

## 11.3 Cenário canônico v0.1

1. criar grupo;
2. publicar regulamento;
3. criar 100 cotas;
4. ativar conjunto mínimo;
5. aprovar viabilidade;
6. gerar obrigações;
7. confirmar pagamentos;
8. congelar primeira AGO;
9. sortear uma cota;
10. classificar lances;
11. contemplar dentro do saldo;
12. homologar;
13. reajustar crédito;
14. excluir não contemplado;
15. readmitir;
16. encerrar grupo;
17. calcular restituições;
18. reproduzir posição histórica.

## 11.4 Casos negativos

- ativação sem viabilidade;
- cota duplicada;
- pagamento duplicado;
- assembleia com snapshot alterado;
- lance fora do prazo;
- cota inelegível;
- contemplação sem recurso;
- exclusão indevida;
- readmissão acima da capacidade;
- alteração de regra retroativa;
- ledger desequilibrado;
- fechamento com pendências.

## 11.5 Golden master

Casos regulatórios validados por especialistas serão armazenados como vetores de entrada e saída assinados.

## 11.6 Mutação

Módulos de cálculo e elegibilidade devem atingir cobertura de mutação definida, não apenas cobertura de linhas.

## 11.7 Arquitetura

ArchUnit verifica:

- domínio sem Spring/JPA;
- proibição de dependência circular;
- acesso entre módulos apenas por API;
- proibição de repositório de outro módulo;
- eventos não dependem de entidade JPA.

## 11.8 Critérios de release

- todos os testes regulatórios aprovados;
- nenhuma migração destrutiva não autorizada;
- documentação de regra atualizada;
- relatório de diferenças normativas;
- reprodução determinística comprovada;
- SBOM e análise de dependências;
- parecer de revisão quando o release declarar conformidade.
