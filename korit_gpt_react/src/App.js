import { Route, Routes, useLocation } from 'react-router-dom';
import WritePage from './pages/WritePage/WritePage';
import IndexPage from './pages/IndexPage/IndexPage';
import ListPage from './pages/ListPage/ListPage';
import { Global } from '@emotion/react';
import { global } from './styles/global';
import MainLayout from './components/MainLayout/MainLayout';
import SignupPage from './pages/SignupPage/SignupPage';
import SigninPage from './pages/SigninPage/SigninPage';
import axios from 'axios';
import { useQuery } from 'react-query';

export default function App() {
  const location = useLocation();

  const authenticatedUser = async () => {
    return await axios.get(
      'http://localhost:8080/servlet_study_war/api/authenticated',
      {
        headers: {
          Authorization: `Bearer ${localStorage.getItem('AccessToken')}`,
        },
      }
    );
  };

  const authenticatedUserQuery = useQuery(
    /**
     * useQuery 실행 순간 useEffect처럼 동작
     * enabled의 속성이 true여야지만 실행
     */

    ['authenticatedUserQuery'], // key값
    authenticatedUser, // option 옵션
    {
      refetchOnWindowFocus: false, // 다시 이 사이트에 포커스가 오면 다시 요청할꺼니?
      enabled: !!localStorage.getItem('AccessToken'),
    }
  );

  console.log(authenticatedUserQuery.isLoading);

  return (
    <>
      <Global styles={global} />

      {authenticatedUserQuery.isLoading ? (
        <></>
      ) : (
        <MainLayout>
          <Routes>
            <Route path="/" element={<IndexPage />} />
            <Route path="/write" element={<WritePage />} />
            <Route path="/list" element={<ListPage />} />
            <Route path="/signup" element={<SignupPage />} />
            <Route path="/signin" element={<SigninPage />} />
          </Routes>
        </MainLayout>
      )}
    </>
  );
}
