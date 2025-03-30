import { useState } from 'react';

export default function SignIn({ userList }) {
  // useState ----------
  const [logInValue, setLogInValue] = useState({
    username: '',
    password: '',
  });

  // handle ----------
  const handleLogInInputOnChange = (e) => {
    const { name, value } = e.target;
    setLogInValue({
      ...logInValue,
      [name]: value,
    });
  };
  const handleLogInBtnOnClick = () => {
    // 유효성 검사
    const findName = userList.find(
      (user) =>
        user.username === logInValue.username &&
        user.password === logInValue.password
    );

    if (findName) {
      alert(`${findName.name} (${findName.email})님 환영합니다.`);

      setLogInValue({
        username: '',
        password: '',
      });
    } else {
      alert('사용자 정보를 다시 확인하세요');
    }
  };

  return (
    <div>
      <h1>LOG IN</h1>

      <input
        type="text"
        name="username"
        placeholder="username"
        value={logInValue.username}
        onChange={handleLogInInputOnChange}
      />
      <input
        type="password"
        name="password"
        placeholder="password"
        value={logInValue.password}
        onChange={handleLogInInputOnChange}
      />

      <div>
        <button type="button" onClick={handleLogInBtnOnClick}>
          log-in
        </button>
      </div>
    </div>
  );
}
