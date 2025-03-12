/** @jsxImportSource @emotion/react */
import { GrView } from 'react-icons/gr';
import * as s from './style';
import React, { useEffect, useRef } from 'react';
import { FcLike } from 'react-icons/fc';
import { useGetCategoryBaordList } from '../../queries/boardQuery';
import { useParams } from 'react-router-dom';

export default function CategoryBoardList({}) {
  const params = useParams();
  const loadMoreRef = useRef(null);

  const getCategoryBaordList = useGetCategoryBaordList(params.categoryName);

  useEffect(() => {
    console.log(getCategoryBaordList?.data);
  }, [getCategoryBaordList.data]);

  // observer
  useEffect(() => {
    const observerCallback = (entries) => {
      // console.log(entries);
      const [entry] = entries;
      if (entry.isIntersecting) {
        console.log('다음페이지 불러오기');
        getCategoryBaordList.fetchNextPage();
      }
    };
    const observerOption = {
      threshold: 1.0,
    };
    const observer = new IntersectionObserver(observerCallback, observerOption);

    observer.observe(loadMoreRef.current);
  }, []);

  return (
    <div css={s.scrollLayout}>
      {getCategoryBaordList.isLoading ||
        getCategoryBaordList?.data?.pages.map((page) =>
          page.data.boardSearchList.map((board, idx) => (
            <div key={`board_${idx}`} css={s.cardLayout}>
              <header>
                <div css={s.headerLeft}>
                  <span css={s.profileImgBox}>
                    <img
                      src={`http://localhost:8080/image/user/profile/${board.profileImg}`}
                      alt=""
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
              </header>
              <main>
                <h2 css={s.boardTitle}>{board.title}</h2>
              </main>
            </div>
          ))
        )}

      <div ref={loadMoreRef} css={s.observerBox}>
        observer-감시
      </div>
    </div>
  );
}
