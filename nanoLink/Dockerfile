FROM eclipse-temurin:21-jre-alpine

# Create a non-privileged user that the app will run under.
# See https://docs.docker.com/go/dockerfile-user-best-practices/
ARG UID=10001
RUN adduser \
    --disabled-password \
    --gecos "" \
    --home "/nonexistent" \
    --shell "/sbin/nologin" \
    --no-create-home \
    --uid "${UID}" \
    appuser

# add curl for healthcheck
RUN apk --no-cache add curl

USER appuser

ARG APP_VERSION=latest

COPY LICENSE nanoLink/target/nanoLink-${APP_VERSION}.jar /app/

WORKDIR /app

HEALTHCHECK --start-period=30s CMD curl --fail http://localhost:8080/actuator/health/liveness || exit 1

EXPOSE 8080

ENV APP_VERSION=${APP_VERSION}

ENTRYPOINT [ "sh", "-c", "java -jar nanoLink-$APP_VERSION.jar" ]
