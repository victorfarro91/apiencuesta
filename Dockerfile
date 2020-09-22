FROM openjdk:8-jdk-alpine
LABEL maintainer="devvictor07@gmail.com"
WORKDIR /workspace
ADD target/api*.jar app.jar

#ENV userPoolId="us-east-1_tDqR3GQmM"
#ENV clientId="1pqtlnrh70b8airu9oq0s2779"
#ENV AWS_COGNITO_REGION="us-east-1"
#ENV demo="hola"
#ENV AWS_ACCESS_KEY_ID="AKIAWFVD32KHTUIYD6ET"
#ENV AWS_SECRET_ACCESS_KEY="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"

ENTRYPOINT exec java -Djava.security.egd=file:/dev/./urandom -jar /workspace/app.jar
EXPOSE 8080