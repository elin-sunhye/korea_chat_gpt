import { css } from '@emotion/react';

export const layout = css`
  box-sizing: border-box;
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 100%;
`;

export const main = css`
  box-sizing: border-box;
  display: flex;
  flex-direction: column;
  gap: 10px;
  margin-bottom: 20px;
  border: 1px solid #dbdbdb;
  padding: 40px;
  width: 400px;

  input {
    box-sizing: border-box;
    outline: none;
    border: 1px solid #dbdbdb;
    padding: 10px 20px;
  }

  button {
    box-sizing: border-box;
    outline: none;
    margin-top: 20px;
    border: 1px solid #dbdbdb;
    padding: 10px 20px;
    background-color: #444;
    color: #fafafa;
    font-weight: 600;
    cursor: pointer;

    &:hover {
      background-color: #999;
    }
    &:active {
      background-color: #777;
    }
  }
`;

export const footer = css`
  box-sizing: border-box;
  display: flex;
  justify-content: center;
  gap: 10px;
  border: 1px solid #dbdbdb;
  padding: 40px;
  width: 400px;

  span {
    cursor: default;
  }

  a {
    text-decoration: none;
    color: #d5ae00;
    font-weight: 600;
  }
`;
