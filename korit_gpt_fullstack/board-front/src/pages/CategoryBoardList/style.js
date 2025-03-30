import { css } from '@emotion/react';

export const scrollLayout = css`
  display: flex;
  justify-content: space-between;
  align-items: flex-start;
  align-content: flex-start;
  gap: 1rem;
  flex-wrap: wrap;

  /* width: 100%; */
  height: 100%;
  overflow-y: auto;
`;

export const cardLayout = css`
  display: flex;
  flex-direction: column;

  box-sizing: border-box;
  border: 0.1rem solid #dbdbdb;
  border-radius: 0.5rem;

  width: calc((100% - 2rem) / 3);
  height: 15rem;

  cursor: pointer;

  & header,
  & main {
    box-sizing: border-box;
    padding: 1rem;
  }

  & header {
    display: flex;
    justify-content: space-between;
    align-items: center;
  }

  & main {
    flex-grow: 1;
    display: flex;
    justify-content: center;
    align-items: center;

    border-top: 0.1rem solid #dbdbdb;
    border-bottom: 0.1rem solid #dbdbdb;
  }
`;

export const headerLeft = css`
  display: flex;
  align-items: center;
  gap: 1rem;
`;

export const profileImgBox = css`
  display: inline-flex;
  justify-content: center;
  align-items: center;

  box-sizing: border-box;
  border: 0.1rem solid #dbdbdb;
  border-radius: 50%;

  width: 3.6rem;
  aspect-ratio: 1 / 1;
  overflow: hidden;

  & img {
    width: 100%;
    height: auto;
  }

  & + p {
    margin: 0;

    width: 10rem;
    overflow: hidden;

    font-size: 1.6rem;
    white-space: nowrap;
    text-overflow: ellipsis;
  }
`;

export const boardCounts = css`
  display: flex;
  justify-content: flex-start;
  align-items: center;
  gap: 1rem;

  & span {
    display: flex;
    justify-content: flex-start;
    align-items: center;
    gap: 0.2rem;

    & svg {
      font-size: 1.6rem;
    }

    & p {
      box-sizing: border-box;
      margin: 0;

      font-size: 1.3rem;
      cursor: default;
    }
  }
`;

export const boardTitle = css`
  display: -webkit-box;

  box-sizing: border-box;
  margin: 0;

  width: 26rem;
  overflow: hidden;

  font-size: 1.8rem;
  text-overflow: ellipsis;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 2;
`;

export const observerBox = css`
  width: 100%;
  height: 3rem;
  color: transparent;
  background-color: aqua;
`;
