import { useEffect, useState } from 'react';

export default function App3() {
  // useState --------------------
  const [name, setName] = useState('');
  const [nameInputValue, setNameInputValue] = useState('');

  const [gender, setGender] = useState('');
  const [genderInputValue, setGenderInputValue] = useState('male');

  // handle --------------------
  const handleNameInputOnchange = (e) => {
    setNameInputValue(e.target.value);
    // console.log('nameInputValue', nameInputValue); - 아벤트가 실행되면 바로 찍힘 그래서 한 단계씩 느림
  };

  const handleGenderInputOnChange = (e) => {
    setGenderInputValue(e.target.id);
  };

  const handleConfirmOnClick = () => {
    setName(nameInputValue);
    setNameInputValue('');
    setGender(genderInputValue === 'male' ? '남' : '여');
  };

  // console.log('nameInputValue', nameInputValue); - 재랜더링 될 떄마다 찍힘

  // useEffect--------------------
  useEffect(() => {
    console.log('nameInputValue', nameInputValue);
  }, [nameInputValue]); // - nameInputTxt의 값이 변경 될 떄마다 찍힘!! 제일 정확한 방법

  useEffect(() => {
    console.log('name', name);
  }, [name]);

  return (
    <div>
      <h1>
        NAME : {name} ({gender})
      </h1>
      <input
        type="text"
        onChange={handleNameInputOnchange}
        value={nameInputValue}
      />
      <input
        type="radio"
        name="gender"
        id="male"
        value={'남'}
        checked={genderInputValue === 'male'}
        onChange={handleGenderInputOnChange}
      />
      <label htmlFor="male">남</label>
      <input
        type="radio"
        name="gender"
        id="female"
        value={'여'}
        checked={genderInputValue === 'female'}
        onChange={handleGenderInputOnChange}
      />
      <label htmlFor="female">여</label>
      <button type="button" onClick={handleConfirmOnClick}>
        confirm
      </button>
    </div>
  );
}
