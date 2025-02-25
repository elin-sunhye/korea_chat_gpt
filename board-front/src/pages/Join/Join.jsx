/** @jsxImportSource @emotion/react */
import * as s from './style';
import React, { useState } from 'react';
import { SiGoogle, SiNaver, SiKakao } from 'react-icons/si';
import { Link, useNavigate } from 'react-router-dom';
import ValidInp from '../../components/auth/ValidInp/ValidInp';
import { useJoinMutation } from '../../mutations/authMutation';
import Swal from 'sweetalert2';

export default function Join(p) {
  const navigate = useNavigate();
  const joinMutation = useJoinMutation(); // .mutate가 호출 되어야지만 useJoinMutation 내부 함수 실행

  const [inpValue, setInpValue] = useState({
    username: '',
    email: '',
    password: '',
    passwordCk: '',
  });

  const handleInpOnChange = (e) => {
    setInpValue((prev) => ({
      ...prev,
      [e.target.name]: e.target.value,
    }));
  };

  const handlePasswordOnFocus = (e) => {
    setInpValue((prev) => ({
      ...prev,
      password: '',
      passwordCk: '',
    }));
  };

  const [inpValidError, setInpValidError] = useState({
    username: false,
    email: false,
    password: false,
    passwordCk: false,
  });

  const isErrors = () => {
    const isEmpty = Object.values(inpValue)
      .map((value) => !!value)
      .includes(false);
    const isValid = Object.values(inpValidError).includes(true);

    return isEmpty || isValid; // 에러가 있다!
  };

  const handleJoinOnClick = (e) => {
    if (isErrors()) {
      Swal.fire({
        title: 'Error!',
        text: '가입정보를 확인하세요.',
        icon: 'error',
        confirmButtonText: '확인',
      });
      return;
    }

    joinMutation
      .mutateAsync({
        username: inpValue.username,
        email: inpValue.email,
        password: inpValue.password,
      })
      .then(async (resp) => {
        await Swal.fire({
          title: 'Success!',
          text: '회원가입되었습니다 :)',
          timer: 1000,
          icon: 'success',
          confirmButtonText: '확인',
        });

        navigate(`/auth/login?username=${resp.data.username}`);
      })
      .catch((e) => {
        if (e.status === 400) {
          setInpValidError((prev) => ({
            ...prev,
            username: true,
          }));
        }
      });
  };

  return (
    // test
    <div css={s.layout}>
      <div>
        <header>
          <h2 css={s.title}>Think it. Make it.</h2>
          <p css={s.subTitle}>Log in to your account</p>
        </header>
        <main>
          <div css={s.oauth2Group}>
            <div css={s.groupBox}>
              <button type="button" css={s.oauth2Btn}>
                <div css={s.oauth2Ico}>
                  <SiGoogle />
                </div>
                <span css={s.oauth2Txt}>Continue with Google</span>
              </button>
            </div>
            <div css={s.groupBox}>
              <button type="button" css={s.oauth2Btn}>
                <div css={s.oauth2Ico}>
                  <SiNaver />
                </div>
                <span css={s.oauth2Txt}>Continue with Naver</span>
              </button>
            </div>
            <div css={s.groupBox}>
              <button type="button" css={s.oauth2Btn}>
                <div css={s.oauth2Ico}>
                  <SiKakao />
                </div>
                <span css={s.oauth2Txt}>Continue with Kakao</span>
              </button>
            </div>
          </div>

          <div>
            <ValidInp
              type={'text'}
              name={'username'}
              placeholder={'Enter your username'}
              value={inpValue.username}
              onChange={handleInpOnChange}
              regexp={/^[a-zA-Z][a-zA-Z0-9_]{3,15}$/}
              errorMessage={
                '사용할 수 없는 사용자 이름 입니다. (3~15자로 대소문자 구분하여 작성)'
              }
              inpValidError={inpValidError}
              setInpValidError={setInpValidError}
            />
            <ValidInp
              type={'text'}
              name={'email'}
              placeholder={'email address'}
              value={inpValue.email}
              onChange={handleInpOnChange}
              regexp={/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/}
              errorMessage={
                '이메일 형식이 아닙니다. (@이 포함된 이메일 형식으로 작성)'
              }
              inpValidError={inpValidError}
              setInpValidError={setInpValidError}
            />
            <ValidInp
              type={'password'}
              name={'password'}
              placeholder={'password'}
              value={inpValue.password}
              onChange={handleInpOnChange}
              onFocus={handlePasswordOnFocus}
              regexp={
                /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]{8,20}$/
              }
              errorMessage={
                '사용할 수 없는 비밀번호 입니다. (8~16자로 영문 숫자 조합으로 작성)'
              }
              inpValidError={inpValidError}
              setInpValidError={setInpValidError}
            />
            <ValidInp
              type={'password'}
              name={'passwordCk'}
              placeholder={'password check'}
              value={inpValue.passwordCk}
              onChange={handleInpOnChange}
              regexp={new RegExp(`^${inpValue.password}$`)}
              errorMessage={'비밀번호가 일치하지 않습니다.'}
              inpValidError={inpValidError}
              setInpValidError={setInpValidError}
            />
            <p css={s.accountMsg}>
              계정이 있으신가요?
              <Link to={'/auth/login'}>로그인</Link>
            </p>
            <div css={s.groupBox}>
              <button
                type="button"
                css={s.accountBtn}
                onClick={handleJoinOnClick}
              >
                Join
              </button>
            </div>
          </div>
        </main>
      </div>
    </div>
  );
}
