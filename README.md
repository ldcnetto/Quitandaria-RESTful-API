# Avanade Decola 2025 - RESTful API de uma Quitandaria

## Principais Tecnologias
- Java 17: foi utilizada a versão 17 do Java, pois tem compatibilidade com o build do Maven;
- Spring Boot 3 (3.4.3): a versão mais recente LTS do Spring Boot;
- Spring Web
- Spring Data JPA: facilita a integração com bancos de dados SQL;
- Spring Security: para a autenticação e segurança da API;
- OpenAPI (Swagger): criação da documentação da API;
- PostgreSQL
- Railway: facilita o deploy e monitoramento de nossas soluções na nuvem, além de oferecer diversos bancos de dados como serviço e pipelines de CI/CD.

## Modelagem do Banco de Dados

O banco de dados possui as seguintes tabelas:

- **Enderecos**: armazena informações sobre os endereços.
- **Clientes**: contém os dados dos clientes da quitandaria.
- **Cargos**: define os cargos dos funcionários.
- **Funcionarios**: armazena informações dos funcionários da loja.
- **Fornecedores**: lista os fornecedores de produtos.
- **Fornecedor_PF** e **Fornecedor_PJ**: diferenciam fornecedores como Pessoa Física e Pessoa Jurídica.
- **Transportadoras**: contém os dados das transportadoras.
- **Produtos**: lista os produtos vendidos na quitandaria.
- **Produtos_fornecedores**: define quais produtos são de quais fornecedores.
- **Formas_pagamento**: lista as formas de pagamento aceitas.
- **Vendas**: registra as vendas realizadas.
- **Itens_venda**: relaciona as vendas com os produtos comprados.
- **Estoque**: armazena a quantidade de produtos disponíveis.

```mermaid
classDiagram
    class Enderecos {
        +cep INT UNSIGNED (PK)
        +logradouro VARCHAR(50)
        +bairro VARCHAR(50)
        +cidade VARCHAR(20)
        +tipo ENUM('Cliente', 'Funcionario', 'Fornecedor', 'Transportadora')
    }

    class Clientes {
        +id INT (PK)
        +nome VARCHAR(150)
        +email VARCHAR(100)
        +telefone BIGINT UNSIGNED
        +cep_cliente INT UNSIGNED (FK)
        +n_residencial INT UNSIGNED
    }

    class Cargos {
        +id INT (PK)
        +descricao VARCHAR(200)
    }

    class Funcionarios {
        +id INT (PK)
        +cpf BIGINT UNSIGNED
        +nome VARCHAR(150)
        +id_cargo INT (FK)
        +telefone BIGINT UNSIGNED
        +cep_funcionario INT UNSIGNED (FK)
        +n_residencial INT UNSIGNED
    }

    class Fornecedores {
        +id INT (PK)
        +razao_social VARCHAR(150)
        +telefone BIGINT UNSIGNED
        +email VARCHAR(100)
        +cep_fornecedor INT UNSIGNED (FK)
        +n_comercial INT UNSIGNED
    }

    class Fornecedor_PF {
        +cpf BIGINT UNSIGNED (PK)
        +razao_social VARCHAR(150)
        +id_fornecedor INT (FK)
    }

    class Fornecedor_PJ {
        +cnpj BIGINT UNSIGNED (PK)
        +razao_social VARCHAR(60)
        +id_fornecedor INT (FK)
    }

    class Transportadoras {
        +id INT (PK)
        +cnpj BIGINT UNSIGNED
        +razao_social VARCHAR(150)
        +email VARCHAR(100)
        +telefone BIGINT UNSIGNED
        +cep_transportadora INT UNSIGNED (FK)
        +n_comercial INT UNSIGNED
    }

    class Produtos {
        +id INT (PK)
        +descricao VARCHAR(200)
        +preco DECIMAL(10,2)
    }

    class Produtos_fornecedores {
        +id_produto INT (FK)
        +id_fornecedor INT (FK)
    }

    class Formas_pagamento {
        +id INT (PK)
        +descricao VARCHAR(200)
    }

    class Vendas {
        +id INT (PK)
        +id_cliente INT (FK)
        +id_funcionario INT (FK)
        +data_hora DATETIME
        +id_pagamento INT (FK)
    }

    class Itens_venda {
        +id_venda INT (FK)
        +id_produto INT (FK)
    }

    class Estoque {
        +id_produto INT (FK)
        +quantidade INT UNSIGNED
        +data DATE
        +id_funcionario INT (FK)
    }

    Enderecos "1" -- "0..*" Clientes : cep_cliente
    Enderecos "1" -- "0..*" Funcionarios : cep_funcionario
    Enderecos "1" -- "0..*" Fornecedores : cep_fornecedor
    Enderecos "1" -- "0..*" Transportadoras : cep_transportadora
    Cargos "1" -- "0..*" Funcionarios : id_cargo
    Fornecedores "1" -- "0..1" Fornecedor_PF : id_fornecedor
    Fornecedores "1" -- "0..1" Fornecedor_PJ : id_fornecedor
    Produtos "1" -- "0..*" Produtos_fornecedores : id_produto
    Fornecedores "1" -- "0..*" Produtos_fornecedores : id_fornecedor
    Clientes "1" -- "0..*" Vendas : id_cliente
    Funcionarios "1" -- "0..*" Vendas : id_funcionario
    Formas_pagamento "1" -- "0..*" Vendas : id_pagamento
    Vendas "1" -- "0..*" Itens_venda : id_venda
    Produtos "1" -- "0..*" Itens_venda : id_produto
    Produtos "1" -- "0..1" Estoque : id_produto
    Funcionarios "1" -- "0..*" Estoque : id_funcionario
```

## Documentação da API (Deploy com Swagger)

https://quitandaria-restful-api-production.up.railway.app/swagger-ui/index.html#/cliente-controller/salvarCliente