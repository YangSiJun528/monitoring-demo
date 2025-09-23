## 파일 구조

### 애플리케이션 서버
```
/
├── docker-compose-app.yml
├── postgresql.conf
├── Dockerfile
├── build.gradle
└── src/main/resources/application.properties (매트릭 공개 및 기타 설정)
```

### 모니터링 서버
```
/monitoring-server/
├── docker-compose-monitoring.yml
└── prometheus.yml
```

## 실행 순서

### 1. 애플리케이션 서버 실행
```bash
cd 프로젝트위치/
./gradlew clean build
docker-compose -f docker-compose-app.yml up --build -d
```

### 2. 모니터링 서버 실행
```bash
cd monitoring-server
docker-compose -f docker-compose-monitoring.yml up -d
```

## 확인

### 애플리케이션 서버
- Spring App: http://127.0.0.1:8080
- Spring Metrics: http://127.0.0.1:8080/actuator/prometheus
- PostgreSQL: 127.0.0.1:5433 (5432는 포트 매핑 IP가 선점된 관계로... host port는 5433 사용)

### 모니터링 서버
- Grafana: http://127.0.0.1:3000 (admin/admin123)
- Prometheus: http://127.0.0.1:9090
- PostgreSQL Exporter: http://127.0.0.1:9187/metrics

## IP 변경 방법 (운영환경 배포시)

서비스 서버는 의존이 없으므로 모니터링 쪽만 수정하면 됨.

### prometheus.yml 수정
```yaml
scrape_configs:
  - job_name: 'spring-app'
    static_configs:
      - targets: ['실제_애플리케이션_서버_IP:8080']
```

### docker-compose-monitoring.yml 수정
```yaml
environment:
  DATA_SOURCE_NAME: "postgresql://user:password@실제_애플리케이션_서버_IP:5432/mydb?sslmode=disable"
```

## 네트워크 구성

- 애플리케이션 서버: 8080(Spring), 5433(PostgreSQL) 포트 노출 (실 서비스라면 적절한 방화벽 설정 필요)
- 모니터링 서버: 3000(Grafana), 9090(Prometheus), 9187(Exporter): 컨테이너들은 일반 bridge 네트워크 사용, 포트 매핑으로 외부 접근
- 현재 설정: 127.0.0.1 (동일 서버)
- 운영 설정: 실제 서버 간 IP 통신

### PostgreSQL 접근 제한
postgresql.conf, pg_hba.conf 로 접근 가능한 IP/권한 제어 가능 (실제 서비스 아니면 냅둬도 됨)

## 종료
```bash
# 애플리케이션 서버
docker-compose -f docker-compose-app.yml down

# 모니터링 서버
docker-compose -f docker-compose-monitoring.yml down
```


# 기타 자료

- https://github.com/prometheus-community/postgres_exporter

### postgresql.conf
- https://www.postgresql.org/docs/current/config-setting.html#CONFIG-SETTING-CONFIGURATION-FILE
- https://berasix.tistory.com/entry/PostgreSQL-%EC%84%A4%EC%B9%98%EC%99%80-%EC%9A%B4%EC%98%81-2-postgresqlconf-%EC%84%A4%EC%A0%95%ED%95%98%EA%B8%B0
