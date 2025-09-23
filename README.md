# Docker Compose로 실행 방법

1. 빌드
```bash
./gradlew clean build
```

2. docker-compose 띄우기
```bash
docker-compose up --build -d
```

3. 테스트
```bash
curl http://localhost:8080/actuator/health

curl http://localhost:8080/actuator/info

curl http://localhost:8080/actuator/beans

curl http://localhost:8080/actuator/caches
```

4. app만 재빌드 후 생성 다시 docker-compose에 연결

```bash
./gradlew clean build
docker-compose up --build -d app
```

5. 확인
- Prometheus: http://localhost:9090
- Spring metrics: http://localhost:8080/actuator/prometheus
- DB metrics: http://localhost:9187/metrics


# 관련 자료

- https://github.com/prometheus-community/postgres_exporter

### postgresql.conf
- https://www.postgresql.org/docs/current/config-setting.html#CONFIG-SETTING-CONFIGURATION-FILE
- https://berasix.tistory.com/entry/PostgreSQL-%EC%84%A4%EC%B9%98%EC%99%80-%EC%9A%B4%EC%98%81-2-postgresqlconf-%EC%84%A4%EC%A0%95%ED%95%98%EA%B8%B0
