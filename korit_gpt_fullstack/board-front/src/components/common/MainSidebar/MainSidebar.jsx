/** @jsxImportSource @emotion/react */
import * as s from './style';
import React from 'react';
import { FiChevronsLeft } from 'react-icons/fi';
import { basicBtn } from '../../../styles/buttons';
import { emptyBtn } from '../../../styles/buttons';
import { useRecoilState } from 'recoil';
import { mainSidebarIsOpenState } from '../../../atoms/mainSidebarAtom';
import { useNavigate } from 'react-router-dom';
import { BiEdit, BiLogOut } from 'react-icons/bi';
import { setLocalStorage } from '../../../configs/axiosConfig';
import { useQueryClient } from '@tanstack/react-query';
import Swal from 'sweetalert2';
import { useGetCategories } from '../../../queries/boardQuery';

export default function MainSidebar() {
  const navigate = useNavigate();
  const queryClicnet = useQueryClient();
  const userData = queryClicnet.getQueryData(['useUserMeQuery']);
  const categories = useGetCategories();

  const [isOpen, setIsOpen] = useRecoilState(mainSidebarIsOpenState);
  const handleSidebarClose = (e) => {
    setIsOpen(!isOpen);
  };

  const handleAccountBtnOnClick = (e) => {
    navigate('/account/setting');
  };

  const handleWirteBtnOnClick = async (categoryName) => {
    if (!categoryName) {
      const categoryData = await Swal.fire({
        titleText: '카테고리명을 선택헤주세요.',
        input: 'text',
        inputPlaceholder: ' Enter category name',
        showConfirmButton: true,
        confirmButtonText: '작성하기',
        showCancelButton: true,
        cancelButtonText: '취소하기',
      });

      if (categoryData.isConfirmed) {
        categoryName = categoryData.value;
      } else {
        return;
      }
    }

    navigate(`/board/write/${categoryName}`);
  };

  return (
    <div css={s.layout(isOpen)}>
      <div css={s.container}>
        <div>
          <div css={s.groupLayout}>
            <div css={s.topGroup}>
              <div css={s.user}>
                <button
                  type="button"
                  css={emptyBtn}
                  onClick={handleAccountBtnOnClick}
                >
                  <span css={s.authText}>
                    <span css={s.profileImgBox}>
                      <img
                        src={`http://localhost:8080/image/user/profile/${userData?.data.profileImg}`}
                        alt="프로필 이미지"
                      />
                    </span>
                    <span css={s.profileNicknameBox}>
                      {userData?.data.nickname}
                    </span>
                  </span>
                </button>
              </div>
              <button type="button" css={basicBtn} onClick={handleSidebarClose}>
                <FiChevronsLeft />
              </button>
            </div>
          </div>
          <div css={s.groupLayout}>
            <button
              type="button"
              css={emptyBtn}
              onClick={() => {
                navigate('/board/list');
              }}
            >
              <span>전체 게시글</span>
            </button>
          </div>
          <div css={s.groupLayout}>
            <button type="button" css={emptyBtn}>
              <span>공지사항</span>
            </button>
          </div>
          <div css={s.groupLayout}>
            <div css={s.categoryItem}>
              <button type="button" css={emptyBtn}>
                내가 작성한 글 (
                {categories.isLoading ||
                  categories.data.data.reduce(
                    (prev, category) => prev + category.boardCount,
                    0
                  )}
                )
              </button>
              <button
                type="button"
                css={basicBtn}
                onClick={() => handleWirteBtnOnClick()}
              >
                <BiEdit />
              </button>
            </div>
          </div>
        </div>

        <div css={s.categoryListContatiner}>
          {categories.isLoading ||
            categories?.data?.data.map((category, caIdx) => (
              <div
                key={`category_${caIdx}_${category.boardCategoryId}`}
                css={s.groupLayout}
              >
                <div css={s.categoryItem}>
                  <button type="button" css={emptyBtn}>
                    {category.boardCategoryName} ({category.boardCount})
                  </button>
                  <button
                    type="button"
                    css={basicBtn}
                    onClick={() =>
                      handleWirteBtnOnClick(category.boardCategoryName)
                    }
                  >
                    <BiEdit />
                  </button>
                </div>
              </div>
            ))}
        </div>

        <div>
          <div css={s.groupLayout}>
            <button
              type="button"
              css={emptyBtn}
              onClick={async () => {
                setLocalStorage('AccessToken', null);
                // .removeQueries 하면 다시 재요청을 안하기 때문에 .invalidateQueries로 실행
                await queryClicnet.invalidateQueries({
                  queryKey: ['useUserMeQuery'],
                });
                navigate('/auth/login');
              }}
            >
              <span css={s.authText}>
                <BiLogOut />
                Logout
              </span>
            </button>
          </div>
        </div>
      </div>
    </div>
  );
}
