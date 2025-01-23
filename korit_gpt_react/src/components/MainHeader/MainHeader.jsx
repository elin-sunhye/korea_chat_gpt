/** @jsxImportSource @emotion/react */
import { Link } from 'react-router-dom';
import * as s from './style';

import {
  LuUserRoundPlus,
  LuUser,
  LuLogIn,
  LuLogOut,
  LuLayoutList,
  LuNotebookPen,
} from 'react-icons/lu';
import axios from 'axios';
import { useQuery, useQueryClient } from 'react-query';

export default function MainHeader() {
  const queryClient = useQueryClient();
  const userId = queryClient.getQueryData(['authenticatedUserQuery'])?.data
    .body;

  const getUserApi = async () => {
    return await axios.get('http://localhost:8080/servlet_study_war/api/user', {
      headers: {
        Authorization: 'Bearer ' + localStorage.getItem('AccessToken'),
      },
      params: {
        userId: userId,
      },
    });
  };

  const getUserQuery = useQuery(['getUserQuery', userId], getUserApi, {
    refetchOnWindowFocus: false,
    enabled: !!userId,
  });

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
        {!!userId ? (
          <ul>
            <li>
              <Link to={'/mypage'}>
                <LuUser />
                {getUserQuery.isLoading ? '' : getUserQuery.data.data.username}
              </Link>
            </li>
            <li>
              <Link to={'/logout'}>
                <LuLogOut />
                로그아웃
              </Link>
            </li>
          </ul>
        ) : (
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
        )}
      </div>
    </div>
  );
}
