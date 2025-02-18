import { useQuery } from 'react-query';
import { reqHealthCkApi } from './api/apis/healthCheckApi';
import { Route, Routes } from 'react-router-dom';
import IndexPage from './pages/indexPage/indexPage';
import ProfilePage from './pages/profilePage/profilePage';
import SigninPage from './pages/signinPage/signinPage';
import SignupPage from './pages/signupPage/signupPage';
import { Container } from '@mui/material';

export default function App() {
  const healthCkQuery = useQuery(
    ['healthCkQuery'],
    // async () => axios.get('http://localhost:8080/server/hc'),
    // async () => api.get('/server/hc'),
    reqHealthCkApi,
    {
      refetchOnWindowFocus: false,
      enabled: true,
      cacheTime: 1000 * 60 * 10, // 언마운트 이후 10분동안 캐시 유지
      staleTime: 1000 * 60 * 10, // 10분마다 최신의 캐시 상태 유지(refetch)
    }
  );

  if (!healthCkQuery.isLoading) {
    console.log(healthCkQuery.data.data.status);
  }

  return (
    <Container maxWidth="lg">
      <Routes>
        <Route path={'/'} element={<IndexPage />}></Route>
        <Route path={'/profile'} element={<ProfilePage />}></Route>
        <Route path={'/signin'} element={<SigninPage />}></Route>
        <Route path={'/signup'} element={<SignupPage />}></Route>
      </Routes>
    </Container>
  );
}
