import React, { useEffect } from 'react';
import { Route, Routes, useNavigate } from 'react-router-dom';
import MainSidebar from '../../components/common/MainSidebar/MainSidebar';
import MainContainer from '../../components/common/MainContainer/MainContainer';
import Account from '../../pages/Account/Account';
import NotFound from '../../pages/NotFound/NotFound';
import { useQueryClient } from '@tanstack/react-query';
import BoardWrite from '../../pages/BoardWrite/BoardWrite';
import BoardList from '../../pages/BoardList/BoardList';

export default function MainRoute({}) {
  const navigate = useNavigate();
  const queryClient = useQueryClient();
  const queryState = queryClient.getQueryState(['useUserMeQuery']);

  // 로그인 안하고 메인 페이지로 이동 시 로그인 페이지로 이동
  useEffect(() => {
    if (queryState.status === 'error') {
      navigate('/auth/login');
    }
  }, [queryState]);

  return (
    // 화면 깜빡임 없애려고
    queryState.status === 'success' && (
      <>
        <MainSidebar />
        <MainContainer>
          <Routes>
            <Route path="/account/setting" element={<Account />} />
            <Route path="/board/list" element={<BoardList />} />
            <Route path="/board/write/:categoryName" element={<BoardWrite />} />
            <Route path="/**" element={<NotFound />} />
          </Routes>
        </MainContainer>
      </>
    )
  );
}
