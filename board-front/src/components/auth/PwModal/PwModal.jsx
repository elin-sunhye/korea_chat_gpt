/** @jsxImportSource @emotion/react */
import * as s from './style';
import React, { useState } from 'react';
import { CgPassword } from 'react-icons/cg';
import { RiCloseCircleFill } from 'react-icons/ri';
import { useUpdatePwMutation } from '../../../mutations/accountMutation';
import { useUserMeQuery } from '../../../queries/useUserMeQuery';
import Swal from 'sweetalert2';

export default function PwModal({ setOpen }) {
  const updatePwMutation = useUpdatePwMutation();

  const [pwValue, setPwValue] = useState({
    newPassword: '',
    newPasswordCk: '',
  });

  function handleInpOnChange(e) {
    setPwValue((prev) => ({
      ...prev,
      [e.target.name]: e.target.value,
    }));
  }

  async function handleSavePwBtnOnClick() {
    await updatePwMutation.mutateAsync(pwValue.newPassword);
    await Swal.fire({
      titleText: '비밀번호가 변경되었습니다.',
      icon: 'success',
      showConfirmButton: false,
      timer: 1000,
      position: 'center',
    });
    setOpen(false);
  }

  function handleCloseBtnOnClick() {
    setOpen(false);
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
          비밀번호는 최소 8자 이상,
          <br />
          또는 16자 이하의 영문, 숫자 조합을 사용하세요.
        </p>
      </div>
      <div>
        <div css={s.inpGroup}>
          <label>Enter new password</label>
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
        {pwValue.newPassword !== pwValue.newPasswordCk && (
          <p css={s.warnning}>비밀번호가 일치하지 않습니다.</p>
        )}

        <button
          type="button"
          css={s.setBtn}
          onClick={handleSavePwBtnOnClick}
          disabled={
            !pwValue.newPassword ||
            !pwValue.newPasswordCk ||
            pwValue.newPassword !== pwValue.newPasswordCk
          }
        >
          Save password
        </button>
      </div>
    </div>
  );
}
