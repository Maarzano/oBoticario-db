<a id="readme-top"></a>
<!--
*** Obrigado por visitar este repositório de alterações no banco de dados da oBoticário! 💚
*** Este projeto foi desenvolvido com foco em melhorar a integridade, consistência
*** e escalabilidade dos dados da aplicação. Desde a adição de restrições importantes,
*** como UNIQUE e CHECK, até a normalização completa de tabelas, como Endereços e Vendas,
*** cada detalhe foi cuidadosamente ajustado para garantir um sistema robusto e confiável.
***
*** Se você tiver sugestões, dúvidas ou quiser contribuir, fique à vontade.
***
*** Obrigado novamente! Agora é hora de explorar um banco de dados mais limpo, seguro e eficiente! 🚀
-->

<!--LOGO -->
<br />
<div align="center">
<a href="https://github.com/github_username/repo_name">
    <img src="imagens/screenshot.png" alt="Logo" width="400" height="200">
  </a>

<h3 align="center">Banco de Dados oBoticario</h3>

  <p align="center">
    <br />
  </p>
</div>



<!-- Indice tabelas -->
<details>
  <summary>Sumario</summary>
  <ol>
    <li>
      <a href="#about-the-project">Sobre o projeto</a>
    </li>
    <li>
      <a href="#getting-started">Inicio</a>
    </li>
    <li>
      <a href="#getting-started">Uso</a>
    </li>
    <li>
      <a href="#getting-started">Historico de alterações</a>
    </li>
    <li>
      <a href="#getting-started">Integrantes</a>
    </li>
    <li>
      <a href="#getting-started">Licença</a>
    </li>
    <li>
      <a href="#getting-started">Contatos</a>
    </li>
  </ol>
</details>



<!-- Sobre o projeto -->
## Sobre o projeto


<h6>O banco de dados oBoticário foi desenvolvido com o objetivo de estruturar de forma sólida e eficiente todas as informações envolvidas na operação do sistema de vendas, distribuição e gestão da rede oBoticário. Ele abrange diversas áreas do negócio, como gerenciamento de funcionários, revendedores, clientes, produtos, pedidos, vendas, pagamentos, ausências e férias.

Ao longo do projeto, foram aplicadas melhorias significativas em sua modelagem e estrutura, incluindo:

Aplicação de restrições de integridade como UNIQUE, CHECK e FOREIGN KEY para garantir consistência e autenticidade dos dados.

Criação e normalização de tabelas, como a separação de endereços em uma tabela única e a criação da tabela Itens_Venda para representar vendas detalhadas.

Adequação de tipos de dados, como padronização de campos CHAR para CPF, CNPJ e telefone, e inclusão de DATETIME com validações de datas passadas.

Implementação de validações de negócios no próprio banco, como preços positivos, datas válidas e status controlados via restrições.

Organização e mapeamento das tabelas em packages como Models, Repositories, Services e Controllers para integração com APIs e geração de relatórios.

Este banco foi projetado para ser escalável, seguro e fácil de manter, oferecendo uma base sólida para o funcionamento do sistema e para futuras integrações com serviços externos, APIs REST e ferramentas analíticas.

<p align="right">(<a href="#readme-top">Voltar ao topo</a>)</p>



### Construido com

* [![Java][Java.dev]][Java-url]
* [![MySQL][MySQL.dev]][MySQL-url]
* [![Spring][Spring.dev]][Spring-url]
* [![Swagger][Swagger.dev]][Swagger-url]


<p align="right">(<a href="#readme-top">Voltar ao topo</a>)</p>



<!-- Inicio -->
## Inicio

Se você quer rodar este projeto na sua máquina, não se preocupe o processo é simples! Abaixo você encontra um passo a passo claro para configurar tudo no seu ambiente local sem complicações.

### Pre-requisitos

💻 Sistema Operacional
- Windows 10 ou Windows 11

🛠️ Ferramentas de Desenvolvimento
- Visual Studio Code – Versão mais recente

  - Extensão: Java Extension Pack (fornece suporte completo ao desenvolvimento em Java)

- Java JDK – Versão compatível com o Spring Boot (recomenda-se JDK 17 ou superior)

- Spring Boot – Framework principal do projeto (última versão estável)

- MySQL – Sistema gerenciador de banco de dados relacional

  - Recomendado: MySQL Workbench para administração visual

- Swagger – Para documentação e testes da API REST



### Instalação

- Link de instalação do [Visual Studio Code](https://code.visualstudio.com) <br>
- Link de instalação do [Mysql](https://www.mysql.com)<br>
- Link de instalação do [SpringBoot](https://spring.io/projects/spring-boot)<br>
- Link de instalação do [Swagger](https://swagger.io)<br>

`Para instalar a extensão do java no Visual Studio Code, siga as instruções abaixo: `
1. Copie o link e insira o link no navegador : vscode:extension/vscjava.vscode-java-pack
  ![alt text](imagens/image.png)

2. Apos inserir o link clique na opção `Abrir Visual Studio Code`:
  ![alt text](imagens/image-2.png)

3. Em seguida irá abrir uma tela contendo as informações do pacote e em seguida é só clicar em install:
  ![alt text](imagens/image-4.png)

4. Ou também podem instalar direto pelo VS Code, clicando no ícone de extensões e digitando o nome da extensão desejada, que no nosso caso é a Extension Pack for java:
  ![alt text](imagens/image-5.png)

<p align="right">(<a href="#readme-top">Voltar ao topo</a>)</p>

<!-- Uso -->
## Uso

Use this space to show useful examples of how a project can be used. Additional screenshots, code examples and demos work well in this space. You may also link to more resources.

_For more examples, please refer to the [Documentation](https://example.com)_

<p align="right">(<a href="#readme-top">Voltar ao topo</a>)</p>



<!-- Historico de alterações -->
## Historico de alterações

O arquivo contendo as alterações no banco de dados está localizado nesse link: [Documento das alterações realizadas](https://docs.google.com/document/d/1GrrrW64qXNJJj2tchUmBkU3zxB8GjEuI30qanbMdsig/edit?tab=t.0). 

Ele registra todas as modificações realizadas na estrutura do banco, como mudanças em tabelas, relacionamentos e índices, para garantir o desempenho e a integridade dos dados.



<p align="right">(<a href="#readme-top">Voltar ao topo</a>)</p>



<!-- INTEGRANTES -->
## Integrantes

Este projeto foi desenvolvido por um time dedicado e apaixonado por tecnologia. Cada integrante trouxe o seu conhecimento, experiência e criatividade, contribuindo de forma única em cada etapa do desenvolvimento.

- Arthur Araújo Marzano 

- Arthur Augusto Alves Araújo

- Bernardo Braga Gomes Carvalho

- Gabriel Arthur Ferreira De Jesus

- Isaac Adrian de Souza

- João Lucas da Costa bernardo

A colaboração entre as diferentes áreas foi essencial para transformar ideias em soluções funcionais. Sem o esforço coletivo, este projeto simplesmente não teria saído do papel. 

### Desenvolvedores:

<a href="https://github.com/Maarzano/oBoticario-db/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=Maarzano/oBoticario-db" />
</a>

<p align="right">(<a href="#readme-top">Voltar ao topo</a>)</p>

<!-- LICENÇA -->
## Licença

Este projeto está licenciado sob os termos da Licença `MIT`.

A Licença `MIT` é uma licença de software permissiva que permite ampla reutilização do código, incluindo uso comercial, modificação, distribuição e sublicenciamento, desde que os devidos créditos aos autores originais sejam mantidos.

Essa escolha visa promover a colaboração, a reutilização do código e o desenvolvimento de soluções abertas e acessíveis.

Para mais informações, consulte o arquivo `LICENSE` incluído neste repositório.

<p align="right">(<a href="#readme-top">Voltar ao topo</a>)</p>



<!-- CONTATOS -->
## Contatos

Gabriel Arthur - [@gbriel.js](https://www.instagram.com/gbriel.js/) - gbl48287@gmail.com

Arthur Araújo - [@marzan.0](https://www.instagram.com/marzan.0/)

Arthur Augusto - [@arthur__alves06](https://www.instagram.com/arthur__alves06/)

Bernardo Braga - [@bragaxz9](https://www.instagram.com/bragaxz9/)

Isaac Adrian - [@isaac_souzzz](https://www.instagram.com/isaac_souzzz/)

João Lucas - [@joaolucasgym](https://www.instagram.com/joaolucasgym/)

Project Link: [https://github.com/Maarzano/oBoticario-db](https://github.com/Maarzano/oBoticario-db)

<p align="right">(<a href="#readme-top">Voltar ao topo</a>)</p>




<!-- LINKS & IMAGENS -->
[contributors-shield]: https://img.shields.io/github/contributors/github_username/repo_name.svg?style=for-the-badge
[contributors-url]: https://github.com/github_username/repo_name/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/github_username/repo_name.svg?style=for-the-badge
[forks-url]: https://github.com/github_username/repo_name/network/members
[stars-shield]: https://img.shields.io/github/stars/github_username/repo_name.svg?style=for-the-badge
[stars-url]: https://github.com/github_username/repo_name/stargazers
[issues-shield]: https://img.shields.io/github/issues/github_username/repo_name.svg?style=for-the-badge
[issues-url]: https://github.com/github_username/repo_name/issues
[license-shield]: https://img.shields.io/github/license/github_username/repo_name.svg?style=for-the-badge
[license-url]: https://github.com/github_username/repo_name/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/linkedin_username
[product-screenshot]: images/screenshot.png

[Java.dev]: https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
[Java-url]: https://www.java.com/pt-BR/

[Swagger.dev]: https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white
[Swagger-url]: https://swagger.io/

[MySQL.dev]: https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white
[MySQL-url]: https://www.mysql.com/

[Spring.dev]: https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white
[Spring-url]: https://spring.io/projects/spring-boot