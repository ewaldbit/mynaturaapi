<h2>Digital Innovation: GFT Start #2 Java - Desenvolvendo um sistema de gestão de clientes em API REST com Spring Boot</h2>

Desenvolvimento de um pequeno sistema para gestão de clientes para uma consultora de produtos de beleza através de uma API REST, criada com o Spring Boot.

Os seguintes serviços backends foram desenvolvidos:

* Cadastro de Clientes com seus devidos endereços e telefones;
* Busca e listagem de todos os clientes com todas as suas informações; 
* Busca de cliente pelo ID cadastrado no Banco de Dados;
* Exclusão do registro do cliente e os seus dados sendo feito uma busca de verificação por ID;
* Atualização de todos os dados do cliente buscado por ID.
* Teste Unitário.

Para executar o projeto no terminal, digite o seguinte comando:

```shell script
mvn spring-boot:run 
```

Após executar o comando acima, basta apenas abrir o seguinte endereço e visualizar a execução do projeto:

```
http://localhost:8080/api/v1/cliente
```

O sistema também está disponível na nuvem para testes.

```
https://mynaturaapi.herokuapp.com/api/v1/client
```