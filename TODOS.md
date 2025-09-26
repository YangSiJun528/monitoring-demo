# 공부해야할 것들

- grafana labs 기본적인 동작 방식
  - 이건 사용하면서
  - 대충 구상 방법은 알겠음. AI가 짜준거긴 한데, 샘플이랑 비슷하기도 하고...
  - grafana datasouce 설정이나 기타 값들이 무슨 의미인지 공식문서 찾아보기
  - grafana dashboard가 제일 세팅하기 힘들거 같은데, 이거 export 못하나? 아니면 다른 곳에서 제공하는 괜찮은 자료 찾아보기.
    - prometheous로 모이는 메트릭들을 알고 특징에 맞게 조회해야 해서...
    - 그 외에 로그랑 다른 것들도 매트릭 추가 가능
    - DB 로그도 수집중이니까 모아서 볼 수 있게 세팅 ㄱㄱ
- Postgresql DB 설정
  - postgresql.conf, pg_hba.conf
- Spring Actuator/PostgreSQL이 공개하는 메트릭과 그 의미
- docekr compose network 동작 방식
  - `network_mode: "host"`
  - `host.docker.internal`
  - 뭔 브릿지?
  - 가 뭔지??

----

이제 공식문서 보면서 나중에 참고할 수 있게 문서/주석들 적어두고 마무리 하기
(어떤 값들 수정해야 하는지 보고, 서버 IP나 그런건 나중에 환경변수로 뺴야 할 수도?)

다음에는 stackoverflow data dump + spring 구현하기 (github에서 가져올 수 있으면 가져오고?)
