/** @jsxImportSource @emotion/react */
import { Link } from 'react-router-dom';
import * as s from './style';

import {
  LuUserRoundPlus,
  LuLogIn,
  LuLayoutList,
  LuNotebookPen,
} from 'react-icons/lu';

export default function MainHeader() {
  return (
    <div css={s.layout}>
      <div css={s.leftContainer}>
        <Link to={'/'}>
          <h1>미니 게시판 프로젝트</h1>
        </Link>
        <ul>
          <Link to={'/list'}>
            <li>
              <LuLayoutList />
              게시글 목록
            </li>
          </Link>
          <Link to={'/write'}>
            <li>
              <LuNotebookPen />
              게시글 작성
            </li>
          </Link>
        </ul>
      </div>
      <div css={s.rightContainer}>
        <ul>
          <Link to={'/signin'}>
            <li>
              <LuLogIn />
              로그인
            </li>
          </Link>
          <Link to={'/signup'}>
            <li>
              <LuUserRoundPlus />
              회원가입
            </li>
          </Link>
        </ul>
      </div>
    </div>
  );
}
