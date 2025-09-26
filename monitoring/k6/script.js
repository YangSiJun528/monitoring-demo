import http from 'k6/http';
import { sleep } from 'k6';

export const options = {
  vus: 100,         // 가상 사용자 수
  duration: '30s',  // 테스트 지속시간
};

export default function () {
  http.get('http://localhost/users');
  sleep(1);
}
