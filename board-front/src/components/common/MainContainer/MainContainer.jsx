/** @jsxImportSource @emotion/react */
import { useRecoilState } from 'recoil';
import * as s from './style';
import React from 'react';
import { mainSidebarIsOpenState } from '../../../atoms/mainSidebarAtom';
import { FiChevronsRight } from 'react-icons/fi';
import { basicBtn } from '../../../styles/buttons';

export default function MainContainer({ children }) {
  const [isOpen, setIsOpen] = useRecoilState(mainSidebarIsOpenState);

  const handleSidebarOpen = (e) => {
    setIsOpen(!isOpen);
  };
  return (
    <div css={s.container}>
      <header css={s.header}>
        {!isOpen && (
          <span css={s.sidebarOpenBtn}>
            <button type="button" css={basicBtn} onClick={handleSidebarOpen}>
              <FiChevronsRight />
            </button>
          </span>
        )}
      </header>
      <main css={s.main}>{children}</main>
    </div>
  );
}
