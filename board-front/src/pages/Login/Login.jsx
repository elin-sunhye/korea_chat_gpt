/** @jsxImportSource @emotion/react */
import * as s from './style';
import React, { useEffect, useState } from 'react';
import { SiGoogle, SiNaver, SiKakao } from 'react-icons/si';
import { Link, useNavigate, useSearchParams } from 'react-router-dom';
import ValidInp from '../../components/auth/ValidInp/ValidInp';
import { useLoginMutation } from '../../mutations/authMutation';
import Swal from 'sweetalert2';
import { setLocalStorage } from '../../configs/axiosConfig';
import { useQueryClient } from '@tanstack/react-query';

export default function Login(p) {
  const navigate = useNavigate();
  const queryClient = useQueryClient();

  const loginMutation = useLoginMutation(); // .mutate가 호출 되어야지만 useJoinMutation 내부 함수 실행;

  const [searchParams, setSearchParams] = useSearchParams();

  const [inpValue, setInpValue] = useState({
    username: searchParams.get('username') || '',
    password: '',
  });

  useEffect(() => {
    setInpValue((prev) => ({
      ...prev,
      username: searchParams.get('username') || '',
    }));
  }, [searchParams]);

  const handleInpOnChange = (e) => {
    setInpValue((prev) => ({
      ...prev,
      [e.target.name]: e.target.value,
    }));

    setInpValidError((prev) => ({
      ...prev,
      password: false,
    }));
  };

  const [inpValidError, setInpValidError] = useState({
    password: false,
  });

  const isErrors = () => {
    const isEmpty = Object.values(inpValue)
      .map((value) => !!value)
      .includes(false);
    const isValid = Object.values(inpValidError).includes(true);

    return isEmpty || isValid; // 에러가 있다!
  };

  const handleLoginOnClick = async () => {
    if (isErrors()) {
      Swal.fire({
        title: 'Error!',
        text: '가입정보를 확인하세요.',
        icon: 'error',
        confirmButtonText: '확인',
      });
      return;
    }

    try {
      const resp = await loginMutation.mutateAsync(inpValue);
      setLocalStorage(resp.data.name, resp.data.token);

      await Swal.fire({
        title: 'Success!',
        text: '환영합니다 :)',
        timer: 1000,
        icon: 'success',
        showConfirmButton: false,
      });

      // .invalidateQueries 캐시 삭제가 아니라 캐시 유효하지 않은 캐시로 변경하는 것
      await queryClient.invalidateQueries({ queryKey: ['useUserMeQuery'] });

      navigate('/');
    } catch (e) {
      Swal.fire({
        title: '로그인 실패!',
        text: '사용자 정보를 확인하세요.',
        icon: 'error',
        confirmButtonText: '확인',
        confirmButtonColor: ' #ff3f3f',
      });
    }
  };

  return (
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
            <div css={s.groupBox}>
              <ValidInp
                type={'text'}
                name={'username'}
                placeholder={'Enter your email address'}
                value={inpValue.username}
                onChange={handleInpOnChange}
              />
            </div>
            <div css={s.groupBox}>
              <ValidInp
                type={'password'}
                name={'password'}
                placeholder={'password'}
                value={inpValue.password}
                onChange={handleInpOnChange}
                inpValidError={inpValidError}
                setInpValidError={setInpValidError}
                errorMessage={'로그인 정보를 확인하세요.'}
              />
            </div>

            <p css={s.accountMsg}>
              계정이 없으시다면 지금 가입하세요.
              <Link to={'/auth/join'}>회원가입</Link>
            </p>

            <div css={s.groupBox}>
              <button
                type="button"
                css={s.accountBtn}
                onClick={handleLoginOnClick}
              >
                Login
              </button>
            </div>
          </div>
        </main>
        <footer>
          <p css={s.footerAgreement}>
            이메일을 사용하여 게정을 구분하고 다른 사용자들에게 게시글을
            공유합니다. 계속 진행하려면 약관 및 개인정보 보호정책을 이해하고
            동의한다는 것을 인정해야합니다.
          </p>
        </footer>
      </div>
    </div>
  );
}
