# logstorage
Teste de candidatos para vagas de desenvolvedores para Cingo (www.cingo.com.br).

# Pré-requisitos para execução
1. Maven 3.6.3
2. Java 1.8
3. Apache Tomcat 9.
4. PostgreSQL 13

# Executar projeto
1. Baixar o projeto para disco local.
2. Ajustar os dados <local_path>\logstorage\src\main\resources\META-INF\persistence.xml e alterar para os dados de conexão para seu banco de dados local.
3. Acessar a pasta do projeto com cmd ou similar e executar a linha de comando "mvn clean install"
4. Acessar a pasta target criada na pasta do projeto e fazer o deploy do .war gerado na sua instalação local do Apache Tomcat 9
5. Para testar se a aplicação subiu corretamente acesse http://localhost:8080/logstore-0.0.1-SNAPSHOT/log e verifique se a resposta é um JSON similar ao abaixo: 

[{
  "id" : 2221,
  "content" : "org.hibernate.tool.hbm2ddl.TableMetadata: <init> foreign keys: []",
  "occurrences" : 299
}, {
  "id" : 2222,
  "content" : "org.hibernate.tool.hbm2ddl.TableMetadata: <init> indexes: [primary]",
  "occurrences" : 296
}]

# Alterações feitas...

Para rodar o projeto com o Tomcat 9 em uma máquina com o OS Linux Mint 20.1 Ulyssa.

Foi incluído a dependência no Maven [jakarta.xml.bind-api] para remover o erro de servlet no deploy.
Alterado no front(Arquivo HTML e JavaScript) o caminho, e pronto front já estava consumindo a API como esperado.

Alguns pacotes descrito abaixo foram criados para a melhor divisão da API(MVC).
1. package com.cingo.logstore.resource.dto
2. package com.cingo.logstore.resource.mapper
3. package com.cingo.logstore.services
4. package com.cingo.logstore.services.exceptions

# DTO- Data Transfer Object
Foi criado duas classes dentro do pacote DTO, LogRequestDTO e LogResponseDTO.
Essas classes servem como proteção de dados para API, já que se exibir a entidade diretamente pode ser entrada para um usuário malicioso.
Elas servem para caso algo da entidade for alterado e DTO terá que ser revisto para se adequar sem risco de expor dados.
* LogRequestDTO - É uma classe que recebe os dados vindo do usuário que vai consumir a API, então deve receber somente o necessário que é somente o dado de entrada (content).
O ID e occurrences são gerados pela própria API.
* LogResponseDTO - É a classe que devolve os dados da API, escolhendo somente os dados necessários sem correr riscos de vazar algo.
Nesse caso foi usado todos os atributos da entidade Log, já que todos eles são necessários para o usuário.


# Mapper.
* LogMapper - Criado para que possa converter os DTOs em entidades, e as entidades ou suas listas em DTOs.

# Service
Comum em API MVC o service deve conter a lógica da regra de negócio.
* LogService - Nesse caso além de chamar o repository para salvar, alterar e deletar dados, serve para chamar as exceções de quando haver algum erro.

# Exceptions
É a classe que trata os erros em tempo de execução.
* ResourceNotFoundException - É chamada caso o usuário tente acessar um recurso da API que não existe, expl: Usuário busca um ID que não existe.
* DataBaseException - É chamado caso o usuário tente salvar ou alterar algo do Banco de Dados incorretamente, expl: Passar Json inválido ao salvar novo Log.






































