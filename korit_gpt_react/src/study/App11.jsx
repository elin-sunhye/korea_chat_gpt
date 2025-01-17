import { useState } from 'react';

/**
 * Promise -> async / await
 * async / await
 * ; async/await는 Promise를 더 간단하고 동기처럼 보이게 작성할 수 있는 문법
 * try, catch, finally
 * 표현식
    try {
      const result = await someAsyncFunction();
      console.log("Result:", result);
    } catch (error) {
      console.error("Error:", error);
    } finally {
      console.log("Cleanup or final actions.");
    }
 */
export default function App11() {
  const findUserByUsername = (username) => {
    const userList = [
      { username: 'aaa', password: '111' },
      { username: 'bbb', password: '222' },
      { username: 'ccc', password: '333' },
    ];

    return userList.find((user) => user.username === username);
  };

  const getUserAPI = (url, params) => {
    return new Promise((resolve, reject) => {
      console.log(`서버에 ${url}?${params} 요청`);

      const foundUser = findUserByUsername(params.username);

      if (!!foundUser) {
        resolve(foundUser);
      } else {
        reject(new Error('해당 사용자 정보를 찾을 수 없습니다.'));
      }
    });
  };

  const [usernameInp, setUsernameInp] = useState('');

  const handleUsernameInpOnChange = (e) => {
    console.log(e.target.value);
    setUsernameInp(e.target.value);
  };

  const handleSearchOnClick = () => {
    getUserAPI('http://localhost:8080/user', {
      username: usernameInp,
    })
      .then((res) => {
        console.log(res);
      })
      .catch((e) => {
        console.error(e);
      });
  };

  return (
    <div>
      <input
        type="text"
        placeholder="username"
        value={usernameInp}
        onChange={handleUsernameInpOnChange}
      />
      <button type="button" onClick={handleSearchOnClick}>
        FIND
      </button>
    </div>
  );
}
