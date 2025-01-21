import { css } from '@emotion/react';

export const headerLayout = css`
  display: flex;
  justify-content: flex-end;
  margin-bottom: 10px;
  width: 100%;

  button {
    box-sizing: border-box;
    border: 1px solid #dbdbdb;
    padding: 10px 20px;
    background-color: white;
    font-weight: 600;
    cursor: pointer;

    &:hover {
      background-color: #fafafa;
    }
    &:active {
      background-color: #eee;
    }
  }
`;

export const titleLayout = css`
  width: 100%;

  input {
    box-sizing: border-box;
    outline: none;
    border: 1px solid #dbdbdb;
    margin-bottom: 5px;
    padding: 12px 15px;
    width: 100%;
    height: 40px;
  }
`;
