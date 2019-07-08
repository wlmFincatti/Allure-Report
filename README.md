Allure Report
======================

O projeto faz o uso do framework Allure para reports de testes.

## Conteúdo

- [Referência](https://github.com/LVCarnevalli/javaclean#refer%C3%AAncia)
- [Tecnologias](https://github.com/LVCarnevalli/javaclean#tecnologias)
- [Pré-requisitos](https://github.com/LVCarnevalli/javaclean#pr%C3%A9-requisitos)
- [Como utilizar](https://github.com/LVCarnevalli/javaclean#como-utilizar)
- [Atenção](https://github.com/LVCarnevalli/javaclean#aten%C3%A7%C3%A3o)
- [Créditos](https://github.com/LVCarnevalli/javaclean#cr%C3%A9ditos)
- [Licença](https://github.com/LVCarnevalli/javaclean#licen%C3%A7a)

## Referência

<p align="center">
  <img src="https://github.com/LVCarnevalli/javaclean/blob/master/pyramid_test.jpg?raw=true" width="400 "align="center" />
</p>

O projeto JAVA Clean têm como objetivo demonstrar como é simples trabalhar com toggles, clean architecture (não o by the book) e testes possibilitando o trunk based development.

A pirâmide de testes implementada nesse projeto têm como referência o documento [Microservice Testing](https://martinfowler.com/articles/microservice-testing/) com algumas adaptações. Basicamente a implementação têm o seguinte princípio:

>**Unitário**: Testa isoladamente as classes, o objetivo desse teste é validar se a regra da classe está funcionando corretamente sem precisar subir qualquer contexto de framework ou integrações.

>**Integração**: Teste que valida a integração, necessita que simule um contexto externo para testar a regra da classe, por exemplo, bancos em memória e contextos de um framework.

>**Componente**: Testa as regras de negócio da aplicação como um todo, mockando todas as depedências. Geralmente são testes que fazem um request e dado os mocks esperam por uma resposta específica.

>**Performance**: Teste que valida a performance da aplicação como um todo, mockando todas as depedências. Se algo aumentar o tempo de resposta é uma camada que pegaria o problema, esse teste não têm como objetivo validar a performance da integração.

>**Segurança**: Teste que vai verificar falhas de segurança que podem ser exploradas através do contrato da API. Em alguns casos pode até ser considerado um teste de contrato pois o contrato da API será validado de diversas formas nesse teste.

Os testes de E2E não se aplica a esse projeto, mais pra frente pretendemos colocar um exemplo de uma aplicação frontend integrando com o serviço, e todo o fluxo testado com o E2E. Esse projeto têm como objetivo mostrar os testes sendo executados de maneira isoladas em uma aplicação.

## Tecnologias
- [Maven](https://maven.apache.org/)
- [Cucumber](https://cucumber.io/)
- [Allure Test Report](http://allure.qatools.ru/)

## Pré-requisitos
- JDK 8
- Maven
- Docker
- Docker Compose 3
- Allure Report

## Como utilizar

#### Instalação do Allure

Para instalar o Allure Command Line basta executar:
npm install -g allure-commandline

ou

Para instalação do Allure siga os passos descritos na documentação do site abaixo:
https://docs.qameta.io/allure/

Obs.: Para que a instalação seja feita pela primeira opção é obrigatório ter instalado o Nodejs2.

#### Configuração

##### Maven Dependência
```xml
  <dependency>
            <groupId>io.qameta.allure</groupId>
            <artifactId>allure-cucumber4-jvm</artifactId>
            <version>${VERSAO}</version>
            <scope>test</scope>
        </dependency>
``` 
##### Maven Plugin
```xml
<plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>2.20</version>
                <configuration>
                    <testFailureIgnore>true</testFailureIgnore>
                    <argLine>
                        -javaagent:"${settings.localRepository}/org/aspectj/aspectjweaver/${aspectj.version}/aspectjweaver-${aspectj.version}.jar"
                        -Dcucumber.options="--plugin io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"
                    </argLine>
                </configuration>
                <dependencies>
                    <dependency>
                        <groupId>org.aspectj</groupId>
                        <artifactId>aspectjweaver</artifactId>
                        <version>${aspectj.version}</version>
                    </dependency>
                </dependencies>
            </plugin>
``` 

#### Executar teste de componente da aplicação
```shell
mvn clean verify allureReportExample/pom.xml
```
Por padrão a aplicação cria a pasta allure-results contendo os resultados dos testes realizados.

#### Gerar Reports dos testes

No diretorio onde se encontra a pasta allure-results exetura os comando abaixo:

- para gerar relatorio estatico
```shell
allure generate allure-results --clean -o allure-report
```

- para gerar relatorio em um servidor local
```shell
allure serve allure-results/
```

- Para gerar Report dinamicamente

```shell
Export PWD="local do seu diretorio allure-results"
docker-compose up -d allure
```
## Créditos
