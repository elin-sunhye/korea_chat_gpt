import { css } from '@emotion/react';

export const layout = (isOpen) => css`
  position: relative;

  box-sizing: border-box;

  width: ${isOpen ? '30rem' : '0'};
  height: 100%;

  background-color: #fafaf5;

  transition: all 0.3s ease-in-out;
`;

export const container = css`
  display: flex;
  flex-direction: column;
  justify-content: space-between;

  position: absolute;
  right: 0;

  box-sizing: border-box;
  padding: 0.6rem;

  width: 30rem;
  height: 100%;
`;

export const groupLayout = css`
  position: relative;

  box-sizing: border-box;
  border-radius: 0.7rem;
  padding: 0.6rem;

  width: 100%;

  cursor: pointer;

  &:hover {
    background-color: #00000017;
  }
`;

export const user = css`
  display: flex;

  font-size: 1.6rem;
`;

export const topGroup = css`
  display: flex;
  justify-content: space-between;
  align-items: center;
`;

export const authText = css`
  display: inline-flex;
  align-items: center;

  width: 21rem;

  & svg {
    margin-right: 1rem;
  }
`;

export const profileImgBox = css`
  display: inline-flex;
  justify-content: center;
  align-items: center;

  box-sizing: border-box;
  border-radius: 0.5rem;
  margin-right: 1rem;

  width: 3rem;
  aspect-ratio: 1 / 1;
  overflow: hidden;

  background-color: #fff;

  & img {
    width: 100%;
    height: auto;
  }
`;

export const profileNicknameBox = css`
  width: calc(100% - 3rem);
  overflow: hidden;

  text-align: left;
  text-overflow: ellipsis;
  white-space: nowrap;
`;

export const categoryTxt = css`
  display: flex;
  justify-content: space-between;
  width: 100%;
`;

export const writeBtn = css`
  position: absolute;
  right: 0.6rem;
  top: 0.4rem;
`;

export const categoryListContatiner = css`
  flex-grow: 1;

  overflow-y: auto;
`;

export const categoryItem = css`
  display: flex;
  justify-content: space-between;
  align-items: center;

  width: 100%;

  & button:last-of-type {
    opacity: 0;
  }

  &:hover button:last-of-type {
    opacity: 1;
  }
`;
