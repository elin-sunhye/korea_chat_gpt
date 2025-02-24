import { css } from '@emotion/react';

export const groupBox = css`
  box-sizing: border-box;
  padding: 0.6rem 0;

  width: 32.6rem;
`;

export const textInp = css`
  box-sizing: border-box;
  padding: 0.5rem 1rem;
  outline: none;
  border: 0.1rem solid #dbdbdb;
  border-radius: 0.5rem;

  width: 100%;
  height: 3.4rem;

  font-size: 1.4rem;
  letter-spacing: 0.1rem;

  background-color: transparent;

  &:focus {
    box-shadow: 0 0 0.2rem 0.2rem #7edaff;
  }
`;

export const messageTxt = css`
  margin: 0;
  margin-top: 0.3rem;
  color: #ff3f3f;
  font-size: 1.2rem;
`;
