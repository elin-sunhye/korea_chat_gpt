import { useState } from 'react';
import SignUp from './component/sign/SignUp/SignUp';
import SignIn from './component/sign/SignIn/SignIn';

export default function App6() {
  // useState ----------
  const [path, setPath] = useState('signin');

  const [userList, setUserList] = useState([]);

  // handle ----------
  const handlePageChangeBtnOnClick = (e, path) => {
    setPath(path);
  };

  return (
    <div>
      <button
        type="button"
        onClick={(e) => handlePageChangeBtnOnClick(e, 'signin')}
      >
        로그인
      </button>
      <button
        type="button"
        onClick={(e) => handlePageChangeBtnOnClick(e, 'signup')}
      >
        회원가입
      </button>

      {path === 'signin' ? (
        <SignIn userList={userList} />
      ) : (
        <SignUp userList={userList} setUserList={setUserList} />
      )}
    </div>
  );
}
