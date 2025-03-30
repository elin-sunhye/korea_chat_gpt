/** @jsxImportSource @emotion/react */
import * as s from './style';
import React, { useEffect, useState } from 'react';
import { BiSearch } from 'react-icons/bi';
import Select from 'react-select';
import { emptyBtn } from '../../styles/buttons';
import { GrView } from 'react-icons/gr';
import { FcLike } from 'react-icons/fc';
import { GoChevronLeft, GoChevronRight } from 'react-icons/go';
import { useNavigate, useSearchParams } from 'react-router-dom';
import { useGetSearchBoardList } from '../../queries/boardQuery';
import { useQueryClient } from '@tanstack/react-query';

export default function BoardList({}) {
  const navigate = useNavigate();
  const queryClient = useQueryClient();
  const [searchParams, setSearchParams] = useSearchParams();

  const page = parseInt(searchParams.get('page') || '1');
  const order = searchParams.get('order') || 'desc';
  const searchTxt = searchParams.get('searchTxt') || '';
  const [pageNums, setPageNums] = useState([]);
  const [searchTxtValue, setSearchTxtValue] = useState(searchTxt);

  const orderSelectOptions = [
    { value: 'desc', label: '최신순' },
    { value: 'asc', label: '오래된순' },
    { value: 'countDesc', label: '조회 많은 순' },
    { value: 'countAcs', label: '조회 적은 순' },
    { value: 'likeDesc', label: '좋아요 많은 순' },
    { value: 'likeAcs', label: '좋아요 적은 순' },
  ];

  const getSearchBoardList = useGetSearchBoardList({
    page,
    limitCount: 15,
    order,
    searchTxt,
  });
  useEffect(() => {
    if (!getSearchBoardList.isLoading) {
      const currentPage = getSearchBoardList?.data?.data.page || 1;
      const totalPages = getSearchBoardList?.data?.data.totalPages || 1;
      const startIdx = Math.floor((currentPage - 1) / 5) * 5 + 1; // 0~4, 5~9...
      const endIdx = startIdx + 4 > totalPages ? totalPages : startIdx + 4;

      let newPageNums = [];
      for (let i = startIdx; i <= endIdx; i++) {
        newPageNums = [...newPageNums, i];
      }
      setPageNums(newPageNums);
    }
  }, [getSearchBoardList.data]);

  useEffect(() => {
    getSearchBoardList.refetch();
  }, [searchParams]);

  function handlepagingOnClick(num) {
    searchParams.set('page', num);
    setSearchParams(searchParams);
  }

  function handleOrderSelectOnChange(option) {
    searchParams.set('order', option.value);
    setSearchParams(searchParams);
  }

  function handleSearchTxtInpOnEvent() {
    searchParams.set('page', 1);
    searchParams.set('searchTxt', searchTxtValue);
    setSearchParams(searchParams);
  }

  return (
    <div css={s.container}>
      <div css={s.header}>
        <div css={s.title}>
          <h2>전체 게시글</h2>
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
            value={orderSelectOptions.find((option) => option.value === order)}
            onChange={(option) => handleOrderSelectOnChange(option)}
          />
          <div css={s.searchInpBox}>
            <input
              type="text"
              name="searchTxt"
              id="searchTxt"
              placeholder={'검색어 입력'}
              value={searchTxtValue}
              onChange={(e) => setSearchTxtValue(e.target.value)}
              onKeyUp={(e) => {
                if (e.key === 'Enter') {
                  handleSearchTxtInpOnEvent();
                }
              }}
            />
            <button
              type="button"
              css={emptyBtn}
              onClick={handleSearchTxtInpOnEvent}
            >
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
          <button
            type="button"
            disabled={getSearchBoardList?.data?.data.firstPage}
            onClick={() => handlepagingOnClick(page - 1)}
          >
            <GoChevronLeft />
          </button>
          {pageNums.map((num, idx) => (
            <button
              type="button"
              key={`paging_${idx}`}
              css={s.pageNum(page === num)}
              onClick={() => handlepagingOnClick(num)}
            >
              <span>{num}</span>
            </button>
          ))}
          <button
            type="button"
            disabled={getSearchBoardList?.data?.data.lastPage}
            onClick={() => handlepagingOnClick(page + 1)}
          >
            <GoChevronRight />
          </button>
        </div>
      </div>
    </div>
  );
}
