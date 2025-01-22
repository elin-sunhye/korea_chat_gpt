/** @jsxImportSource @emotion/react */
import * as s from './style';
import React, { useEffect, useRef, useState } from 'react';
import axios from 'axios';
import { Link, useSearchParams } from 'react-router-dom';

export default function SigninPage() {
  const [searchParams] = useSearchParams();

  useEffect(() => {
    setInpValue({
      ...inpValue,
      username: searchParams.get('username'),
    });
  }, [searchParams.get('username')]);

  const [inpRefs] = useState([useRef(null), useRef(null)]);
  const [btnRefs] = useState([useRef(null)]);

  const [inpValue, setInpValue] = useState({
    username: '',
    password: '',
  });

  const handleInpOnCHange = (e) => {
    setInpValue({
      ...inpValue,
      [e.target.name]: e.target.value,
    });
  };

  const handleInpOnKeyDown = (e) => {
    if (e.keyCode === 13) {
      let foundIdx = -1;

      for (let i = 0; i < inpRefs.length; i++) {
        if (inpRefs[i].current === e.target) {
          foundIdx = i;
          // 찾은 순간 for문 중단
          // 안쓰면 끝까지 다 돌아서 찾아도 결과값이 정확하지 않음
          break;
        }
      }
      // 마지막 인덱스
      if (foundIdx === inpRefs.length - 1) {
        btnRefs[0].current.click();
        // 실행하고 handleInpOnKeyDown 나가기
        // return 안하면 하위 inpRefs[foundIdx + 1].current.focus(); 가 실행됨
        return;
      }

      inpRefs[foundIdx + 1].current.focus();
    }
  };

  const handleSigninSubmitOnClick = async (e) => {
    try {
      const resp = await axios.post(
        'http://localhost:8080/servlet_study_war/api/signin',
        inpValue
      );
      console.log(resp);
      // alert();
    } catch (e) {
      console.error(e);
    }
  };

  return (
    <div css={s.layout}>
      <div css={s.main}>
        <input
          type="text"
          name="username"
          id="username"
          placeholder="사용자 이름"
          value={inpValue.username}
          onChange={handleInpOnCHange}
          onKeyDown={handleInpOnKeyDown}
          ref={inpRefs[0]}
        />
        <input
          type="password"
          name="password"
          id="password"
          placeholder="비밀번호"
          value={inpValue.password}
          onChange={handleInpOnCHange}
          onKeyDown={handleInpOnKeyDown}
          ref={inpRefs[1]}
        />
        <button ref={btnRefs[0]} onClick={handleSigninSubmitOnClick}>
          로그인
        </button>
      </div>
      <div css={s.footer}>
        <span>계정이 없으신가요?</span>
        <Link to={'/signup'}>회원가입</Link>
      </div>
    </div>
  );
}
