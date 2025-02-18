import React, { useEffect } from 'react';
import { useQueryClient } from 'react-query';
import { Route, Routes, useNavigate } from 'react-router-dom';
import ProfilePage from '../../pages/profilePage/profilePage';

export default function UserRoute(p) {
  const navigate = useNavigate();

  const queryClient = useQueryClient();
  const isLogin = !!queryClient.getQueriesData(['userQuery']);
  useEffect(() => {
    if (!isLogin) {
      alert('잘못된 접근입니다.');
      navigate('/auth/signin');
    }
  }, []);

  return isLogin ? (
    <Routes>
      <Route path={'/profile'} element={<ProfilePage />} />
    </Routes>
  ) : (
    <></>
  );
}
