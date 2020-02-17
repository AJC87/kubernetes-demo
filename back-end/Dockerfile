FROM gradle:6.1.1-jdk13 AS builder

COPY --chown=gradle:gradle . /project

WORKDIR /project

RUN ls -la

RUN gradle assemble --no-daemon

FROM adoptopenjdk:13.0.2_8-jre-openj9-0.18.0-bionic

COPY --from=builder /project/build/libs/*.jar /project/app.jar

WORKDIR /project

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
