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

export default function SigninPage(p) {
  const navigate = useNavigate();

  const [signinInp, setSigninInp] = useState({
    username: '',
    password: '',
  });

  const [errors, setErrors] = useState({
    username: '',
    password: '',
  });

  const handleSigninInpOnChange = (e) => {
    setSigninInp({
      ...signinInp,
      [e.target.name]: e.target.value,
    });
  };

  const handleInpOnBlur = (e) => {
    // 정규식 테스트 사이트 https://regexr.com/
    const { name, value } = e.target;
    let message = '';

    if (name === 'username' && !value) {
      message = '사용자 이름을 입력하세요.';
    }

    if (name === 'password' && !value) {
      message = '비밀번호를 입력하세요.';
    }

    setErrors({
      ...errors,
      [name]: message,
    });
  };

  const handleSigninBtnOnClick = async (e) => {
    console.log(signinInp);
    if (Object.entries(errors).filter((entry) => !!entry[1]) > 0) {
      return;
    }

    try {
      const resp = await api.post('/api/auth/signin', signinInp);

      console.log(resp.data.data);

      if (!!resp.data.data) {
        localStorage.setItem('AccessToken', resp.data.data);
        navigate('/');
      }
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
