import { css } from '@emotion/react';

export const basicBtn = css`
  display: flex;
  justify-content: center;
  align-items: center;

  box-sizing: border-box;
  padding: 0.6rem;

  border: none;
  border-radius: 0.7rem;

  font-size: 2.5rem;

  background-color: transparent;

  cursor: pointer;

  &:hover {
    background-color: #00000011;
  }

  &:active {
    background-color: #00000022;
  }
`;

export const emptyBtn = css`
  display: flex;
  justify-content: center;
  align-items: center;

  box-sizing: border-box;
  border: none;
  padding: 0.6rem 1.2rem;

  font-size: 1.6rem;
  font-weight: 600;

  background-color: transparent;

  cursor: pointer;
`;
