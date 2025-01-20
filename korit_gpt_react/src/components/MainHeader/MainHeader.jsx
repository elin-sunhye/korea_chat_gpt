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
          <li>
            <Link to={'/list'}>
              <LuLayoutList />
              게시글 목록
            </Link>
          </li>
          <li>
            <Link to={'/write'}>
              <LuNotebookPen />
              게시글 작성
            </Link>
          </li>
        </ul>
      </div>
      <div css={s.rightContainer}>
        <ul>
          <li>
            <Link to={'/signin'}>
              <LuLogIn />
              로그인
            </Link>
          </li>
          <li>
            <Link to={'/signup'}>
              <LuUserRoundPlus />
              회원가입
            </Link>
          </li>
        </ul>
      </div>
    </div>
  );
}
