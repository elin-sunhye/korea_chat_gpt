import { css } from '@emotion/react';

export const container = css`
  display: flex;
  flex-direction: column;

  width: 100%;
  height: 100%;
`;

export const header = css`
  display: flex;
  justify-content: space-between;
  align-items: center;

  box-sizing: border-box;
  padding: 1rem;
  border-bottom: 0.1rem solid #dbdbdb;
`;

export const title = css`
  display: flex;

  & h2 {
    margin: 0.5rem 0;
    font-size: 2rem;
  }
`;

export const searchBox = css`
  display: flex;
  gap: 1rem;
`;

export const searchInpBox = css`
  position: relative;
  height: 3rem;

  & input {
    box-sizing: border-box;
    padding: 0 4rem 0 1rem;
    outline-color: #2684ff;
    border: 0.1rem solid #dbdbdb;
    border-radius: 0.4rem;

    width: 20rem;
    height: 100%;

    font-size: 1.1rem;
  }

  & button {
    position: absolute;
    right: 1rem;
    top: 50%;
    transform: translateY(-50%);
  }
`;

export const main = css`
  box-sizing: border-box;
  padding: 1rem;
`;

export const boardListContainer = css`
  box-sizing: border-box;
  padding: 0;
  margin: 0;

  & li {
    display: flex;
    align-items: center;
    gap: 1rem;

    box-sizing: border-box;
    height: 3rem;

    cursor: default;
    list-style: none;

    &:first-of-type {
      background-color: #fafafa;
    }

    &:not(:first-of-type):hover {
      border-radius: 0.5rem;
      cursor: pointer;
      background-color: #eee;
    }

    & > div {
      display: flex;
      align-items: center;

      box-sizing: border-box;

      font-size: 1.4rem;

      &:not(:last-of-type) {
        border-right: 0.1rem solid #dbdbdb;
      }

      &:first-of-type {
        box-sizing: border-box;
        padding-left: 1rem;

        width: 6rem;
      }
      &:nth-of-type(2) {
        display: block;

        flex-grow: 1;

        width: 13.4rem;

        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;

        transition: all 0.3s ease-in-out;
      }
      &:nth-of-type(3) {
        width: 10rem;
      }
      &:nth-of-type(4) {
        width: 5rem;
      }
      &:last-of-type {
        width: 10rem;
      }
    }
  }
`;

export const boardWriter = css`
  display: flex;
  align-items: center;

  & span {
    display: inline-block;

    box-sizing: border-box;
    margin-right: 1rem;
    border: 0.1rem solid #dbdbdb;
    border-radius: 50%;

    width: 2.2rem;
    height: 2.2rem;
    overflow: hidden;

    & img {
      width: 100%;
      height: auto;
    }
  }

  & p {
    display: block;

    margin: 0 0 0.2rem;

    width: 65%;

    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
  }
`;

export const boardCounts = css`
  & span {
    position: relative;
    margin-right: 1rem;

    &:hover p {
      display: block;
    }

    & p {
      display: none;
      position: absolute;
      left: 50%;
      top: -100%;
      transform: translateX(-50%);
      z-index: 1;

      box-sizing: border-box;
      padding: 0.3rem 0.5rem;
      margin: 0;
      border-radius: 0.5rem;

      font-size: 1.3rem;
      cursor: default;

      background-color: #ccc;
    }
  }
`;

export const footer = css`
  box-sizing: border-box;
  padding: 1rem;
`;

export const pageNums = css`
  display: flex;
  align-items: center;
  gap: 0.5rem;

  width: 25rem;

  & button {
    display: flex;
    justify-content: center;
    align-items: center;

    box-sizing: border-box;
    outline: none;
    border: 0.1rem solid #dbdbdb;
    border-radius: 0.5rem;

    width: 2.5rem;
    aspect-ratio: 1 / 1;

    font-size: 1.2rem;

    background-color: #fff;
    cursor: pointer;

    &:hover {
      background-color: #fafafa;
    }

    & span {
      font-weight: 600;
    }
  }
`;

export const pageNum = (isSelect) => css`
  background-color: ${isSelect ? '#eee' : '#fff'} !important;
`;
