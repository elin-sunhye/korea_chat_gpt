import React, { useEffect } from 'react';
import { useQueryClient } from '@tanstack/react-query';
import { Route, Routes, useNavigate } from 'react-router-dom';
import SigninPage from '../../pages/signinPage/signinPage';
import SignupPage from '../../pages/signupPage/signupPage';

export default function AuthRoute(p) {
  const navigate = useNavigate();

  const queryClient = useQueryClient();
  console.log(queryClient.getQueryState(['userQuery']));
  console.log(queryClient.getQueryData(['userQuery']));

  const isLogin = !!queryClient.getQueryData(['userQuery']);

  useEffect(() => {
    if (isLogin) {
      navigate('/');
      return;
    }
  }, []);

  return (
    <>
      {!isLogin && (
        <Routes>
          <Route path={'/signin'} element={<SigninPage />} />
          <Route path={'/signup'} element={<SignupPage />} />
        </Routes>
      )}
    </>
  );
}
