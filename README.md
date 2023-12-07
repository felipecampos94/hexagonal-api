# Spring Boot API with Hexagonal Architecture

Este é um projeto de API desenvolvido em Spring Boot 3.2.0, utilizando Java 17, MongoDB, Kafka, Docker e a API WireMock. O objetivo deste projeto é fornecer um exemplo prático para estudos sobre a arquitetura hexagonal.

## Arquitetura Hexagonal

A arquitetura hexagonal, também conhecida como arquitetura de porta e adaptador, separa as preocupações da aplicação em três camadas principais: lógica de aplicação, interfaces de entrada e interfaces de saída. Essa abordagem facilita a testabilidade, a manutenção e a evolução da aplicação.

### Estrutura do Projeto

- `src/main/java/com.example.api`: Contém a lógica da aplicação.
- `src/main/java/com.example.api.adapter`: Contém as implementações das interfaces de entrada e saída.
- `src/main/java/com.example.api.port`: Define as interfaces de entrada e saída.

## Tecnologias Utilizadas

- **Spring Boot 3.2.0**: Framework para desenvolvimento de aplicações Java.
- **Java 17**: A versão mais recente da linguagem Java.
- **MongoDB**: Banco de dados NoSQL utilizado para armazenamento de dados.
- **Kafka**: Plataforma de streaming distribuído para processamento de eventos em tempo real.
- **Docker**: Plataforma de conteinerização que simplifica a implantação e execução de aplicações.

## Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas em sua máquina:

- [Docker](https://docs.docker.com/get-docker/)
- [Docker Compose](https://docs.docker.com/compose/install/)
