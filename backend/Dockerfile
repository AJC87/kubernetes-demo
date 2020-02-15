FROM gradle:6.1.1-jdk13 AS builder

WORKDIR /project

COPY --chown=gradle:gradle . /

RUN gradle assemble --no-daemon

FROM adoptopenjdk:13.0.2_8-jre-openj9-0.18.0-bionic

WORKDIR /project

COPY --from=builder /build/libs/*.jar /project/app.jar

EXPOSE 8080

CMD ["java", "-jar", "/project/app.jar"]
