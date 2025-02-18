import { useQuery } from '@tanstack/react-query';
import { reqHealthCkApi } from './api/apis/healthCheckApi';
import { Route, Routes } from 'react-router-dom';
import IndexPage from './pages/indexPage/indexPage';
import { Container } from '@mui/material';
import AuthRoute from './routes/authRoute/authRoute';
import { userApi } from './api/apis/userApi';
import { jwtDecode } from 'jwt-decode';
import UserRoute from './routes/userRoute/userRoute';
import MainHeader from './components/MainHeader/MainHeader';

export default function App() {
  const healthCkQuery = useQuery({
    queryKey: ['healthCkQuery'],
    // queryFn: async () => axios.get('http://localhost:8080/server/hc'),
    // queryFn: async () => api.get('/server/hc'),
    queryFn: reqHealthCkApi,
    // enabled: true,
    cacheTime: 1000 * 60 * 10, // 언마운트 이후 10분동안 캐시 유지
    staleTime: 1000 * 60 * 10, // 10분마다 최신의 캐시 상태 유지(refetch)
  });

  if (!healthCkQuery.isLoading) {
    console.log(healthCkQuery.data.data.status);
  }

  const userQuery = useQuery({
    queryKey: ['userQuery'],
    queryFn: async () => {
      const accessToken = localStorage.getItem('AccessToken');
      if (!accessToken) {
        return null;
      }
      const decodedJwt = jwtDecode(accessToken);
      return await userApi(decodedJwt.userId);
    },
  });

  return (
    <Container maxWidth="lg">
      {!userQuery.isLoading && !userQuery.isRefetching && (
        <>
          <MainHeader />
          <Routes>
            <Route path={'/'} element={<IndexPage />} />
            <Route path={'/user/*'} element={<UserRoute />} />
            <Route path={'/auth/*'} element={<AuthRoute />} />
          </Routes>
        </>
      )}
    </Container>
  );
}
