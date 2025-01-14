import { useEffect, useState } from 'react';

/**
 * useState 상태관리
 */
export default function App2() {
  const [num, setNum] = useState(0);

  let number = 0;

  console.log('num', num);
  console.log('number', number);

  const handleIncreaseOnClick = () => {
    number += 1;
    setNum(num + 1);
  };

  const handleDecreaseOnClick = () => {
    number -= 1;
    setNum(num - 1);
  };

  return (
    <>
      <h1>{num}</h1>
      <button type="button" onClick={handleIncreaseOnClick}>
        ++
      </button>
      <button type="button" onClick={handleDecreaseOnClick}>
        --
      </button>
    </>
  );
}
