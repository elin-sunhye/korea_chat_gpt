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

export default function SignuPage(p) {
  const navigate = useNavigate();

  const [signupInp, setSignupInp] = useState({
    username: '',
    password: '',
    name: '',
    email: '',
  });

  const [errors, setErrors] = useState({
    username: '',
    password: '',
    name: '',
    email: '',
  });

  const handleSignupInpOnChange = (e) => {
    setSignupInp({
      ...signupInp,
      [e.target.name]: e.target.value,
    });
  };

  const handleInpOnBlur = (e) => {
    // 정규식 테스트 사이트 https://regexr.com/
    const { name, value } = e.target;
    let message = '';

    if (name === 'username' && !/^[a-zA-Z0-9_]{4,16}$/.test(value)) {
      message = '올바른 사용자 이름을 입력하세요.';
    }

    if (
      name === 'password' &&
      !/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*()_+~`|{}:;'<>,.?/-])[A-Za-z\d!@#$%^&*()_+~`|{}:;'<>,.?/-]{8,}$/.test(
        value
      )
    ) {
      message =
        '영어 대소문자, 숫자, 특수문자를 포함하여 8자리 이상 입력하세요.';
    }

    if (name === 'name' && !/^[가-힇]{2,}$/.test(value)) {
      message = '한글만 입력하세요.';
    }

    if (
      name === 'email' &&
      !/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i.test(value)
    ) {
      message = '올바른 이메일을 입력하세요.';
    }

    setErrors({
      ...errors,
      [name]: message,
    });
  };

  const handleSignupBtnOnClick = async (e) => {
    console.log(signupInp);
    if (Object.entries(errors).filter((entry) => !!entry[1]) > 0) {
      return;
    }

    try {
      const resp = await api.post('/api/auth/signup', signupInp);
      console.log(resp.data);
      alert('회원가입 완료');
      navigate('/signin');
    } catch (e) {
      console.error(e.response.data);
      setErrors({
        username: e.response.data.data.username,
        password: e.response.data.data.password,
        name: e.response.data.data.name,
        email: e.response.data.data.email,
      });

      // DB에서 주는 에러 문구
      // let newError = {};
      // // data:  Array(3)
      // // 0: {name: '한글 2자 이상만 입력가능합니다.'}
      // // 1: {username: '영어 대소문자 (A-Z, a-z), 숫자 (0-9), 밑줄(_)만 입력해야합니다.'}
      // // 2: {password: "영어 대소문자, 숫자, 특수문자(!@#$%^&*()_+~`|{}:;'<>,.?/-)를 하나 이상 모두 포함하며 8자리 이상 입력해야합니다."}
      // const repErrors = e.response.data.data;
      // for (let e of repErrors) {
      //   // {name: '한글 2자 이상만 입력가능합니다.'}
      //   // {username: '영어 대소문자 (A-Z, a-z), 숫자 (0-9), 밑줄(_)만 입력해야합니다.'}
      //   // {password: "영어 대소문자, 숫자, 특수문자(!@#$%^&*()_+~`|{}:;'<>,.?/-)를 하나 이상 모두 포함하며 8자리 이상 입력해야합니다."}
      //   const errorEntry = Object.entries(e)[0];
      //   newError = {
      //     ...newError,
      //     [errorEntry[0]]: errorEntry[1],
      //   };
      // }
      // setErrors({
      //   username: '',
      //   password: '',
      //   name: '',
      //   email: '',
      //   ...newError,
      // });
    }
  };
  return (
    <Box mt={10}>
      <Container maxWidth="xs">
        <Card variant="outlined">
          <CardContent>
            <Typography variant="h4" textAlign="center" mb={3}>
              회원가입
            </Typography>
            <Box display="flex" flexDirection="column" gap={2}>
              <TextField
                type="text"
                label="username"
                name="username"
                value={signupInp.username}
                onChange={handleSignupInpOnChange}
                onBlur={handleInpOnBlur}
                error={!!errors.username}
                helperText={errors.username}
              />
              <TextField
                type="password"
                label="password"
                name="password"
                value={signupInp.password}
                onChange={handleSignupInpOnChange}
                onBlur={handleInpOnBlur}
                error={!!errors.password}
                helperText={errors.password}
              />
              <TextField
                type="text"
                label="name"
                name="name"
                value={signupInp.name}
                onChange={handleSignupInpOnChange}
                onBlur={handleInpOnBlur}
                error={!!errors.name}
                helperText={errors.name}
              />
              <TextField
                type="email"
                label="email"
                name="email"
                value={signupInp.email}
                onChange={handleSignupInpOnChange}
                onBlur={handleInpOnBlur}
                error={!!errors.email}
                helperText={errors.email}
              />

              <Button variant="contained" onClick={handleSignupBtnOnClick}>
                가입하기
              </Button>
            </Box>

            <Typography variant="h6" textAlign="center" mt={3}>
              이미 계정이 있으신가요? <Link to={'/signin'}>로그인</Link>
            </Typography>
          </CardContent>
        </Card>
      </Container>
    </Box>
  );
}
