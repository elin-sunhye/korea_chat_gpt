/** @jsxImportSource @emotion/react */
import * as s from './style';
import React, { useState } from 'react';
import { CgPassword } from 'react-icons/cg';
import { RiCloseCircleFill } from 'react-icons/ri';

export default function PwModal({ setOpen }) {
  const [pwValue, setPwValue] = useState({
    newPassword: '',
    newPasswordCk: '',
  });

  function handleCloseBtnOnClick() {
    setOpen(false);
  }

  function handleInpOnChange(e) {
    setPwValue((prev) => ({
      ...prev,
      [e.target.name]: e.target.value,
    }));
  }

  return (
    <div>
      <div css={s.modalTop}>
        <button type="button" onClick={handleCloseBtnOnClick}>
          <RiCloseCircleFill />
        </button>
      </div>
      <div css={s.header}>
        <span css={s.headerIco}>
          <CgPassword />
        </span>
        <h2 css={s.headerTitle}>Set password</h2>
        <p css={s.headerMsg}>
          비밀번호는 최소 8자 이상, 또는 16자 이하의 영문, 숫자 조합을
          사용하세요.
        </p>
      </div>
      <div>
        <div css={s.inpGroup}>
          <label>Enter a new password</label>
          <input
            type="password"
            name="newPassword"
            id="newPassword"
            value={pwValue.newPassword}
            onChange={handleInpOnChange}
          />
        </div>
        <div css={s.inpGroup}>
          <label>Confirm new password</label>
          <input
            type="password"
            name="newPasswordCk"
            id="newPasswordCk"
            value={pwValue.newPasswordCk}
            onChange={handleInpOnChange}
          />
        </div>
        <button
          type="button"
          css={s.setBtn}
          disabled={
            (pwValue.newPassword === '' && pwValue.newPasswordCk === '') ||
            pwValue.newPassword !== pwValue.newPasswordCk
          }
        >
          Change password
        </button>
      </div>
    </div>
  );
}
