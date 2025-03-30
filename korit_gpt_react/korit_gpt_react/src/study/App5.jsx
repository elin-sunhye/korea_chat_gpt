import { useEffect } from 'react';
import { useState } from 'react';

export default function App5() {
  /**
   * 회원정보를 입력받아 userList에 user 객체들을 가입하기 버튼 누를떄마다 저장
   * 로그인 정보를 입력받아 userList에 해당 username이 있는지 검사
   * 없으면 '사용자 정보를 다시 확인하세요' alert
   * 있으면 비밀번호 일치하는지 검사
   * 비밀번호가 일치하지 않으면 '사용자 정보를 다시 확인하세요' alert
   * 일치하면 이름(이메일)님 환영합니다. alert
   */

  // useState ----------
  const [userList, setUserList] = useState([]);

  // sign_up
  const [signUpValue, setSignUpValue] = useState({
    username: '',
    password: '',
    name: '',
    email: '',
  });

  // log_in
  const [logInValue, setLogInValue] = useState({
    username: '',
    password: '',
  });

  // handle ----------
  // sign_up
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

  // log_in
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

  // useEffect ----------
  useEffect(() => {
    console.log('userList', userList);
  }, [userList]);

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
