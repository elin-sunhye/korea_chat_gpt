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
  padding: 1rem 3rem;
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
  font-size: 1.3rem;
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
`;

export const verifyInp = css`
  display: flex;
  justify-content: center;
  align-items: center;

  & input {
    margin: 0 0.5rem;

    width: 2rem;
    height: 2rem;

    text-align: center;

    &::-webkit-inner-spin-button,
    &::-webkit-outer-spin-button {
      -webkit-appearance: none;
      margin: 0;
    }
  }
`;

export const emailInpNBtn = css`
  display: flex;
  gap: 1rem;

  & input {
    align-items: center;
    flex-grow: 1;

    box-sizing: border-box;
    padding: 0.5rem 1rem;
    outline: none;
    border: 0.1rem solid #dbdbbd;
    border-radius: 0.5rem;

    font-size: 1.4rem;

    background-color: #fafafa;
  }

  & span {
    margin-right: 1rem;
    font-size: 1.4rem;
    line-height: 1.3;
  }

  & button {
    margin: 0;
    padding: 0.5rem 1.5rem;

    width: fit-content;
  }
`;

export const warnning = css`
  font-size: 1.3rem;
  color: #ff3f3f;
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
