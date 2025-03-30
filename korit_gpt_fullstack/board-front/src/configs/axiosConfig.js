import axios from 'axios';

export const api = axios.create({
  baseURL: 'http://localhost:8080',
});

export const setLocalStorage = (name, value) => {
  if (!!value) {
    localStorage.setItem(name, value);
  } else {
    localStorage.removeItem(name);
  }
};

api.interceptors.request.use((config) => {
  const accessToken = localStorage.getItem('AccessToken');

  config.headers.Authorization =
    accessToken && `Bearer ${localStorage.getItem('AccessToken')}`;
  return config;
});
