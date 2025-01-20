// jsxImportSource 문법 안에다가 emotion/react 언어를 적용 시킴
/** @jsxImportSource @emotion/react */
import MainHeader from '../MainHeader/MainHeader';
import * as s from './style';

export default function MainLayout({ children }) {
  return (
    // <div
    //   css={css`
    //     display: 'flex';
    //   `}
    // ></div>
    <div css={s.layout}>
      <MainHeader />
      {children}
    </div>
  );
}
