/** @jsxImportSource @emotion/react */
import * as s from './style';
import React from 'react';
import { SiGoogle, SiNaver, SiKakao } from 'react-icons/si';
import { Link } from 'react-router-dom';

export default function Login(p) {
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
              <input
                type="text"
                placeholder="Enter your email address"
                css={s.textInp}
              />
            </div>
            <div css={s.groupBox}>
              <input
                type="password"
                placeholder="Enter your password"
                css={s.textInp}
              />
            </div>

            <p css={s.accountMsg}>
              계정이 없으시다면 지금 가입하세요.
              <Link to={'/auth/join'}>회원가입</Link>
            </p>

            <div css={s.groupBox}>
              <button type="button" css={s.accountBtn}>
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
