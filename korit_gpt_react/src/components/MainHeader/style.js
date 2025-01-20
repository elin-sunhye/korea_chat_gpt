import { css } from '@emotion/react';

export const layout = css`
  box-sizing: border-box;
  display: flex;
  justify-content: space-between;
  margin-bottom: 20px;
  border-bottom: 2px solid #dbdbdb;
  width: 100%;
  padding: 20px 10px 10px;

  ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
  }

  a {
    text-decoration: none;
    color: #222;
  }
`;

export const leftContainer = css`
  display: flex;
  align-items: center;

  h1 {
    margin: 0;
    margin-right: 20px;
    font-size: 26px;
    cursor: pointer;
  }

  ul {
    display: flex;

    a {
      box-sizing: border-box;
      display: flex;
      align-items: center;
      margin-left: 30px;
      padding: 5px 10px;
      font-weight: 600;
      transition: all 0.1s ease-in-out;
      color: #666;

      &:hover {
        transform: scale(1.1);
        color: #222;
      }

      svg {
        margin-right: 5px;
      }
    }
  }
`;

export const rightContainer = css`
  display: flex;
  align-items: center;

  ul {
    display: flex;

    a {
      position: relative;
      display: flex;
      justify-content: center;
      align-items: center;
      margin-left: 10px;
      padding: 5px 3px 3px;
      font-size: 14px;
      font-weight: 600;

      &::after {
        content: '';
        position: absolute;
        bottom: 0;
        width: 0;
        transition: all 0.2s ease-in-out;
      }

      &:hover::after {
        width: 100%;
        border: 1px solid #222;
      }

      svg {
        margin-right: 5px;
      }
    }
  }
`;
