# 3. Base regulatória

## 3.1 Fontes primárias

### Lei nº 11.795/2008

Institui o Sistema de Consórcios e define, entre outros elementos:

- natureza e finalidade do sistema;
- grupo como sociedade não personificada;
- contrato de participação;
- patrimônio do grupo separado do patrimônio da administradora;
- contemplação;
- direitos e obrigações;
- restituição;
- competências do Banco Central.

Fonte oficial:  
https://www.planalto.gov.br/ccivil_03/_ato2007-2010/2008/lei/l11795.htm

### Resolução BCB nº 285/2023

Disciplina a constituição e o funcionamento dos grupos de consórcio. Entrou em vigor, quanto a esse regime, em 1º de julho de 2024.

A resolução substituiu o regime anterior da Circular nº 3.432/2009 e consolidou mudanças como:

- regulamento disponibilizado no site da administradora;
- possibilidade de crédito nominal atualizado por índice ou indicador contratual;
- maior disciplina sobre contrato, grupo, contemplação e procedimentos operacionais;
- prazo máximo de inadimplência para exclusão definido em contrato, limitado pela norma;
- assembleias e comunicações eletrônicas;
- controles e informações do grupo.

Fontes oficiais:  
https://www.bcb.gov.br/meubc/faqs/p/novas-regras-sobre-a-constituicao-e-o-funcionamento-de-grupos-de-consorcios  
https://www.bcb.gov.br/detalhenoticia/655/noticia

### Resolução BCB nº 234/2022

Trata da constituição, organização e funcionamento das administradoras. Somente entra no core quando uma regra institucional for pré-condição de uma operação de grupo.

Fonte oficial:  
https://www.bcb.gov.br/estabilidadefinanceira/exibenormativo?numero=234&tipo=Resolu%C3%A7%C3%A3o+BCB

## 3.2 Hierarquia interna de regras

1. lei;
2. resolução vigente do BCB;
3. instruções e atos complementares;
4. regulamento do grupo;
5. contrato de participação;
6. deliberação válida de assembleia;
7. política operacional da administradora.

Uma regra de nível inferior não pode contrariar uma regra superior.

## 3.3 Catálogo regulatório

Cada requisito deve ser registrado neste formato:

```yaml
id: REG-GRP-001
titulo: Quantidade máxima de cotas
fonte:
  norma: "Resolução BCB nº 285/2023"
  dispositivo: "a confirmar na consolidação jurídica"
vigencia_inicio: "2024-07-01"
vigencia_fim: null
tipo: OBRIGATORIA
interpretacao: >
  A quantidade máxima deve ser fixada na constituição e alterações
  posteriores somente serão admitidas quando expressamente autorizadas.
implementacao:
  modulo: group
  politica: GroupCapacityPolicy
testes:
  - CT-GRP-001
status_validacao: PENDENTE_JURIDICO
```

## 3.4 Regra de desenvolvimento

Nenhum requisito marcado como `PENDENTE_JURIDICO` pode ser anunciado como conforme.

## 3.5 Normas revogadas

Normas revogadas podem ser usadas para:

- migração de grupos antigos;
- reprodução histórica;
- compreensão da evolução normativa.

Elas não devem ser usadas como fonte de novas operações após o fim de sua vigência.

## 3.6 Controle de atualização

A documentação normativa terá:

- data da última verificação;
- hash ou identificação da versão consultada;
- responsável pela revisão;
- diferenças identificadas;
- impacto nos módulos;
- plano de migração;
- suíte de regressão.

Última verificação inicial: 13 de julho de 2026.
