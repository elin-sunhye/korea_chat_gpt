import { css } from '@emotion/react';

export const modalTop = css`
  display: flex;
  justify-content: flex-end;
  align-items: center;

  & button {
    box-sizing: border-box;
    padding: 0;
    margin: 0;
    border: 0;

    font-size: 2rem;

    background-color: transparent;

    cursor: pointer;

    & svg {
      fill: #ddd;

      &:hover {
        fill: #333;
      }
    }
  }
`;

export const header = css`
  display: flex;
  flex-direction: column;
  align-items: center;

  box-sizing: border-box;
  padding: 1rem 5rem;
`;

export const headerIco = css`
  font-size: 3rem;

  & svg path {
    fill: #333;
  }
`;

export const headerTitle = css`
  box-sizing: border-box;
  margin: 0.5rem;

  font-size: 1.6rem;
`;

export const headerMsg = css`
  text-align: center;
`;

export const inpGroup = css`
  display: flex;
  flex-direction: column;
  gap: 0.5rem;

  margin-bottom: 1rem;

  & label {
    font-size: 1.2rem;
  }

  & input {
    box-sizing: border-box;
    padding: 0.5rem 1rem;
    outline: none;
    border: 0.1rem solid #dbdbbd;
    border-radius: 0.5rem;

    font-size: 1.4rem;

    background-color: #fafafa;
  }
`;

export const setBtn = css`
  box-sizing: border-box;
  padding: 1rem 2rem;
  border: 0;
  border-radius: 0.5rem;

  width: 100%;
  height: auto;

  color: #fff;

  background-color: #2383e2;

  cursor: pointer;

  &:active {
    background-color: #1b65af;
  }
  &:disabled {
    background-color: #ddd;
    cursor: default;
  }
`;
