import { css } from '@emotion/react';

export const layout = css`
  display: flex;
  justify-content: center;
  align-items: center;

  box-sizing: border-box;

  width: 100%;
  height: 100%;
`;

export const title = css`
  margin: 0.5rem 0;

  font-size: 2rem;

  cursor: default;
`;

export const subTitle = css`
  margin: 0;

  font-size: 1.6rem;
  color: #bbb;

  cursor: default;
`;

export const oauth2Group = css`
  box-sizing: border-box;
  margin-bottom: 1rem;
  padding: 2rem 0 1rem;
  border-bottom: 0.1rem solid #dbdbdb;
`;

export const groupBox = css`
  box-sizing: border-box;
  padding: 0.6rem 0;

  width: 32.6rem;
`;

export const oauth2Btn = css`
  display: flex;
  align-items: center;

  position: relative;

  box-sizing: border-box;
  padding: 0.5rem 1rem;
  border: 0.1rem solid #dbdbdb;
  border-radius: 0.5rem;

  width: 100%;
  height: 3.6rem;

  background-color: transparent;

  cursor: pointer;

  &:active {
    background-color: #fafafa;
  }
`;
export const oauth2Ico = css`
  display: flex;
  justify-content: center;
  align-items: center;

  position: absolute;

  width: 2.4rem;
  height: 2.4rem;
`;

export const oauth2Txt = css`
  flex-grow: 1;

  font-weight: 600;
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

export const accountMsg = css`
  font-size: 1.2rem;
  color: #777;

  cursor: default;
`;

export const accountBtn = css`
  box-sizing: border-box;
  border: none;
  border-radius: 0.5rem;

  width: 100%;
  height: 4rem;

  font-size: 1.4rem;
  letter-spacing: 0.1rem;
  color: #fff;

  background-color: #2383e2;

  cursor: pointer;

  &:active {
    background-color: #1b65af;
  }
`;

export const footerAgreement = css`
  display: inline-flex;
  justify-content: center;

  box-sizing: border-box;
  padding: 0.6rem 0;

  width: 32.6rem;

  font-size: 1.2rem;
  text-align: center;
`;
