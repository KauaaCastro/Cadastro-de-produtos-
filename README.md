# Sistema de Cadastro de Artigos Religiosos

Este projeto consiste em uma aplicação Java Swing desenvolvida para auxiliar no cadastro de artigos religiosos em uma loja. O sistema permite registrar informações sobre as peças em um banco de dados MySQL e visualizar os dados cadastrados em uma tabela intuitiva.

## Funcionalidades

O sistema oferece as seguintes funcionalidades:

* **Inserção de Artigos:** Permite ao usuário inserir informações sobre um novo artigo religioso. Os campos incluem:
    * **Tamanho/Código:** Este campo aceita tanto o tamanho da imagem religiosa (em centímetros, por exemplo) quanto um código de identificação único do produto. A escolha depende da forma como a loja organiza seus produtos. Vale ressaltar que isso deve ser alterado no programa, pretendo postar uma versão que utilize código e não "tamanho" posteriormente...
    * **Descrição:** Uma descrição detalhada do artigo religioso (nome da imagem, santo).
    * **Preço:** O valor de venda do artigo.
* **Adição à Tabela:** Ao clicar no botão "Inserir", os dados digitados são adicionados a uma tabela exibida na interface. Esta ação é uma visualização temporária; os dados ainda não foram gravados no banco de dados.
* **Salvar no Banco de Dados:** O botão "Salvar" persiste os dados presentes na tabela (adicionados desde a última vez que os dados foram salvos) no banco de dados MySQL. Uma mensagem informa ao usuário o intervalo de artigos religiosos que foram salvos com sucesso.
* **Carregar Dados:** Ao clicar no botão "Carregar", os dados dos artigos religiosos armazenados na tabela `produto` do banco de dados MySQL são recuperados e exibidos na tabela da interface, permitindo visualizar o catálogo atualizado.

## Tecnologias Utilizadas

* **Java Swing:** Framework utilizado para construir a interface gráfica amigável do sistema.
* **JDBC (Java Database Connectivity):** API utilizada para estabelecer a comunicação e interagir com o banco de dados MySQL, permitindo a manipulação dos dados dos artigos religiosos.
* **MySQL:** Sistema de gerenciamento de banco de dados relacional onde as informações dos artigos religiosos são armazenadas de forma organizada.

## Pré-requisitos

Para executar este programa, você precisará ter os seguintes softwares instalados em sua máquina:

* **Java Development Kit (JDK):** Essencial para compilar e executar o código Java.
* **MySQL Server:** O servidor do banco de dados MySQL deve estar instalado e em execução para armazenar os dados dos artigos religiosos.
* **Driver JDBC do MySQL:** A biblioteca `mysql-connector-java` (ou similar) deve estar incluída no classpath do projeto para permitir a conexão com o banco de dados MySQL.

## Configuração do Banco de Dados

1.  **Crie um banco de dados chamado `estoque`** no seu servidor MySQL para armazenar os dados da loja.
2.  **Crie uma tabela chamada `produto`** com as seguintes colunas para registrar as informações dos artigos religiosos:
    * `tamanho` (INT): Utilizado para armazenar tanto o tamanho da imagem quanto o código do produto.
    * `descricao` (VARCHAR(255)): Para a descrição detalhada do artigo religioso.
    * `preco` (DOUBLE): Para o preço de venda do artigo.

    Você pode criar a tabela executando o seguinte comando SQL no MySQL:

    ```sql
    CREATE TABLE estoque.produto (
        tamanho INT,
        descricao VARCHAR(255),
        preco DOUBLE
    );
    ```

3.  **Configure as credenciais de acesso ao banco de dados** no arquivo `Conexao.java`. Certifique-se de que a URL, o nome de usuário (`user`) e a senha (`password`) correspondam às configurações do seu servidor MySQL. No código fornecido, as configurações padrão são:

    ```java
    String url = "jdbc:mysql://localhost:3306/estoque";
    String user = "root";
    String password = "123456";
    ```

    **Importante:** Caso a senha do seu banco de dados MySQL seja diferente de `123456`, atualize-a no arquivo `Conexao.java`.

## Como Executar o Programa

1.  **Compile os arquivos Java:** Utilize um ambiente de desenvolvimento integrado (IDE) como IntelliJ IDEA, Eclipse ou NetBeans para compilar os arquivos `ProjetoSwing.java` e `Conexao.java`. Alternativamente, você pode compilar os arquivos através da linha de comando utilizando o compilador `javac`. Certifique-se de que o driver JDBC do MySQL esteja incluído no classpath durante a compilação.
2.  **Execute a classe principal:** Execute o método `main` da classe `ProjetoSwing`. Isso iniciará a interface gráfica do sistema de cadastro de artigos religiosos.

## Utilização

1.  Na interface do sistema, preencha os campos:
    * **Tamanho/Código:** Insira o tamanho da imagem religiosa ou o código de identificação do produto.
    * **Descrição:** Digite a descrição do artigo religioso.
    * **Preço:** Informe o preço de venda.
2.  Clique no botão "Inserir" para adicionar as informações do artigo à tabela de visualização.
3.  Continue adicionando outros artigos à tabela, se necessário, repetindo os passos 1 e 2.
4.  Clique no botão "Salvar" para gravar os artigos exibidos na tabela (que ainda não foram salvos no banco de dados) no MySQL.
5.  Clique no botão "Carregar" para atualizar a tabela com os dados mais recentes dos artigos religiosos armazenados no banco de dados.

## Próximos Passos (Versão Futura)

Esta é uma versão inicial do sistema de cadastro. Em uma versão futura, pretende-se adicionar as seguintes melhorias:

* **Validação de Dados:** Implementar validações para garantir que os dados inseridos sejam consistentes e corretos (por exemplo, garantir que o preço seja um valor numérico).
* **Edição e Remoção de Itens:** Adicionar funcionalidades para editar informações de artigos já cadastrados e remover itens da tabela e do banco de dados.

## Observações

* O campo "Tamanho" atua de forma flexível, aceitando tanto o tamanho físico da imagem religiosa quanto um código de identificação do produto.
* O tratamento de erros é básico nesta versão. Mensagens simples são exibidas em caso de problemas na conexão com o banco de dados ou durante a manipulação dos dados.
* Ao carregar os dados do banco, o preço é formatado para exibição na tabela com o símbolo "R$". Ao salvar, o valor é tratado como um número decimal.
