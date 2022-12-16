# partimos da imagem docker abaixo (contém o JAVA 11)
FROM adoptopenjdk/openjdk11:alpine

# atualizamos os repositórios e dependências da imagem acima
RUN apk update && apk add bash

# vamos criar uma pasta (/opt/app) na raiz do container
RUN mkdir -p /opt/app

#definindo a variável de ambiente PROJECT_HOME com o valor /opt/app
ENV PROJECT_HOME /opt/app

# copia o jar da nossa máquina para dentro da imagem docker
COPY target/app.jar $PROJECT_HOME/app.jar

# dizemos que a pasta padrão é a /opt/app
WORKDIR $PROJECT_HOME

# vamos expor a porta 8080
EXPOSE 8080

CMD ["java", "-Dspring.profiles.active=prd", "-jar" ,"./app.jar"]
#CMD ["java", "-jar" ,"./app.jar"]
# java -jar ./app.jar