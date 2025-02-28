/** @jsxImportSource @emotion/react */
import * as s from './style';
import React, { useEffect, useState } from 'react';
import { CgMail } from 'react-icons/cg';
import { RiCloseCircleFill } from 'react-icons/ri';
import { useUpdateEmailMutation } from '../../../mutations/accountMutation';
import Swal from 'sweetalert2';

export default function EmailModal({ setOpen }) {
  const updateEmailMutation = useUpdateEmailMutation();

  const [emailValue, setEmailValue] = useState('');
  const [isSend, setIsSend] = useState(false);
  const [time, setTime] = useState(1000 * 60 * 5);

  useEffect(() => {
    const timer = setInterval((e) => {
      setTime((prev) => prev - 1000);
    }, 1000);

    return () => {
      clearInterval(timer);
    };
  }, [isSend]);

  function handleInpOnChange(e) {
    setEmailValue(e.target.value);
  }

  async function handleSendEmailBtnOnClick() {
    setTime(1000 * 60 * 5);
    setIsSend(true);
  }

  async function handleSaveEmailBtnOnClick() {
    await updateEmailMutation.mutateAsync(emailValue);
    await Swal.fire({
      titleText: '이메일이 변경되었습니다.',
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
          <CgMail />
        </span>
        <h2 css={s.headerTitle}>Set email address</h2>
        <p css={s.headerMsg}>
          변경할 이메일 주소를 입력하세요.
          <br />
          이후 인증 절차를 통해 이메일 변경이 완료됩니다.
        </p>
      </div>
      <div>
        <div css={s.inpGroup}>
          <label>Enter new email address</label>
          <div css={s.emailInpNBtn}>
            <input
              type="text"
              name="newEmail"
              id="newEmail"
              value={emailValue}
              onChange={handleInpOnChange}
            />
            {isSend ? (
              <span>{time}</span>
            ) : (
              <button
                type="button"
                css={s.setBtn}
                onClick={handleSendEmailBtnOnClick}
              >
                전송
              </button>
            )}
          </div>
        </div>

        <button
          type="button"
          css={s.setBtn}
          onClick={handleSaveEmailBtnOnClick}
          disabled={!emailValue}
        >
          Save email address
        </button>
      </div>
    </div>
  );
}
