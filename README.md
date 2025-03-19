# Caixa Eletrônico Simples

Este é um projeto em Java que simula um caixa eletrônico básico, permitindo operações como criar contas, depositar, sacar, transferir entre contas e consultar saldo. Foi desenvolvido como parte de um portfólio para demonstrar habilidades em programação orientada a objetos, uso de pacotes e boas práticas de código.

## Funcionalidades
- Criar uma nova conta com nome, sobrenome e CPF do titular.
- Realizar depósitos em contas existentes.
- Efetuar saques, verificando saldo disponível.
- Transferir valores entre contas.
- Consultar o saldo de uma conta.

## Requisitos
- **Java 14 ou superior**: Necessário para suportar a sintaxe moderna do `switch` com `->`.
- Um ambiente de desenvolvimento Java (ex.: IntelliJ IDEA, Eclipse) ou o JDK instalado para compilar e executar via terminal.

## Instalação
1. Clone o repositório do GitHub:
  ```bash
  git clone https://github.com/DougBrando/CaixaEletronico.git
  ```
   
2. Navegue até o diretório do projeto:
  ```bash
  cd CaixaEletronico
  ```

## Como Executar
1. Compile os arquivos Java:
 ```bash
 javac src/br/senai/lab365/futurodev/caixaeletronico/main/Main.java
 ```

2. Execute o programa:
  ```bash
  java br.senai.lab365.futurodev.caixaeletronico.main.Main
```

3. Siga as instruções no console para interagir com o menu do caixa eletrônico.

## Estrutura do Projeto
  ```txt
  src/
  ├── br/
  │   ├── senai/
  │   │   ├── lab365/
  │   │   │   ├── futurodev/
  │   │   │   │   ├── caixaeletronico/
  │   │   │   │   │   ├── main/
  │   │   │   │   │   │   └── Main.java          # Classe principal com o menu
  │   │   │   │   │   ├── models/
  │   │   │   │   │   │   ├── Cliente.java       # Modelo do cliente
  │   │   │   │   │   │   └── Conta.java         # Modelo da conta bancária
  │   │   │   │   │   ├── repositories/
  │   │   │   │   │   │   └── ContaRepository.java # Repositório de contas
  ```


## Uso
Ao executar o programa, um menu será exibido no console:
  
  ```text
  Escolha uma operação:
  1 - Criar conta
  2 - Depositar
  3 - Sacar
  4 - Transferir
  5 - Ver Saldo
  0 - Sair
  ```

Digite o número da operação desejada e siga as instruções exibidas.

### Exemplo
1. Escolha `1` para criar uma conta.
2. Insira nome, sobrenome e CPF.
3. Use o número da conta gerado para depositar (`2`), sacar (`3`) ou transferir (`4`).

## Contribuição
Sinta-se à vontade para abrir issues ou enviar pull requests com sugestões de melhorias.

## Licença
Este projeto é de código aberto e está disponível sob a [MIT License](LICENSE).



