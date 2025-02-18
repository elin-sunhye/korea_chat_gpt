import React, { useEffect } from 'react';
import { Route, Routes, useNavigate } from 'react-router-dom';
import SigninPage from '../../pages/signinPage/signinPage';
import SignupPage from '../../pages/signupPage/signupPage';
import { useQueryClient } from 'react-query';

export default function AuthRoute(p) {
  const navigate = useNavigate();

  const queryClient = useQueryClient();
  console.log(queryClient.getQueryState(['userQuery']));
  console.log(queryClient.getQueriesData(['userQuery']));
  
  const isLogin = !!queryClient.getQueriesData(['userQuery']);
  useEffect(() => {
    if (isLogin) {
      navigate('/');
    }
  }, []);

  return !isLogin ? (
    <Routes>
      <Route path={'/signin'} element={<SigninPage />} />
      <Route path={'/signup'} element={<SignupPage />} />
    </Routes>
  ) : (
    <></>
  );
}
