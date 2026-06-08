# Sistema de Agendamento de Consultas Médicas

Projeto desenvolvido em Java com foco em regras de negócio, validações e Programação Orientada a Objetos.

## Objetivo

Simular um sistema de agendamento de consultas médicas garantindo que as regras de negócio sejam respeitadas.

## Funcionalidades

- Cadastro de médicos
- Cadastro de pacientes
- Agendamento de consultas
- Listagem de consultas

## Regras de Negócio

### Horário Comercial

Consultas só podem ser agendadas:

- Segunda a Sexta
- Das 08:00 às 18:00

### Antecedência Mínima

O paciente deve marcar a consulta com pelo menos:

- 30 minutos de antecedência

### Conflito de Agenda

O sistema impede:

- Dois agendamentos para o mesmo médico
- No mesmo horário

## Tecnologias Utilizadas

- Java 21
- Java Time API
- Collections Framework
- Programação Orientada a Objetos

## Estrutura do Projeto

```text
src
├── model
├── service
├── exception
└── Main.java
```

## Conceitos Demonstrados

- Encapsulamento
- Classes e Objetos
- Streams API
- Tratamento de Exceções
- Regras de Negócio
- Manipulação de Datas
- Arquitetura em Camadas

## Autor

Vinicius Mendes

Estudante de Tecnologia da Informação focado em Desenvolvimento Backend Java.
