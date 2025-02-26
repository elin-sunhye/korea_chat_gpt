/** @jsxImportSource @emotion/react */
import * as s from './style';
import React from 'react';
import { FiChevronsLeft } from 'react-icons/fi';
import { basicBtn } from '../../../styles/buttons';
import { emptyBtn } from '../../../styles/buttons';
import { useRecoilState } from 'recoil';
import { mainSidebarIsOpenState } from '../../../atoms/mainSidebarAtom';
import { LuLockKeyhole } from 'react-icons/lu';
import { useUserMeQuery } from '../../../queries/useUserMeQuery';
import { useNavigate } from 'react-router-dom';

export default function MainSidebar() {
  const navigate = useNavigate();
  const loginUser = useUserMeQuery();

  const [isOpen, setIsOpen] = useRecoilState(mainSidebarIsOpenState);

  const handleSidebarClose = (e) => {
    setIsOpen(!isOpen);
  };

  const handleLoginBtnOnClick = (e) => {
    navigate('/auth/login');
  };
  const handleAccountBtnOnClick = (e) => {
    navigate('/account/setting');
  };

  return (
    <div css={s.layout(isOpen)}>
      <div css={s.container}>
        <div css={s.groupLayout}>
          <div css={s.topGroup}>
            <div css={s.user}>
              {loginUser.isError ? (
                <button
                  type="button"
                  css={emptyBtn}
                  onClick={handleLoginBtnOnClick}
                >
                  <span css={s.authText}>
                    <LuLockKeyhole />
                    로그인 후 이용하기
                  </span>
                </button>
              ) : (
                <button
                  type="button"
                  css={emptyBtn}
                  onClick={handleAccountBtnOnClick}
                >
                  <span css={s.authText}>
                    <span css={s.profileImgBox}>
                      {!loginUser.isLoading && (
                        <img
                          src={`http://localhost:8080/image/user/profile/${loginUser?.data?.data.profileImg}`}
                          alt="프로필 이미지"
                        />
                      )}
                    </span>
                    {loginUser.data?.data?.nickname}
                  </span>
                </button>
              )}
            </div>
            <button type="button" css={basicBtn} onClick={handleSidebarClose}>
              <FiChevronsLeft />
            </button>
          </div>
        </div>
      </div>
    </div>
  );
}
