import { useState } from 'react';
import './style/app7.css';
import Register from './component/book/Register/Register';
import ResultT from './component/book/ResultT/ResultT';

/**
 * 도서정보 등록 및 조회
 *
 * 도서명, isbn, 저자명, 출판사명, 카테고리 입력
 * bookList 저장
 *
 * 조건
 * 1. 컴포넌트 2개로 분리
 * 2. <table></table>
 * 3. 검색 기능 (+ 어떤 기준 검색인지 : 셀렉트 박스로 선택: 도서명, 출판사, 저자명..)
 */
export default function App7() {
  // useState ----------
  const [bookList, setBookList] = useState([]);

  return (
    <div className="container">
      <div>
        <h1>도서 등록</h1>
        <Register bookList={bookList} setBookList={setBookList} />
      </div>

      <div>
        <h1>도서 조회</h1>
        <ResultT bookList={bookList} />
      </div>
    </div>
  );
}
