Allure Report
======================

O projeto faz o uso do framework Allure para reports de testes, nele você consegue verificar quais testes falharam, quais estão quebradros, foram pulados e os que passaram.

## Conteúdo

- [Tecnologias](https://github.com/wlmFincatti/allure-report#tecnologias)
- [Pré-requisitos](https://github.com/wlmFincatti/allure-report#pr%C3%A9-requisitos)
- [Como utilizar](https://github.com/wlmFincatti/allure-report#como-utilizar)
- [Configuração do Report](https://github.com/wlmFincatti/allure-report#conf-report)
- [Créditos](https://github.com/wlmFincatti/allure-report#cr%C3%A9ditos)


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

:::info
Obs.:</b> Para que a instalação seja feita pela primeira opção é obrigatório ter instalado o Nodejs2.
:::


#### Executar teste de componente da aplicação
```shell
mvn clean verify allureReportExample/pom.xml
```
Por padrão a aplicação cria a pasta allure-results contendo os resultados dos testes realizados.

#### Gerar Reports dos testes

No diretorio onde se encontra a pasta allure-results executar os comando abaixo:

- <strong style="color:blue">Para gerar Report estático</strong>
```shell
allure generate allure-results --clean -o allure-report
```

- <strong style="color:blue">Para gerar Report em um servidor local</strong>
```shell
allure serve allure-results/
```

- <strong style="color:blue">Para gerar Report dinamicamente</strong>

```shell
Export PWD="local do seu diretorio allure-results"
docker-compose up -d allure
```

## Conf report

O arquivo environment.properties você configura oque será exibido no widget environment do report na tag overview, o mesmo deve estar dentro do diretório allure-results.

```yaml=
Navegador = Firefox
Browser.Version = 67.0.4
Stand = Production
Product.Name = Allure Report Example
```

O arquivo categories.json serve para customizar o nome das categorias, o mesmo deve estar dentro do diretório allure-results.

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
O arquivo allure.properties serve para definir qual será o path para o allure-results, adicionar links, issues, entre outros. O mesmo deve ficar dentro do diretório /test/java/resources

```yaml=
allure.results.directory=allure-results
allure.link.mylink.pattern=https://example.org/mylink/{}
allure.link.issue.pattern=https://jiracloud.cit.com.br/browse/{}
allure.link.tms.pattern=https://example.org/tms/{}
```
## Créditos

