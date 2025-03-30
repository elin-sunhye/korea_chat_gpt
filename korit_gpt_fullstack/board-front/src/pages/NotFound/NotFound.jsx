/** @jsxImportSource @emotion/react */
import { BiError } from 'react-icons/bi';
import * as s from './style';
import React from 'react';

export default function NotFound({}) {
  return (
    <div css={s.layout}>
      <BiError />
      <h1>Not Found Page</h1>
      <p>This is not the web page you are looking for.</p>
    </div>
  );
}
