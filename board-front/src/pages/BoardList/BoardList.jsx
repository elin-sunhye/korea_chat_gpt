/** @jsxImportSource @emotion/react */
import * as s from './style';
import React from 'react';
import { BiSearch } from 'react-icons/bi';
import Select from 'react-select';
import { emptyBtn } from '../../styles/buttons';
import { GrView } from 'react-icons/gr';
import { FcLike } from 'react-icons/fc';
import { GoChevronLeft, GoChevronRight } from 'react-icons/go';
import { useSearchParams } from 'react-router-dom';
import { useGetSearchBoardList } from '../../queries/boardQuery';

export default function BoardList({}) {
  const [searchParams, setSearchParams] = useSearchParams();
  const page = parseInt(searchParams.get('page') || '1');
  const order = searchParams.get('order') || 'latest';
  const searchTxt = searchParams.get('searchTxt') || '';

  const getSearchBoardList = useGetSearchBoardList();

  const orderSelectOptions = [
    { value: 'latest', label: '최신순' },
    { value: 'asc', label: '오래된순' },
    { value: 'countDesc', label: '조회 많은 순' },
    { value: 'countAcs', label: '조회 적은 순' },
    { value: 'likeDesc', label: '좋아요 많은 순' },
    { value: 'likeAcs', label: '좋아요 적은 순' },
  ];

  return (
    <div css={s.container}>
      <div css={s.header}>
        <div css={s.title}>
          <h2>TITLE</h2>
        </div>
        <div css={s.searchBox}>
          <Select
            options={orderSelectOptions}
            styles={{
              control: (style) => ({
                ...style,
                width: '12rem',
                minHeight: 'unset',
                fontSize: '1.1rem',
              }),
              dropdownIndicator: (style) => ({
                ...style,
                padding: '0.3rem',
              }),
            }}
          />
          <div css={s.searchInpBox}>
            <input type="text" name="" id="" />
            <button type="button" css={emptyBtn}>
              <BiSearch />
            </button>
          </div>
        </div>
      </div>

      <div css={s.main}>
        <ul css={s.boardListContainer}>
          <li>
            <div>NO.</div>
            <div>Title</div>
            <div>Writer</div>
            <div>Count</div>
            <div>Date</div>
          </li>

          {getSearchBoardList.isLoading ||
            getSearchBoardList?.data?.data.boardSearchList.map(
              (board, boardIdx) => (
                <li key={`board_${boardIdx}`}>
                  <div>{board.boardId}</div>
                  <div>{board.title}</div>
                  <div css={s.boardWriter}>
                    <span>
                      <img
                        src={`http://localhost:8080/image/user/profile/${
                          board.profileImg || 'default.png'
                        }`}
                        alt="프로필 이미지"
                      />
                    </span>
                    <p>{board.nickname}</p>
                  </div>
                  <div css={s.boardCounts}>
                    <span>
                      <GrView />
                      <p>{board.viewCount}</p>
                    </span>
                    <span>
                      <FcLike />
                      <p>{board.likeCount}</p>
                    </span>
                  </div>
                  <div>{board.createdAt}</div>
                </li>
              )
            )}
        </ul>
      </div>
      <div css={s.footer}>
        <div css={s.pageNums}>
          <button type="button">
            <GoChevronLeft />
          </button>
          <button type="button" css={s.pageNum(page === 1)}>
            <span>1</span>
          </button>
          <button type="button" css={s.pageNum(page === 2)}>
            <span>2</span>
          </button>
          <button type="button" css={s.pageNum(page === 3)}>
            <span>3</span>
          </button>
          <button type="button" css={s.pageNum(page === 4)}>
            <span>4</span>
          </button>
          <button type="button" css={s.pageNum(page === 5)}>
            <span>5</span>
          </button>
          <button type="button">
            <GoChevronRight />
          </button>
        </div>
      </div>
    </div>
  );
}
