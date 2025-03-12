import { css } from '@emotion/react';

export const container = css`
  flex-grow: 1;
  display: flex;
  flex-direction: column;

  box-sizing: border-box;
  padding: 0.6rem;

  width: calc(100% - 30rem);
`;

export const header = css`
  display: flex;
  gap: 0.5rem;

  box-sizing: border-box;
  padding: 0.6rem;

  width: 100%;
  height: 4.9rem;
`;

export const main = css`
  display: flex;
  flex-direction: column;
  flex-grow: 1;

  box-sizing: border-box;
  padding: 0.6rem;

  height: calc(100% - 4.9rem);
`;
