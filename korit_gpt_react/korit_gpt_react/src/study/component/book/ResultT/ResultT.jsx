import { useState } from 'react';
import Search from '../Search/Search';

export default function ResultT({ bookList }) {
  // search ----------
  // useState
  const [bookTableList, setBookTableList] = useState(bookList);

  // searchOptions
  const searchOptions = [
    {
      id: 1,
      label: '도서명',
      value: 'name',
    },
    {
      id: 2,
      label: '저자명',
      value: 'author',
    },
    {
      id: 3,
      label: '출판사',
      value: 'publisher',
    },
    {
      id: 4,
      label: '카테고리',
      value: 'category',
    },
  ];

  return (
    <div className="table_box">
      <Search
        bookList={bookList}
        setBookTableList={setBookTableList}
        searchOptions={searchOptions}
      />

      <table>
        <thead>
          <tr>
            {searchOptions.map((th, thIdx) => (
              <th key={`th_${thIdx}`}>{th.label}</th>
            ))}
          </tr>
        </thead>

        <tbody>
          {bookList.length === 0 || bookTableList.length === 0 ? (
            <tr>
              <td colSpan={4}>등록된 도서가 없습니다.</td>
            </tr>
          ) : (
            bookTableList.map((b, idx) => (
              <tr key={`book_${idx}`}>
                <td>{b.name}</td>
                <td>{b.author}</td>
                <td>{b.publisher}</td>
                <td>{b.category}</td>
              </tr>
            ))
          )}
        </tbody>
      </table>
    </div>
  );
}
