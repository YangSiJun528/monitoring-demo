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
