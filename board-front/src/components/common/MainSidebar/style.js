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
  position: absolute;
  right: 0;

  box-sizing: border-box;
  padding: 0.6rem;

  width: 30rem;
  height: 100%;
`;

export const groupLayout = css`
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
