import { css } from '@emotion/react';

export const container = css`
  box-sizing: border-box;
  padding: 0 4rem;
`;

export const title = css`
  box-sizing: border-box;
  padding: 1rem 0 2rem;
  margin: 0 0 2rem;
  border-bottom: 0.1rem solid #dbdbdb;

  font-size: 2rem;
`;

export const accountBox = css`
  display: flex;
  align-items: center;
  gap: 3rem;

  margin-bottom: 5rem;
`;

export const imgBox = css`
  display: flex;
  justify-content: center;
  align-items: center;

  box-sizing: border-box;
  border-radius: 50%;

  width: 10rem;
  aspect-ratio: 1 /1;
  overflow: hidden;

  cursor: pointer;

  & img {
    width: 100%;
    height: auto;
  }

  & input[type='file'] {
    display: none;
  }
`;

export const nicknameTitle = css`
  margin: 0 0 0.7rem;

  font-size: 1.4rem;
  font-weight: 400;

  cursor: default;
`;

export const txtInp = css`
  display: block;

  box-sizing: border-box;
  padding: 1rem 1.5rem;
  outline: none;
  border: 0.1rem solid #dbdbdb;
  border-radius: 0.5rem;

  width: 30rem;
`;

export const saveBtn = css`
  box-sizing: border-box;
  padding: 1rem 2rem;
  margin-top: 0.5rem;
  border: none;
  border-radius: 0.5rem;

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

export const itemGroup = css`
  display: flex;
  justify-content: space-between;
  align-items: center;

  margin-bottom: 2rem;

  &:last-of-type {
    margin-bottom: 0;
  }
`;

export const subTitle = css`
  margin: 0;

  font-size: 1.6rem;
  font-weight: 500;
`;

export const subCont = css`
  margin: 0.5rem 0;

  font-size: 1.4rem;
  font-weight: 400;
  color: #777;
`;

export const borerBtn = css`
  box-sizing: border-box;
  padding: 1rem 2rem;
  border: 0.1rem solid #dbdbdb;
  border-radius: 0.5rem;

  background-color: #fff;

  cursor: pointer;

  &:hover {
    background-color: #fafafa;
  }
  &:active {
    background-color: #eee;
  }
`;
