import React, { useEffect } from 'react';
import { useNavigate, useSearchParams } from 'react-router-dom';
import { setLocalStorage } from '../../configs/axiosConfig';
import { useQueryClient } from '@tanstack/react-query';

/** 로직만 처리 */
export default function OAuth2Login({}) {
  const navigate = useNavigate();
  const queryClient = useQueryClient();
  const [searchParams] = useSearchParams();

  const setAccessToken = async (e) => {
    const accessToken = searchParams.get('accessToken');
    setLocalStorage('AccessToken', accessToken);
    await queryClient.invalidateQueries({ queryKey: ['useUserMeQuery'] });
    navigate('/');
  };

  useEffect(() => {
    setAccessToken();
  }, []);

  return <></>;
}
