import { Box, Button, ButtonGroup, Typography } from '@mui/material';
import React from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { setAccessToken } from '../../api/config/axiosConfig';
import { useQueryClient } from '@tanstack/react-query';

export default function MainHeader(p) {
  const navigate = useNavigate();

  const queryClient = useQueryClient();
  const userQueryData = queryClient.getQueryData(['userQuery']);

  const handleLogoutOnClick = (e) => {
    setAccessToken(null);
    queryClient.invalidateQueries({
      queryKey: ['userQuery'],
      // refetchType: 'active', // 활성화된 쿼리만 만료(초기화)
    });
    navigate('/auth/signin');
  };

  return (
    <Box display={'flex'} justifyContent={'space-between'} mt={3}>
      <Typography variant="h6">로고</Typography>

      <ButtonGroup variant="outlined" aria-label="Basic button group">
        {!!userQueryData ? (
          <>
            <Link to={'/user/profile'}>
              <Button>마이페이지</Button>
            </Link>
            <Button onClick={handleLogoutOnClick}>로그아웃</Button>
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
  );
}
