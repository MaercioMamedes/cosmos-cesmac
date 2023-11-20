# Operações financeira com arquitetura COSMOS
## Aplicando príncípios de uma arquitetura de software desacoplada e coesa


Esse Projeto tem o objetivo de apresentar de forma didática, uma aplicação simples, desenvolvida em Java, que simula operações de Empréstimo para clientes de uma instituição financeira.

Dentro do projeto raiz, temos dois componentes do software, que são nativamente desacoplados, que são o **Componente Empréstimo** e o **Componente Limite**. Dentro das regras de negócio da aplicação existe uma forma desses componentes se comunicarem apenas por um terceiro elemento, que denominamos **Conector**, que por sua vez é encarregado de manter as estruturas lógicas e semântica das regras de negócios da Aplicação.