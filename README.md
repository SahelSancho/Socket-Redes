
# Sistema Cliente-Servidor em Java

Este projeto é um exemplo de implementação de um sistema cliente-servidor em Java. Ele permite que um cliente se conecte ao servidor, envie um ID para consulta, e receba uma resposta associada ao ID, demonstrando o uso de **sockets** e **multi-threading** em Java para suportar múltiplas conexões simultâneas.

## Funcionalidades

- **Servidor**: Mantém uma estrutura de dados com informações associadas a IDs específicos e responde a múltiplas conexões de clientes.
- **Cliente**: Conecta-se ao servidor e permite consultas múltiplas enviando IDs para receber as informações.
- **Multi-threading**: Cada conexão de cliente é tratada em uma thread separada para garantir que o servidor possa atender vários clientes ao mesmo tempo.
- **Comunicação via TCP**: Utiliza o protocolo TCP para garantir a entrega confiável das mensagens.

## Estrutura do Projeto

- `Servidor.java`: Classe que implementa o servidor e gerencia as conexões dos clientes.
- `Cliente.java`: Classe que implementa o cliente e permite o envio de IDs ao servidor.

## Pré-requisitos

- **Java Development Kit (JDK)**: Certifique-se de que o JDK (Java 8 ou superior) está instalado e configurado no `PATH` do sistema.

## Como Executar

### 1. Clonar o repositório

```bash
git clone https://github.com/seu-usuario/nome-do-repositorio.git
cd nome-do-repositorio
```

### 2. Compilar os arquivos Java

No diretório do projeto, execute os seguintes comandos para compilar o servidor e o cliente:

```bash
javac Servidor.java
javac Cliente.java
```

### 3. Executar o Servidor

Inicie o servidor para que ele fique escutando na porta especificada (12345):

```bash
java Servidor
```

### 4. Executar o Cliente

Abra um novo terminal e execute o cliente. O cliente solicitará um ID para enviar ao servidor:

```bash
java Cliente
```

Após a conexão, o cliente pode digitar IDs para consultar informações no servidor. Para encerrar a conexão, basta digitar `-1`.

## Exemplo de Uso

```plaintext
Conectado ao servidor.
Digite um ID de 1 a 3 para consulta (ou -1 para sair): 1
Resposta do servidor: Olá, você recebeu essa mensagem do servidor 1
Digite um ID de 1 a 3 para consulta (ou -1 para sair): 2
Resposta do servidor: Olá, você recebeu essa mensagem do servidor 2
Digite um ID de 1 a 3 para consulta (ou -1 para sair): -1
Conexão encerrada pelo cliente.
```

## Estrutura de Dados

O servidor utiliza um `HashMap<Integer, String>` para armazenar e recuperar informações associadas aos IDs. Se o ID não for encontrado, o servidor retorna uma mensagem informando que o ID não existe.

## Personalização

Você pode personalizar o conteúdo do `HashMap` no código do servidor (`Servidor.java`) para testar com diferentes dados ou adicionar novas funcionalidades, como autenticação e comunicação bidirecional mais complexa.

## Contribuições

Sinta-se à vontade para abrir **issues** ou enviar **pull requests** com melhorias ou correções.

## Licença

Este projeto é de uso livre sob a licença MIT.
