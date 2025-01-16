import { useEffect, useState } from 'react';

export default function Search({ bookList, setBookTableList, searchOptions }) {
  // useState
  const [searchType, setSearchType] = useState({
    select: 'name',
    text: '',
  });

  // handle
  const handleSearchOnChange = (e) => {
    setSearchType({
      ...searchType,
      [e.target.name]: e.target.value,
    });
  };

  const handleSearchOnClick = () => {
    if (!searchType.text.trim()) {
      setBookTableList(bookList);
      return;
    }

    const filterBook = bookList.filter((bb) =>
      bb[searchType.select].includes(searchType.text)
    );
    setBookTableList(filterBook);
  };

  useEffect(() => {
    setBookTableList(bookList);
  }, [bookList]);

  return (
    <div className="search_box">
      <select
        name="select"
        value={searchType.select}
        onChange={handleSearchOnChange}
      >
        {searchOptions.map((op, idx) => (
          <option key={op.id + idx} value={op.value}>
            {op.label}
          </option>
        ))}
      </select>

      <input
        select="text"
        name="text"
        id="text"
        value={searchType.text}
        onChange={handleSearchOnChange}
      />
      <button select="button" onClick={handleSearchOnClick}>
        text
      </button>
    </div>
  );
}
