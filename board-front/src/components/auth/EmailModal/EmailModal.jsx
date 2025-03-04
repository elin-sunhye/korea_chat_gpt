/** @jsxImportSource @emotion/react */
import * as s from './style';
import React, { useEffect, useState } from 'react';
import { CgMail } from 'react-icons/cg';
import { RiCloseCircleFill } from 'react-icons/ri';
import {
  useSendVerificationEmailMutation,
  useUpdateEmailMutation,
} from '../../../mutations/accountMutation';
import Swal from 'sweetalert2';
import { useQueryClient } from '@tanstack/react-query';

export default function EmailModal({ setOpen }) {
  const queryClient = useQueryClient();

  const sendVerificationEmailMutation = useSendVerificationEmailMutation();
  const updateEmailMutation = useUpdateEmailMutation();

  const [isSend, setIsSend] = useState(false);
  const [time, setTime] = useState(60 * 5);

  const [emailValue, setEmailValue] = useState('');
  const [verifyCodeInpValue, setVerifyCodeInpValue] = useState({
    one: '',
    two: '',
    three: '',
    four: '',
    five: '',
    six: '',
  });
  const [verifyCode, setVerifyCode] = useState('');

  useEffect(() => {
    const timer = setInterval((e) => {
      setTime((prev) => (prev > 0 ? prev - 1 : 0));
    }, 1000);

    return () => {
      clearInterval(timer);
    };
  }, [isSend]);

  useEffect(() => {
    if (time === 0) {
      Swal.fire({
        showConfirmButton: true,
        confirmButtonText: '확인',
        titleText: '인증 시간이 만료되었습니다.',
      }).then(() => {
        setOpen(false);
      });
    }
  }, [time]);

  function handleInpOnChange(e) {
    setEmailValue(e.target.value);
  }

  async function handleSendVerificationEmailBtnOnClick() {
    setTime(60 * 5);
    setIsSend(true);

    const resp = await sendVerificationEmailMutation.mutateAsync(emailValue);
    setVerifyCode(String(resp.data).padStart(6, '0'));
  }

  async function handleVerifyCdoeInpOnChange(e) {
    setVerifyCodeInpValue((prev) => {
      if (/^[0-9]?$/.test(e.target.value)) {
        return { ...prev, [e.target.name]: e.target.value };
      } else {
        return { ...prev };
      }
    });
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
              <span>
                {Math.floor(time / 60)
                  .toString()
                  .padStart(2, '0')}{' '}
                : {(time % 60).toString().padStart(2, '0')}
              </span>
            ) : (
              <button
                type="button"
                css={s.setBtn}
                onClick={handleSendVerificationEmailBtnOnClick}
              >
                전송
              </button>
            )}
          </div>
        </div>

        {isSend && (
          <div css={s.inpGroup}>
            <div css={s.verifyInp}>
              <input
                type="number"
                name="one"
                id="code"
                value={verifyCodeInpValue.one}
                onChange={handleVerifyCdoeInpOnChange}
              />
              <input
                type="number"
                name="two"
                id="code"
                value={verifyCodeInpValue.two}
                onChange={handleVerifyCdoeInpOnChange}
              />
              <input
                type="number"
                name="three"
                id="code"
                value={verifyCodeInpValue.three}
                onChange={handleVerifyCdoeInpOnChange}
              />
              <input
                type="number"
                name="four"
                id="code"
                value={verifyCodeInpValue.four}
                onChange={handleVerifyCdoeInpOnChange}
              />
              <input
                type="number"
                name="five"
                id="code"
                value={verifyCodeInpValue.five}
                onChange={handleVerifyCdoeInpOnChange}
              />
              <input
                type="number"
                name="six"
                id="code"
                value={verifyCodeInpValue.six}
                onChange={handleVerifyCdoeInpOnChange}
              />
            </div>
          </div>
        )}

        <button
          type="button"
          css={s.setBtn}
          onClick={async () => {
            const inpCodes =
              verifyCodeInpValue.one +
              verifyCodeInpValue.two +
              verifyCodeInpValue.three +
              verifyCodeInpValue.four +
              verifyCodeInpValue.five +
              verifyCodeInpValue.six;

            if (String(verifyCode) !== inpCodes) {
              await Swal.fire({
                titleText: '인증번호가 일치하지 않습니다.',
                showConfirmButton: true,
                confirmButtonText: '확인',
                confirmButtonColor: '#d02121',
              });
              return;
            }

            await updateEmailMutation.mutateAsync(emailValue);

            await Swal.fire({
              titleText: '이메일이 변경되었습니다.',
              icon: 'success',
              showConfirmButton: false,
              timer: 1000,
            });

            await queryClient.invalidateQueries({
              queryKey: ['useUserMeQuery'],
            });

            setOpen(false);
          }}
          disabled={
            !emailValue || Object.values(verifyCodeInpValue).includes('')
          }
        >
          Save email address
        </button>
      </div>
    </div>
  );
}
