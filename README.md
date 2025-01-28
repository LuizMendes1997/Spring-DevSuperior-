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

<br/>***Package DTO:***
<br/>***GameDTO:***
<br/>O GameDTO é uma forma simplificada de representar os dados de um jogo e é usado para transferir informações de maneira eficiente e segura entre diferentes partes da aplicação, especialmente em APIs REST. Ele facilita a conversão entre entidades e a camada de apresentação (como a web ou o frontend).
<br/>***GameListDTO:***
<br/>Esse DTO permite a transferência de dados de forma simplificada e mais controlada, garantindo que a camada de apresentação não precise lidar com a complexidade da entidade completa (como relacionamentos com outras entidades ou dados desnecessários).
<br/>***GameMinDTO:***
<br/> O GameMinDTO é um DTO simplificado que contém apenas os dados essenciais de um jogo: id, title, year, imgUrl, e shortDescription.
<br/>***ReplacementDTO:***
***O ReplacementDTO é um objeto de transferência de dados simples que contém dois campos (sourceIndex: O índice do item que será movido) e (destinationIndex: O índice onde o item será colocado).

<br/>***Entities:
<br/>Game:***
<br/>A classe Game é uma entidade JPA que representa um jogo e mapeia uma tabela chamada tb_game no banco de dados. 
<br/>***GameList:***
<br/>A classe GameList é uma entidade JPA que representa uma lista de jogos no sistema.
<br/>***Belonging:***
<br/>A classe Belonging representa uma associação entre jogos e listas de jogos. Essa classe é essencial para modelar a relação muitos-para-muitos entre jogos e listas de jogos. Um jogo pode estar presente em várias listas, e uma lista pode conter vários jogos. Além disso, ela guarda a posição do jogo em cada lista, o que permite uma organização específica de jogos dentro de cada lista.
<br/>***BelongingPK:***       
<br/>A classe BelongingPK é a chave composta usada na entidade Belonging. A classe BelongingPK é utilizada na entidade Belonging para formar a chave composta que conecta um jogo a uma lista. A posição (position) do jogo dentro da lista é armazenada separadamente, mas a associação entre o jogo e a lista é representada pela chave composta.

