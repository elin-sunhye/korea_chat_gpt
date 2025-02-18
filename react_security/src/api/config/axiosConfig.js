import axios from 'axios';

// 서버 URL, 메번 들어가야하는 header 정보 셋팅
export const api = axios.create({
  baseURL: 'http://localhost:8080',
});

api.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem('AccessToken');
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }

    return config;
  },
  (e) => Promise.reject(e)
);

export const setAccessToken = (token) => {
  if (!!token) {
    localStorage.setItem('AccessToken', token);
  } else {
    localStorage.removeItem('AccessToken');
  }
};
