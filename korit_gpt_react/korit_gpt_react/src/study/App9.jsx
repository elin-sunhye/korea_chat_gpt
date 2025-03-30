import { useEffect, useState } from 'react';

export default function App9() {
  const [num1, setNum1] = useState(0);
  const [num2, setNum2] = useState(0);

  const handleOnClick = () => {
    setNum1(num1 + 10);
  };

  useEffect(() => {
    if (num1 !== 0) {
      setNum2(num1 + 100);
    }
  }, [num1]);

  const unmount = () => {
    console.log('장착 해제됨');
  };
  const mount = () => {
    console.log('장착됨3');

    return unmount;
  };

  useEffect(mount);

  console.log('?????');

  return (
    <>
      <h1>Num1 : {num1}</h1>
      <h1>Num2 : {num2}</h1>

      <button type="button" onClick={handleOnClick}>
        CLICK
      </button>
    </>
  );
}
