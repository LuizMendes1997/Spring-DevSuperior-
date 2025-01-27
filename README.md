Criação de um sistema de lista de produtos utilizando Spring
Este projeto envolve o desenvolvimento de um sistema de gestão de produtos com funcionalidades de CRUD (Create, Read, Update, Delete). Para isso, utilizei uma arquitetura baseada em APIs REST, empregando as tecnologias Spring REST, JPA/Hibernate e Spring Data JPA para persistência de dados. O sistema foi estruturado de acordo com boas práticas de desenvolvimento, seguindo os padrões Controller-Service-Repository e aplicando DTOs (Data Transfer Objects) para comunicação entre as camadas.

Além disso, o projeto contempla a criação de consultas SQL personalizadas no Spring Data JPA e implementa relacionamentos N-N (muitos para muitos), permitindo uma gestão eficiente e flexível dos dados. Durante o desenvolvimento, busquei praticar a organização e a estruturação do código, garantindo uma arquitetura escalável e de fácil manutenção.

Realização do projeto:
Entramos no Spring Initialzr para a criação do Projeto, nossas escolhas dentro do Spring initialzr foram (Java versão 17, Maven, 3.4.2) alem das dependencias (Spring Web, H2 Database, Spring Data JPA e PostgreSQL Driver), criamos o arquivo dslist, no qual foi aberto dentro do SpringToolSuite4 em import Projeto Maven. Realizamos a criação do projeto dentro do GitHub e realizamos a conexão entre a pasta do projeto e o projeto dentro do Git.
Codigos do GitBash:
git init
git commit -m "Project Created"
git remote add origin "codigo que o git gera"
git push -u origin main 

O projeto é consistido com 6 pastas (Controllers, Services, DTO, Entities, Projection e Repositories), abaixo iremos falar oque cada pasta contem de classes e interfaces, alem de explicar um pouco como cada classe ou interface trabalha.
Controllers (gerencia a parte de jogos de um site):
GameController:
A ideia é que o controlador interaja com o serviço GameService, que, por sua vez, acessa a base de dados, e prepara as informações para serem enviadas ao frontend.
GameListController:
Esses métodos fazem interações com os serviços gameListService e gameService para realizar as operações sobre as listas e jogos.


![Captura de tela 2025-01-27 123205](https://github.com/user-attachments/assets/62329ffa-656e-470e-a40a-b835cb93501a)
