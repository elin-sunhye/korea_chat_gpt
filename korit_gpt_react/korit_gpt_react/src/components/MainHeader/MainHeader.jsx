/** @jsxImportSource @emotion/react */
import { Link, useNavigate } from 'react-router-dom';
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
import { useSetRecoilState } from 'recoil';
import { accessTokenAtomState } from '../../atoms/authAtom';

export default function MainHeader() {
  const navigator = useNavigate();
  const setAccessToken = useSetRecoilState(accessTokenAtomState);
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

  const handleLogoutOnClick = () => {
    localStorage.removeItem('AccessToken');
    // invalidateQueries 만료 시켜라 === 캐시 지워라 업테이트할떄 사용 (로그인)
    // queryClient.invalidateQueries(['authenticatedUserQuery'], {
    //   refetchType: 'active',
    // });
    queryClient.removeQueries(['authenticatedUserQuery']);

    // 모든 queryClient 상태를 지워버림
    // queryClient.clear();
    // 쿼리 자체를 날림
    // queryClient.removeQueries();
    setAccessToken(localStorage.getItem('AccessToken'));
    navigator('/signin');
  };

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
                {getUserQuery.isLoading
                  ? ''
                  : getUserQuery.data.data.body.username}
              </Link>
            </li>
            <li>
              <a onClick={handleLogoutOnClick}>
                <LuLogOut />
                로그아웃
              </a>
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
