# Imagem base
FROM openjdk:17-jdk-alpine
#
## Diretório de trabalho
#WORKDIR /app
#
## Copia o arquivo JAR para o diretório de trabalho
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} app.jar
#
## Comando para iniciar o aplicativo Spring Boot
#ENTRYPOINT ["java","-jar","/app.jar"]
FROM postgres

# Defina as variáveis de ambiente LANG e LC_*
ENV LANG pt_BR.utf8
ENV LC_ALL pt_BR.utf8
