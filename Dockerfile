FROM amazoncorretto:21-alpine-jdk

# 작업 디렉토리 설정
WORKDIR /app

# 이미 빌드된 JAR 복사
COPY build/libs/monitoring-demo.jar app.jar
COPY opt/app/pyroscope-agent-2.1.2.jar /app/pyroscope-agent.jar

# 실행
ENTRYPOINT ["java", "-javaagent:/app/pyroscope-agent.jar", "-jar", "app.jar"]

# Pyroscope Ref:
# - https://grafana.com/docs/pyroscope/latest/configure-client/language-sdks/java/
# - https://github.com/grafana/pyroscope/tree/main/examples/language-sdk-instrumentation/java/fib
