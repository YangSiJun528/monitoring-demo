FROM amazoncorretto:21-alpine-jdk

# 작업 디렉토리 설정
WORKDIR /app

# 이미 빌드된 JAR 복사
COPY build/libs/monitoring-demo.jar app.jar

# 실행
ENTRYPOINT ["java", "-jar", "app.jar"]
