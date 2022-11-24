# Aplicação Carlos Rosa Barbershop REST API (Spring Boot)
O serviço tem como objetivo possiblitar que o cliente da barbearia Carlos Rosa possa fazer agendamento, e que o dono da barbearia possa administrar os salão pela aplicação


## Instalação
- Ter IDE de sua preferência que funcione Spring Boot, foi utilizado a IDE https://spring.io/tools;
- Instalar o LOMBOK em sua IDE https://projectlombok.org/download, para instalá-lo é só executá-lo com sua IDE aberta e prosseguir até finalizar;
- Caso utilizar o projeto localmente, necessário instalar o banco de dados https://github.com/DaniloAlmeidaSantos/Barbershop_DB
- Para realizar requisições para a API foi utilizado o POSTMAN, mas pode ser utilizado a ferramenta de sua prefência

## Modos de usar
- Caso tenha alguma aplicação na porta 8080, altere a porta da aplicação para alguma qualquer no arquivo application.properties na pasta src/main/resources parâmetro server.port=8080
- Não é utilizado autenticação ou tokens para fazer requisições para a API
- Caso utilizar o banco de dados local, deve ser alterado no código as credenciais de acesso ao banco de dados no  arquivo **src/main/java/com/babershopcarlosrosa/repository/config/ConnectionRepositoryConfig.java**
