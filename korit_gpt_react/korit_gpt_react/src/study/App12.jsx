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
export default function App12() {
  const getUser = (username) => {
    const userList = [
      {
        username: 'aaa',
        name: '김선혜',
      },
      {
        username: 'bbb',
        name: '안형우',
      },
    ];

    return new Promise((resolve, reject) => {
      const foundUser = userList.find((u) => u.username === username);

      if (!!foundUser) {
        resolve({ user: foundUser });
      } else {
        reject(new Error('사용자를 찾을 수 없습니다.'));
      }
    });
  };

  const generateToken = (user) => {
    return new Promise((resolve, reject) => {
      if (!!user) {
        resolve('new Token');
      } else {
        reject(new Error('Fail to make Token'));
      }
    });
  };

  const generateToken2 = async (user) => {
    if (!user) {
      throw new Error('Fail to make Token');
    }
    return '새로운 토큰이야';
  };

  const [username, setUsername] = useState('');

  const handleUsernameOnChange = (e) => {
    setUsername(e.target.value);
  };

  const handleBtnOnClick1 = () => {
    let user = null;

    getUser(username)
      .then((res) => {
        user = res;
        generateToken(user).then((token) => console.log(token));
      })
      .catch((e) => console.error(e));

    // generateToken(user).then((token) => console.log(token));
  };

  /**
   * Promise -> async / await ----------
   * async 키워드를 함수에 사용하면 return 자료형이 promise객제가 된다
   *
   * 사용 조건
   * - await은 async 함수 안에서만 사용 가능
   * - await은 promise를 return 하는 함수에만 사용 가능
   *    === promise 객체 앞에 사용 할 수 있다.
   */
  // async function handleBtnOnClick2() {
  //   const result = await getUser(username);
  //   const token = await generateToken(result);
  // }
  const handleBtnOnClick2 = async () => {
    try {
      const result = await getUser(username);
      console.log('result', result);

      // const token = generateToken(result); -> promise 객체 자체를 token 이라는 변수에 할당
      // const token = await generateToken(result); -> await을 붙이면 resolve를 변수에 할당
      const token = await generateToken2(result); // -> promise를 async / awate로 변경하여 할당
      console.log('token', token);
    } catch (e) {
      console.error(e);
    }
  };

  return (
    <div>
      <input
        type="text"
        placeholder="username"
        value={username}
        onChange={handleUsernameOnChange}
      />
      <button type="button" onClick={handleBtnOnClick1}>
        11Create TOKEN11
      </button>
      <button type="button" onClick={handleBtnOnClick2}>
        22Create TOKEN22
      </button>
    </div>
  );
}
