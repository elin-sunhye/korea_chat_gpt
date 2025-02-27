/** @jsxImportSource @emotion/react */
import * as s from './style';
import React, { useEffect, useState } from 'react';
import { useUserMeQuery } from '../../queries/useUserMeQuery';
import {
  useUpadteProfileImgMutation,
  useUpdateNicknameMutation,
} from '../../mutations/accountMutation';
import ReactModal from 'react-modal';
import PwModal from '../../components/auth/PwModal/PwModal';
import { api } from '../../configs/axiosConfig';

export default function Account({}) {
  const loginUser = useUserMeQuery();
  const upadteProfileImgMutation = useUpadteProfileImgMutation();
  const updateNicknameMutation = useUpdateNicknameMutation();

  const [nickNameValue, setNickNameValue] = useState('');
  const [pwModalOpen, setPwModalOpen] = useState(false);

  useEffect(() => {
    setNickNameValue(loginUser?.data?.data.nickname || '');
  }, [loginUser.isFetched]);

  const handleProfileImgFileOnChange = async (e) => {
    const file = e.target.files[0];

    if (!file) {
      return;
    }

    const formData = new FormData();
    formData.append('file', file);
    await upadteProfileImgMutation.mutateAsync(formData);

    loginUser.refetch();
  };

  const handleNicknameInpOnChange = (e) => {
    setNickNameValue(e.target.value);
  };

  const handleSaveNicknameBtnOnClick = async (e) => {
    if (nickNameValue === '') {
      return;
    }

    await updateNicknameMutation.mutateAsync(nickNameValue);

    loginUser.refetch();
  };

  const handleChangePasswordBtnOnClick = (e) => {
    setPwModalOpen(!pwModalOpen);
  };

  return (
    <div css={s.container}>
      <h2 css={s.title}>Account</h2>
      <div css={s.accountBox}>
        <label css={s.imgBox}>
          {!loginUser.isLoading && (
            <img
              src={`http://localhost:8080/image/user/profile/${loginUser?.data?.data.profileImg}`}
              alt="프로필 이미지"
            />
          )}

          <input
            type="file"
            name="profile"
            id="profile"
            onChange={handleProfileImgFileOnChange}
          />
        </label>
        <div>
          <h3 css={s.nicknameTitle}>Preferred nickname</h3>
          <div>
            <input
              type="text"
              name="nickname"
              id="nickname"
              css={s.txtInp}
              value={nickNameValue}
              onChange={handleNicknameInpOnChange}
            />
            <button
              type="button"
              css={s.saveBtn}
              onClick={handleSaveNicknameBtnOnClick}
              disabled={loginUser?.data?.data.nickname === nickNameValue}
            >
              Save nickname
            </button>
          </div>
        </div>
      </div>

      <h2 css={s.title}>Account Security</h2>
      <div>
        <div css={s.itemGroup}>
          <div>
            <h3 css={s.subTitle}>Email</h3>
            <p css={s.subCont}>{loginUser?.data?.data.email || ''}</p>
          </div>
          <button
            type="button"
            css={s.borerBtn}
            onClick={(e) =>
              api.post('/api/auth/email', {
                email: 'tjsgp1401@naver.com',
                username: 'aaa13',
              })
            }
          >
            Change email
          </button>
        </div>
        <div css={s.itemGroup}>
          <div>
            <h3 css={s.subTitle}>Password</h3>
            <p css={s.subCont}>계정에 로그인 할 영구 비밀번호를 설정합니다.</p>
          </div>
          <button
            type="button"
            css={s.borerBtn}
            onClick={handleChangePasswordBtnOnClick}
          >
            Change password
          </button>
        </div>
      </div>

      <ReactModal
        isOpen={pwModalOpen}
        onRequestClose={() => setPwModalOpen(!pwModalOpen)}
        style={{
          overlay: {
            display: 'flex',
            justifyContent: 'center',
            alignItems: 'center',
            backgroundColor: '#00000066',
          },
          content: {
            position: 'static',
            boxSizing: 'border-box',
            borderRadius: '1.5rem',
            width: '37rem',
            height: 'auto',
          },
        }}
      >
        <PwModal setOpen={setPwModalOpen} />
      </ReactModal>
    </div>
  );
}
