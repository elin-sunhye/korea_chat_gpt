import React, { useState } from 'react';
import { useQueryClient } from '@tanstack/react-query';
import {
  Box,
  Button,
  Card,
CardContent,
  Container,
  TextField,
  Typography,
} from '@mui/material';
import { api, setAccessToken } from '../../api/config/axiosConfig';
import { Link, useNavigate } from 'react-router-dom';

export default function SigninPage(p) {
  const navigate = useNavigate();

  const queryClient = useQueryClient();

  const [signinInp, setSigninInp] = useState({
    username: '',
    password: '',
  });

  const [errors, setErrors] = useState({
    username: '',
    password: '',
  });

  const [isSigninError, setIsSigninError] = useState(false);

  const handleSigninInpOnChange = (e) => {
    setSigninInp({
      ...signinInp,
      [e.target.name]: e.target.value,
    });
  };

  const handleInpOnBlur = (e) => {
    // 정규식 테스트 사이트 https://regexr.com/
    const { name, value } = e.target;
    setErrors((prev) => ({
      ...prev,
      [name]: !value.trim() ? `${name}을 입력하세요.` : '',
    }));
  };

  const handleSigninBtnOnClick = async (e) => {
    console.log(signinInp);
    if (Object.entries(errors).filter((entry) => !!entry[1]).length > 0) {
      return;
    }

    try {
      const resp = await api.post('/api/auth/signin', signinInp);
      console.log(resp.data.data);

      const accessToken = resp.data.data;
      setAccessToken(accessToken);
      queryClient.invalidateQueries({ queryKey: ['userQuery'] });
      navigate('/');
      // 셋팅 방법 2 - 상태 초기화
      // window.location.href = "/"
    } catch (e) {
      console.error(e.response.data);
      setIsSigninError(true);
    }
  };

  return (
    <Box mt={10}>
      <Container maxWidth="xs">
        <Card variant="outlined">
          <CardContent>
            <Typography variant="h4" textAlign="center" mb={3}>
              로그인
            </Typography>
            <Box display="flex" flexDirection="column" gap={2}>
              <TextField
                type="text"
                label="username"
                name="username"
                value={signinInp.username}
                onChange={handleSigninInpOnChange}
                onBlur={handleInpOnBlur}
                error={!!errors.username}
                helperText={errors.username}
              />
              <TextField
                type="password"
                label="password"
                name="password"
                value={signinInp.password}
                onChange={handleSigninInpOnChange}
                onBlur={handleInpOnBlur}
                error={!!errors.password}
                helperText={errors.password}
              />

              {isSigninError && (
                <Typography variant="body2" textAlign={'center'} color="red">
                  사용자 정보를 다시 확인하세요.
                </Typography>
              )}

              <Button variant="contained" onClick={handleSigninBtnOnClick}>
                로그인
              </Button>
            </Box>

            <Typography variant="h6" textAlign="center" mt={3}>
              계정이 없으신가요? <Link to={'/signup'}>회원가입</Link>
            </Typography>
          </CardContent>
        </Card>
      </Container>
    </Box>
  );
}
