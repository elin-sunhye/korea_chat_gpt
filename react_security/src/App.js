import { useQuery } from 'react-query';
import { reqHealthCkApi } from './api/apis/healthCheckApi';
import { Link, Route, Routes } from 'react-router-dom';
import IndexPage from './pages/indexPage/indexPage';
import { Box, Container, Typography } from '@mui/material';
import AuthRoute from './routes/authRoute/authRoute';
import { userApi } from './api/apis/userApi';
import { jwtDecode } from 'jwt-decode';
import UserRoute from './routes/userRoute/userRoute';
import { Button, ButtonGroup } from '@mui/material';

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

  const userQuery = useQuery(
    ['userQuery'],
    async () => {
      const accessToken = localStorage.getItem('AccessToken');
      if (!accessToken) {
        return;
      }
      const decodedJwt = jwtDecode(accessToken);
      console.log(decodedJwt);

      return userApi(decodedJwt.userId);
    },
    {
      retry: 0, // 실패 시 재요청 없음
      refetchOnWindowFocus: false, // 포커스 나갔다가 들아왓을떄 재요청 없음
    }
  );

  return (
    <Container maxWidth="lg">
      {!userQuery.isLoading && (
        <>
          <Box display={'flex'} justifyContent={'space-between'} mt={3}>
            <Typography variant="h6">로고</Typography>

            <ButtonGroup variant="outlined" aria-label="Basic button group">
              {!!userQuery.data ? (
                <>
                  <Link to={'/user/profile'}>
                    <Button>마이페이지</Button>
                  </Link>
                  <Link to={'/user/logout'}>
                    <Button>로그아웃</Button>
                  </Link>
                </>
              ) : (
                <>
                  <Link to={'/auth/signin'}>
                    <Button>로그인</Button>
                  </Link>
                  <Link to={'/auth/signup'}>
                    <Button>회원가입</Button>
                  </Link>
                </>
              )}
            </ButtonGroup>
          </Box>

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
