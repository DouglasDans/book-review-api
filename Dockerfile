FROM gradle:8.13.0-jdk23

COPY . .

RUN gradle build

ENV JAR_FILE=build/libs/*.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","app.jar"]

