import { useState } from 'react';

export default function App4() {
  // useState --------------------
  const [userInfo, setUserInfo] = useState({
    name: '',
    gender: '',
  });

  const [inputValue, setInputValue] = useState({
    name: '',
    gender: 'male',
  });

  // handle --------------------
  const handleInputOnchange = (e) => {
    const { name, value } = e.target;

    setInputValue({
      ...inputValue,
      [name]: value,
    });
  };

  const handleConfirmOnClick = () => {
    setUserInfo({
      name: inputValue.name,
      gender: inputValue.gender === 'male' ? '남' : '여',
    });

    setInputValue({
      // ...inputValue,
      name: '',
      gender: 'male',
    });
  };

  return (
    <div>
      <h1>
        NAME : {userInfo.name} ({userInfo.gender})
      </h1>
      <input
        type="text"
        name="name"
        value={inputValue.name}
        onChange={handleInputOnchange}
      />
      <input
        type="radio"
        name="gender"
        value={'male'}
        checked={inputValue.gender === 'male'}
        onChange={handleInputOnchange}
      />
      <label htmlFor="male">남</label>
      <input
        type="radio"
        name="gender"
        value={'female'}
        checked={inputValue.gender === 'female'}
        onChange={handleInputOnchange}
      />
      <label htmlFor="female">여</label>
      <button type="button" onClick={handleConfirmOnClick}>
        confirm
      </button>
    </div>
  );
}
