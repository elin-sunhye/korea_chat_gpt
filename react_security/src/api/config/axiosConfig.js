import axios from 'axios';

// 서버 URL, 메번 들어가야하는 header 정보 셋팅
export const api = axios.create({
  baseURL: 'http://localhost:8080',
  headers: {
    Authorization:
      !!localStorage.getItem('AccessToken') &&
      `Bearer ${localStorage.getItem('AccessToken')}`,
  },
});
