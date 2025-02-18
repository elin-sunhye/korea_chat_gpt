import React, { useState } from 'react';
import {
  Box,
  Button,
  Card,
  CardContent,
  Container,
  TextField,
  Typography,
} from '@mui/material';
import { api } from '../../api/config/axiosConfig';
import { Link, useNavigate } from 'react-router-dom';
import { useQueryClient } from 'react-query';

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

  const [isSigninError, setSigninError] = useState(false);

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
      if (!!accessToken) {
        localStorage.setItem('AccessToken', accessToken);
        
        // api 컴포넌트에 headers 설정을 했지만, 최초 한번만 실행되기 떄문에 api 날린 후 headers에 다시 셋팅 안헤줌
        // 셋팅 방법 1 - 상태 유지
        api.interceptors.request.use((config) => {
          config.headers.Authorization = `Bearer ${accessToken}`;
        });
      }
      queryClient.refetchQueries(['userQuery']);

      setSigninError(false);
      navigate('/');
      // 셋팅 방법 2 - 상태 초기화
      // window.location.href = "/"
    } catch (e) {
      console.error(e.response.data);
      setErrors({
        username: e.response.data.username,
        password: '',
      });
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
