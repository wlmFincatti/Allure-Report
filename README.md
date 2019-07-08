Allure Report
======================

O projeto faz o uso do framework Allure para reports de testes.

## Conteúdo

- [Tecnologias](https://github.com/LVCarnevalli/javaclean#tecnologias)
- [Pré-requisitos](https://github.com/LVCarnevalli/javaclean#pr%C3%A9-requisitos)
- [Como utilizar](https://github.com/LVCarnevalli/javaclean#como-utilizar)
- [Configuração do Report](https://github.com/LVCarnevalli/javaclean#aten%C3%A7%C3%A3o)
- [Créditos](https://github.com/LVCarnevalli/javaclean#cr%C3%A9ditos)


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

## Conf report

 o aruivo envimroment.properties voce confire oque será exibido no widget enviroment do report na tag overview, o mesmo deve estar dentro do diretorio allure-results.
 Ex.:
 Navegador = Firefox
Browser.Version = 67.0.4
Stand = Production
Product.Name = Allure Report Example

o arquivo categories.json serve para customizar o nomes das categorias, o mesmo deve estar dentro do diretorio allure-results.
```json
[
  {
    "name": "Step with fail",
    "matchedStatuses": [
      "failed"
    ]
  }
]
```
o arquivo allure.properties serve para definir qual o diretorio será salvo o resultado dos testes, adicionar links, issues, entre outros. O mesmo deve ficar dentro do diretorio /test/java/resources
```yaml=
allure.results.directory=allure-results
allure.link.mylink.pattern=https://example.org/mylink/{}
allure.link.issue.pattern=https://jiracloud.cit.com.br/browse/{}
allure.link.tms.pattern=https://example.org/tms/{}
```
## Créditos
