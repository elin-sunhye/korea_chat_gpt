import { css } from '@emotion/react';

export const quillEditor = css`
  flex-grow: 1;
  box-sizing: border-box;

  height: 60rem;

  & .ql-toolbar {
    display: flex;
    justify-content: flex-start;
    flex-wrap: wrap;
    gap: 1rem;

    border: none;
    border-bottom: 0.1rem solid #dbdbdb;

    &.ql-snow {
      padding: 0.8rem 0;

      & .ql-formats {
        margin-right: 0;
      }
    }
  }
  & .ql-container {
    border: none;

    height: 89%;
  }
`;

export const quillTop = css`
  display: flex;
  gap: 1rem;

  & input {
    flex-grow: 1;

    box-sizing: border-box;
    padding: 0.5rem 1.5rem;
    outline: none;
    border: 0.1rem solid #dbdbdb;
    border-radius: 0.5rem;
  }
`;

export const saveBtn = css`
  box-sizing: border-box;
  padding: 0.5rem 1rem;
  border: 0.1rem solid #dbdbdd;
  border-radius: 0.5rem;

  background-color: #fafafa;
  cursor: pointer;

  &:hover {
    background-color: #eee;
  }
  &:active {
    background-color: #ddd;
  }
`;
