***Criação de um sistema de lista de produtos utilizando Spring <br/>***
<br/>
Este projeto envolve o desenvolvimento de um sistema de gestão de produtos com funcionalidades de CRUD (Create, Read, Update, Delete). Para isso, utilizei uma arquitetura baseada em APIs REST, empregando as tecnologias Spring REST, JPA/Hibernate e Spring Data JPA para persistência de dados. O sistema foi estruturado de acordo com boas práticas de desenvolvimento, seguindo os padrões Controller-Service-Repository e aplicando DTOs (Data Transfer Objects) para comunicação entre as camadas.
<br/>
Além disso, o projeto contempla a criação de consultas SQL personalizadas no Spring Data JPA e implementa relacionamentos N-N (muitos para muitos), permitindo uma gestão eficiente e flexível dos dados. Durante o desenvolvimento, busquei praticar a organização e a estruturação do código, garantindo uma arquitetura escalável e de fácil manutenção.
<br/>
<br/>***Realização do projeto:***
<br/>
Entramos no Spring Initialzr para a criação do Projeto, nossas escolhas dentro do Spring initialzr foram (Java versão 17, Maven, 3.4.2) alem das dependencias (Spring Web, H2 Database, Spring Data JPA e PostgreSQL Driver), criamos o arquivo dslist, no qual foi aberto dentro do SpringToolSuite4 em import Projeto Maven. Realizamos a criação do projeto dentro do GitHub e realizamos a conexão entre a pasta do projeto e o projeto dentro do Git.
<br/>
Codigos do GitBash:
<br/>
git init
<br/>
git commit -m "Project Created"
<br/>
git remote add origin "codigo que o github gera"
<br/>
git push -u origin main 
<br/>
O projeto é consistido com 6 pastas (Controllers, Services, DTO, Entities, Projection e Repositories), abaixo iremos falar oque cada pasta contem de classes e interfaces, alem de explicar um pouco como cada classe ou interface trabalha.<br/>
***Package Controllers (gerencia a parte de jogos de um site):***
<br/>***GameController:***
<br/>A ideia é que o controlador interaja com o serviço GameService, que, por sua vez, acessa a base de dados, e prepara as informações para serem enviadas ao frontend.
<br/>***GameListController:***
<br/>Esses métodos fazem interações com os serviços gameListService e gameService para realizar as operações sobre as listas e jogos.


![Captura de tela 2025-01-27 123205](https://github.com/user-attachments/assets/62329ffa-656e-470e-a40a-b835cb93501a)

<br/>***Package DSLIST:***
<br/>***DslistApplication:***
<br/>Este código define a classe principal da aplicação Spring Boot chamada DslistApplication. Quando você executa a aplicação, o método main é chamado e a aplicação é inicializada através do método SpringApplication.run().

<br/>***Package DTO:
<br/>GameDTO:***
<br/>O GameDTO é uma forma simplificada de representar os dados de um jogo e é usado para transferir informações de maneira eficiente e segura entre diferentes partes da aplicação, especialmente em APIs REST. Ele facilita a conversão entre entidades e a camada de apresentação (como a web ou o frontend).
<br/>***GameListDTO:***
<br/>Esse DTO permite a transferência de dados de forma simplificada e mais controlada, garantindo que a camada de apresentação não precise lidar com a complexidade da entidade completa (como relacionamentos com outras entidades ou dados desnecessários).
<br/>***GameMinDTO:***
<br/> O GameMinDTO é um DTO simplificado que contém apenas os dados essenciais de um jogo: id, title, year, imgUrl, e shortDescription.
<br/>***ReplacementDTO:***
***O ReplacementDTO é um objeto de transferência de dados simples que contém dois campos (sourceIndex: O índice do item que será movido) e (destinationIndex: O índice onde o item será colocado).

<br/>***Package Entities:
<br/>Game:***
<br/>A classe Game é uma entidade JPA que representa um jogo e mapeia uma tabela chamada tb_game no banco de dados. 
<br/>***GameList:***
<br/>A classe GameList é uma entidade JPA que representa uma lista de jogos no sistema.
<br/>***Belonging:***
<br/>A classe Belonging representa uma associação entre jogos e listas de jogos. Essa classe é essencial para modelar a relação muitos-para-muitos entre jogos e listas de jogos. Um jogo pode estar presente em várias listas, e uma lista pode conter vários jogos. Além disso, ela guarda a posição do jogo em cada lista, o que permite uma organização específica de jogos dentro de cada lista.
<br/>***BelongingPK:***       
<br/>A classe BelongingPK é a chave composta usada na entidade Belonging. A classe BelongingPK é utilizada na entidade Belonging para formar a chave composta que conecta um jogo a uma lista. A posição (position) do jogo dentro da lista é armazenada separadamente, mas a associação entre o jogo e a lista é representada pela chave composta.


![Captura de tela 2025-01-28 124700](https://github.com/user-attachments/assets/8d2beb5e-fb38-4b3d-ac0d-a752a14bef92)

<br/>***Package Projections:
<br/>GameMinProjection:***
<br/>Esta interface GameMinProjection seria usada junto com um repositório no Spring Data JPA para buscar apenas os dados específicos que você precisa, sem precisar carregar toda a entidade Game.

<br/>***Package Repositories:
<br/>GameListRepository***
<br/>É uma interface GameListRepository que estende JpaRepository no Spring Data JPA. Essa interface contém um método personalizado para atualizar a posição de um jogo dentro de uma lista específica.
<br/>***GameRepository***
<br/>Esse repositório e método personalizado são úteis para recuperar jogos de uma lista específica e garantir que você recupere as informações de maneira eficiente, usando uma consulta SQL nativa e uma projeção para simplificar o resultado.


<br/>***Package Services:
<br/>GameService***
<br/>O GameService atua como intermediário entre o controlador (provavelmente responsável por expor as APIs) e o repositório, onde contém toda a lógica de negócios necessária para acessar dados dos jogos no banco de dados. Ele usa os DTOs (Data Transfer Objects) para representar os jogos de forma otimizada para as necessidades de visualização, evitando retornar entidades completas com dados desnecessários.
<br/>***GameListService***
<br/>O GameListService lida com as operações relacionadas às listas de jogos, como obter todas as listas de jogos (findAll), buscar uma lista por id (findById), e permitir a reordenação de jogos dentro de uma lista (move). Ele interage com os repositórios para acessar os dados e usa DTOs para transferir apenas as informações necessárias de maneira eficiente.

<br/>***Quais pacotes de Java criamos primeiro e por quê***<br/>
![Captura de tela 2025-01-28 132738](https://github.com/user-attachments/assets/d3723411-28a6-41c8-9291-fa8aa4bc0b0a)

<br/>Para finalizar temos mais dois códigos que realizamos dentro do projeto, mas, fora da pasta "src/main/java":
<br/>Implementamos um plugin lib maven dentro do arquivo pom.xml.
<br/>***Dentro da pasta  "src/main/resources" criamos:
<br/>application.properties:***
<br/>Essas configurações ajudam a controlar o ambiente de execução, o comportamento do acesso ao banco de dados e as políticas de segurança relacionadas ao CORS.
<br/>***application-dev.properties:***
<br/>Esse trecho de configuração prepara o Spring Boot para usar o banco de dados PostgreSQL e configura o Hibernate para não modificar automaticamente o esquema do banco de dados.
<br/>***application-prod.properties:***
<br/>Esse trecho de configuração prepara o Spring Boot para usar o banco de dados PostgreSQL e configura o Hibernate para não modificar automaticamente o esquema do banco de dados, uma abordagem geralmente adotada em produção. 
<br/>***application-test.properties:***
<br/>Esse trecho de código de configuração refere-se ao uso de um banco de dados H2 em memória no ambiente de desenvolvimento (ou até testes). O H2 é um banco de dados leve e rápido, usado principalmente para fins de teste e desenvolvimento, pois ele roda totalmente na memória e não persiste os dados após o término da aplicação.
<br/>***Import SQL:***
<br/>O código SQL fornecido serve para inserir dados nas tabelas do banco de dados de um projeto de lista de jogos. 

<br/>Testes unitarios dentro do postman para mudança de posição do jogo na lista:
<br/>Iremos mudar o game que está na posição 2 da lista 1 e que tem seu ID registrado como 3 para a posição 3 da tabela.
<br/>Tabela atual:
<br/>![Captura de tela 2025-01-28 135245](https://github.com/user-attachments/assets/14f952e2-4c79-4522-a410-f6cf45ee1f18)
<br/>Upadate da posição do jogo no Postman:
<br/>![image](https://github.com/user-attachments/assets/9ce01722-aa4f-4ace-9a6d-c5dca68fa6dd)
<br/>Tabela Atualizada:
<br/>![Captura de tela 2025-01-28 135704](https://github.com/user-attachments/assets/3121b9c7-8b98-49dc-b27d-4bf47deaecce)
<br/>Veja que ao realizar o pedido de atualização dentro do postman, ja temos uma mudança da posição do game de ID 3, se posicionado na posivação 3.

<br/> Agradeço a todos que estão lendo este projeto. Este foi o meu primeiro README e espero que tenham gostado da explicação. Tentei deixá-la bem técnica, sem muitas explicações excessivas, para que pessoas que também estão começando consigam entender o que cada parte faz, sem a necessidade de ver o código.

