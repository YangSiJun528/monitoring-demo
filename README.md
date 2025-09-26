## 파일 구조

대충 이 코드가 v4

예전에 그라파나 붙인게 v2 

# 기타 자료

- https://github.com/prometheus-community/postgres_exporter

### postgresql.conf
- https://www.postgresql.org/docs/current/config-setting.html#CONFIG-SETTING-CONFIGURATION-FILE
- https://berasix.tistory.com/entry/PostgreSQL-%EC%84%A4%EC%B9%98%EC%99%80-%EC%9A%B4%EC%98%81-2-postgresqlconf-%EC%84%A4%EC%A0%95%ED%95%98%EA%B8%B0


----

https://github.com/grafana/pyroscope/blob/main/examples/tracing/java/grafana-provisioning/plugins/explore-profiles.yml

뭔 예제들 보면 다  plugins/explore-profiles.yml 파일이 있던데, 뭔지 몰라도 이거랑 문서에 없는 내용 때문에
삽질하는데 시간을 다 썼다.  실습 파일 값 하나하나 바꿔가면서 함. AI도 여기선 도움 크게 안되서 오랜만에 삽질함.
게다가 뭔가 꼬인건지 자꾸 데이터소스 인식을 못하다가 볼륨 지우고 다시 띄워서 해결했다. 

plugins/explore-profiles.yml는 없어도 동작하긴 하는 듯.


## k6 부하 테스트 실행

부하 테스트는 `docker-compose`와 별개로, `docker run` 명령어를 통해 k6 컨테이너를 일회성으로 실행하는 방식을 사용합니다.

### 1. 애플리케이션 시스템 실행

부하 테스트를 진행하려면 먼저 타겟이 될 애플리케이션 시스템이 실행되어야 합니다. 프로젝트 루트 디렉토리에서 아래 명령어를 실행하여 메인 애플리케이션(app1, app2), Nginx, DB를 시작합니다.

```bash
docker-compose up --build -d
```

서버 코드가 바뀐 경우 `./gradlew clean build` 로 jar을 빌드하고 `docker-compose --build`를 수행해야 함 함. 

(참고: 모니터링 시스템은 부하 테스트 실행 자체에 필수적이지는 않으므로, 필요에 따라 `docker-compose -f monitoring/docker-compose-monitoring.yml up -d` 명령으로 실행할 수 있습니다.)

### 2. 부하 테스트 실행

애플리케이션 시스템이 실행 중인 상태에서, 아래 명령어를 사용하여 부하 테스트를 시작합니다.

```bash
docker run --rm -i --network host grafana/k6 run - < ./monitoring/k6/script.js
```

- **설명**:
    - `--rm`: 테스트가 끝나면 컨테이너를 자동으로 삭제합니다.
    - `-i`: interactive 모드를 활성화하여 stdin으로 스크립트를 전달받을 수 있게 합니다.
    - `--network host`: 컨테이너가 호스트의 네트워크를 직접 사용하도록 설정합니다. 이를 통해 컨테이너 내부의 `localhost`가 호스트 머신(및 Nginx)을 가리키게 됩니다.
    - `< ./monitoring/k6/script.js`: 로컬 스크립트 파일을 컨테이너의 stdin으로 전달합니다.

### 3. 부하 테스트 중단

테스트는 스크립트에 설정된 `duration` 이후 자동으로 종료됩니다. 만약 실행 중에 강제로 중단하고 싶다면, `docker run` 명령어를 실행한 터미널에서 `Ctrl+C`를 누르면 됩니다.
