# 7. Regras de negócio

> Esta lista é uma especificação inicial. A numeração normativa exata deve ser validada na matriz jurídica antes da implementação definitiva.

## 7.1 Constituição e formação

### GRP-001 — Configuração mínima

Um grupo não pode sair de `DRAFT` sem:

- categoria;
- duração;
- capacidade;
- créditos;
- atualização;
- taxas e fundos;
- regras de assembleia;
- regras de sorteio e lance;
- regras de inadimplência e exclusão;
- regras de restituição;
- regulamento versionado.

### GRP-002 — Viabilidade

A primeira AGO depende de avaliação de viabilidade aprovada e armazenada como evidência.

Entradas mínimas:

- cotas ativas;
- crédito total;
- contribuição projetada;
- contemplações projetadas;
- inadimplência esperada;
- exclusões esperadas;
- reposição;
- prazo;
- fundos;
- cenários adversos.

### GRP-003 — Prazo de formação

O sistema controla o prazo aplicável e produz evento de falha de formação quando não atendido.

### GRP-004 — Capacidade

O total de cotas ativas não pode ultrapassar o máximo vigente e legalmente admitido.

## 7.2 Cotas

### QTA-001 — Unicidade

O número da cota é único por grupo.

### QTA-002 — Titularidade temporal

A titularidade tem início e fim; períodos não podem se sobrepor.

### QTA-003 — Cota contemplada

Regras de exclusão, transferência, quitação e encerramento devem considerar a condição de contemplação.

### QTA-004 — Readmissão

A readmissão exige:

- cota não contemplada;
- manifestação válida;
- capacidade disponível;
- avaliação exigida;
- plano para recompor obrigações;
- tratamento de juros, multas e diferenças conforme regra aplicável.

## 7.3 Obrigações

### OBR-001 — Composição

Cada obrigação é decomposta em componentes, por exemplo:

- fundo comum;
- taxa de administração;
- fundo de reserva;
- seguro;
- diferença;
- multa;
- juros;
- outros componentes contratualmente admitidos.

### OBR-002 — Atualização

A obrigação deve guardar:

- base anterior;
- índice ou preço;
- fator;
- data de referência;
- arredondamento;
- resultado;
- regra.

### OBR-003 — Apropriação

Pagamento externo somente produz efeito após confirmação idempotente e apropriação explícita.

### OBR-004 — Estorno

Estorno não apaga contribuição; gera reversão vinculada.

## 7.4 Elegibilidade

### ELG-001 — Snapshot

A elegibilidade é determinada na posição congelada da assembleia.

### ELG-002 — Critérios explicáveis

Para cada cota, o sistema informa:

- elegível ou não;
- critérios avaliados;
- valores usados;
- motivos de impedimento.

## 7.5 Assembleia

### ASM-001 — Sequência

Assembleias possuem sequência única e competência.

### ASM-002 — Posição congelada

Depois do congelamento, novos pagamentos ou alterações não modificam aquela tentativa de processamento.

### ASM-003 — Recursos

O motor calcula recursos disponíveis, vinculados, reservas e limites antes de contemplar.

### ASM-004 — Ordem

A ordem legal e contratual entre sorteio e lance é aplicada pela política vigente.

### ASM-005 — Reprodutibilidade

O resultado inclui hash de:

- snapshot;
- regras;
- parâmetros;
- entradas de sorteio;
- lances;
- saída.

## 7.6 Sorteio

### SRT-001 — Fonte verificável

O método de sorteio deve ter fonte, algoritmo e prova de integridade documentados.

### SRT-002 — Impedidos

Uma cota sorteada mas inelegível segue a regra contratual de suplência/reexecução sem alteração silenciosa.

## 7.7 Lances

### LNC-001 — Modalidades

Modalidades iniciais:

- livre;
- fixo;
- embutido.

Outras modalidades dependem de política instalada.

### LNC-002 — Comparabilidade

A classificação usa uma unidade comparável definida no regulamento: valor, percentual do crédito ou percentual do saldo, conforme modalidade.

### LNC-003 — Desempate

O critério de desempate deve ser explícito, versionado e reproduzível.

### LNC-004 — Lance embutido

O valor reduz o crédito disponível e é aplicado às obrigações conforme política contratual e regulatória.

## 7.8 Contemplação

### CNT-001 — Limite financeiro

Não se confirma contemplação que exceda os recursos ou condições permitidas.

### CNT-002 — Histórico

Cancelamento preserva a contemplação original e registra fundamento.

### CNT-003 — Direito e utilização

A existência da contemplação é separada da análise e utilização externa do crédito.

## 7.9 Exclusão

### EXC-001 — Não contemplado

O fluxo comum de exclusão aplica-se apenas quando juridicamente permitido.

### EXC-002 — Motivo e prazo

A exclusão exige motivo, cronologia de inadimplência ou manifestação e regra vigente.

### EXC-003 — Restituição

A exclusão cria posição de restituição, sem confundi-la com pagamento imediato.

## 7.10 Encerramento

### ENC-001 — Pré-condições

O encerramento operacional valida:

- assembleias previstas;
- contemplações;
- saldos;
- obrigações;
- restituições;
- recursos remanescentes;
- pendências.

### ENC-002 — Fases distintas

Encerramento operacional e contábil são eventos distintos.

## 7.11 Arredondamento

Toda fórmula define:

- escala interna;
- escala de apresentação;
- modo de arredondamento;
- destino de resíduos;
- tratamento de diferenças acumuladas.

O padrão inicial proposto é cálculo com alta precisão e arredondamento monetário no ponto de obrigação, nunca em etapas intermediárias sem justificativa.
