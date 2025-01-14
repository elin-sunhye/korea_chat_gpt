import React from 'react';
import './style.css';

/**
 * 컴포넌트 내 export 'default'는 하나만!
 */

export function printConsole() {
  console.log('hello2 파일 입니다.');
}

export function printConsole2() {
  console.log('hello2 파일 입니다.2');
}

export default function Hello2() {
  const h1Txt = 'Hi react';
  const h1 = <h1>{h1Txt}</h1>;

  printConsole();
  return (
    <>
      {h1}
      <label className="box" htmlFor="username">아이디</label>
      <input type="text" id="username" />
    </>
  );
}
