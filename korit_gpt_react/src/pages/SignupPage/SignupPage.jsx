/** @jsxImportSource @emotion/react */
import * as s from './style';
import React, { useRef, useState } from 'react';
import axios from 'axios';
import { Link, useNavigate } from 'react-router-dom';

export default function SignupPage() {
  const navigate = useNavigate();

  const [inpRefs] = useState([
    useRef(null),
    useRef(null),
    useRef(null),
    useRef(null),
  ]);
  const [btnRefs] = useState([useRef(null)]);

  const [inpValue, setInpValue] = useState({
    username: '',
    password: '',
    name: '',
    email: '',
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

  const handleSignupSubmitOnClick = async (e) => {
    try {
      const resp = await axios.post(
        'http://localhost:8080/servlet_study_war/api/signup',
        inpValue
      );

      console.log('resp', resp);
      alert('회원가입');
      navigate(`/signin?username=${resp.data.data.username}`);
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
        <input
          type="text"
          name="name"
          id="name"
          placeholder="성명"
          value={inpValue.name}
          onChange={handleInpOnCHange}
          onKeyDown={handleInpOnKeyDown}
          ref={inpRefs[2]}
        />
        <input
          type="text"
          name="email"
          id="email"
          placeholder="이메일"
          value={inpValue.email}
          onChange={handleInpOnCHange}
          onKeyDown={handleInpOnKeyDown}
          ref={inpRefs[3]}
        />
        <button ref={btnRefs[0]} onClick={handleSignupSubmitOnClick}>
          가입
        </button>
      </div>
      <div css={s.footer}>
        <span>계정이 있으신가요?</span>
        <Link to={'/signin'}>로그인</Link>
      </div>
    </div>
  );
}
