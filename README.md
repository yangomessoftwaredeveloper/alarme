# Alarme em Java

Projeto desenvolvido em Java que permite ao usuário definir um horário para um alarme através do terminal. Enquanto aguarda o horário informado, o programa exibe o relógio em tempo real e, quando o momento é atingido, reproduz um arquivo de áudio no formato `.wav`.

O objetivo do projeto foi praticar conceitos fundamentais da linguagem Java, como Programação Orientada a Objetos, manipulação de datas e horas, tratamento de exceções e multithreading.

## Funcionalidades

* Definição do horário do alarme pelo usuário.
* Validação do formato de entrada (`HH:mm:ss`).
* Exibição do horário atual em tempo real.
* Reprodução de um arquivo de áudio quando o alarme dispara.
* Encerramento do alarme ao pressionar ENTER.

## Tecnologias

* Java
* Java Time API (`java.time`)
* Java Sound API (`javax.sound.sampled`)
* Git
* GitHub

## Conceitos aplicados

* Programação Orientada a Objetos (POO)
* Classes e Objetos
* Construtores
* Encapsulamento
* Polimorfismo
* Interface `Runnable`
* Multithreading (`Thread`)
* Tratamento de exceções
* Try-with-resources
* Manipulação de arquivos
* Manipulação de datas e horas
* Entrada de dados com `Scanner`
* Validação de entrada

## Estrutura do projeto

```text
├── Main.java
├── RelogioAlarme.java
└── du-bist-gut-genug.wav
```

## Como executar

1. Clone o repositório.
2. Abra o projeto em uma IDE Java.
3. Certifique-se de que o arquivo `.wav` esteja na pasta do projeto.
4. Execute a classe `Main`.
5. Informe o horário no formato `HH:mm:ss`.

Exemplo:

```text
09:30:00
```

## O que foi praticado

Durante o desenvolvimento deste projeto foram utilizados conceitos importantes da linguagem Java, como criação de threads, implementação da interface `Runnable`, manipulação de horários com `LocalTime`, tratamento de exceções específicas e reprodução de áudio utilizando a Java Sound API.

## Autor

Yan Gomes
