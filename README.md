# TESTES UNITÁRIOS

## O que são?
- São códigos de teste com bilbiotecas de testes (JUnit) que desenvolvemos para testar todas as linhas de código do nosso sistema.
- Normalmente criamos códigos que testam várias das possibilidades que programamos:
  - Exemplo: 
    - Se temos um determinado fluxo com um if, significa que quando não entramos no if, seguimos por outro fluxo. Logo, todos esses comportamentos possíveis devem ser testados.

## Por que devemos utilizar?
- Para garantir qualidade de código.
- Para garantir funcionamento dos métodos que criamos.
- Nos ajuda a entender pontos de melhoria no nosso código
- Porque existem esteiras de deploy (Jenkins) com ferramentas de análise de qualidade de código (SonarQube) que barram os deploys caso determinado percentual de cobertura de testes não for atingido.
- Quanto maior o nível de maturidade da empresa e da aplicação, maior a necessidade de testes unitários, afinal, os testes nos auxiliam a entender os fluxos dos serviços.
- Sempre que realizamos uma mudança em nossos serviços (mudanças de fluxos, mudanças comportamentais), os testes vão quebrar, e isso é bom, porque nos faz ajustar os testes e garantir que a nova feature ou a correção gerou efeito.

## O que devemos testar?
- TUDO QUE FOR TESTÁVEL.

## Tecnologias de teste

- Para Java utilizamos JUnit
- Para Python, temos o PyTest
- Jest para Typescript/NodeJS
- ...

## Testes unitários Aula 04/10/22

- Como se testa uma classe de DTO, da mesma forma que testamos todas as outras, fornecendo a informação e esperando o resultado. (começa em instanciar o objeto, para setar os valores dos atributos no objeto).
- AssertNotNull passando o objeto instânciado, pois precisamos receber um objeto.