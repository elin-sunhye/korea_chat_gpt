import { api } from "../config/axiosConfig";

export const reqHealthCkApi = async () => api.get('/server/hc');
