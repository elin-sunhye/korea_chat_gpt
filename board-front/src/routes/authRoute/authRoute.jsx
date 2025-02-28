import React, { useEffect } from 'react';
import { Route, Routes, useNavigate } from 'react-router-dom';
import Login from '../../pages/Login/Login';
import Join from '../../pages/Join/Join';
import NotFound from '../../pages/NotFound/NotFound';
import { useQueryClient } from '@tanstack/react-query';
import OAuth2Login from '../../pages/OAuth2Login/OAuth2Login';

export default function AuthRoute({}) {
  const navigate = useNavigate();
  const queryClient = useQueryClient();
  const queryState = queryClient.getQueryState(['useUserMeQuery']);

  // 로그인 이후 로그인 페이지로 이동 시 메인 페이지로 이동
  useEffect(() => {
    if (queryState.status === 'success') {
      navigate('/');
    }
  }, [queryState]);

  return (
    // 화면 깜빡임 없애려고
    queryState.status === 'error' && (
      <Routes>
        <Route path="/login" element={<Login />} />
        <Route path="/login/oauth2" element={<OAuth2Login />} />
        <Route path="/join" element={<Join />} />
        <Route path="/*" element={<NotFound />} />
      </Routes>
    )
  );
}
