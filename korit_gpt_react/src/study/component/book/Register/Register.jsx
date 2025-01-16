import { useState } from 'react';

export default function Register({ bookList, setBookList }) {
  // useState ----------
  const [registerInputValue, setRegisterInputValue] = useState({
    name: '',
    author: '',
    publisher: '',
    category: '',
  });

  // handle ----------
  const handleBookInpOnChange = (e) => {
    setRegisterInputValue({
      ...registerInputValue,
      [e.target.id]: e.target.value,
    });
  };
  const handleRegisterBtnOnClick = () => {
    // 중복확인
    if (
      bookList.find(
        (b) =>
          b.name === registerInputValue.name &&
          b.author === registerInputValue.author &&
          b.publisher === registerInputValue.publisher &&
          b.category === registerInputValue.category
      )
    ) {
      alert('이미 등록된 도서');
    } else {
      setBookList([...bookList, registerInputValue]);

      alert('등록 완료');

      setRegisterInputValue({
        name: '',
        author: '',
        publisher: '',
        category: '',
      });
    }
  };

  return (
    <div className="register_box">
      <div className="row">
        <label htmlFor="name">name</label>
        <input
          type="text"
          name="registerInputValue"
          id="name"
          placeholder="name"
          value={registerInputValue.name}
          onChange={handleBookInpOnChange}
        />
      </div>
      <div className="row">
        <label htmlFor="author">author</label>
        <input
          type="text"
          name="registerInputValue"
          id="author"
          placeholder="author"
          value={registerInputValue.author}
          onChange={handleBookInpOnChange}
        />
      </div>
      <div className="row">
        <label htmlFor="publisher">publisher</label>
        <input
          type="text"
          name="registerInputValue"
          id="publisher"
          placeholder="publisher"
          value={registerInputValue.publisher}
          onChange={handleBookInpOnChange}
        />
      </div>
      <div className="row">
        <label htmlFor="category">category</label>
        <input
          type="text"
          name="registerInputValue"
          id="category"
          placeholder="category"
          value={registerInputValue.category}
          onChange={handleBookInpOnChange}
        />
      </div>

      <button type="button" onClick={handleRegisterBtnOnClick}>
        register
      </button>
    </div>
  );
}
