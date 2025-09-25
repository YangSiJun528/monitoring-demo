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
