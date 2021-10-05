FROM java:8
WORKDIR /app
COPY target/app.jar /app/app.jar
RUN chmod +x /app/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/app.jar"]
EXPOSE 80
