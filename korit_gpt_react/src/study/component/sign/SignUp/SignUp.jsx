import { useState } from 'react';

export default function SignUp({ userList, setUserList }) {
  // useState ----------
  const [signUpValue, setSignUpValue] = useState({
    username: '',
    password: '',
    name: '',
    email: '',
  });

  // handle ----------
  const handleSignUpInputOnChange = (e) => {
    const { name, value } = e.target;
    setSignUpValue({
      ...signUpValue,
      [name]: value,
    });
  };
  const handleSignUpBtnOnClick = () => {
    // 중복 체크
    if (
      userList.find((username) => username.username === signUpValue.username)
    ) {
      alert('중복된 아이디가 있습니다.');
    } else {
      setUserList([...userList, signUpValue]);
      alert('회원가입 완료');
      setSignUpValue({
        username: '',
        password: '',
        name: '',
        email: '',
      });
    }
  };

  return (
    <div>
      <h1>SIGN UP</h1>

      <input
        type="text"
        name="username"
        placeholder="username"
        value={signUpValue.username}
        onChange={handleSignUpInputOnChange}
      />
      <input
        type="password"
        name="password"
        placeholder="password"
        value={signUpValue.password}
        onChange={handleSignUpInputOnChange}
      />
      <input
        type="text"
        name="name"
        placeholder="name"
        value={signUpValue.name}
        onChange={handleSignUpInputOnChange}
      />
      <input
        type="text"
        name="email"
        placeholder="email"
        value={signUpValue.email}
        onChange={handleSignUpInputOnChange}
      />

      <div>
        <button type="button" onClick={handleSignUpBtnOnClick}>
          sign-up
        </button>
      </div>
    </div>
  );
}
