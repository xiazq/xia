FROM java:8
VOLUME /tmp
ADD  docker-demo2.jar app.jar
COPY target/*.jar app.jar
RUN bash -c 'touch ./app.jar'
ENTRYPOINT  ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]
#ENTRYPOINT  ["java", "-jar", "app.jar", "--spring.profiles.active=prod"]
