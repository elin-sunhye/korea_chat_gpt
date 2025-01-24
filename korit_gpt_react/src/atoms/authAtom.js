import { atom } from 'recoil';

// atom : 전역 상태
export const authUserIdAtomState = atom({
  key: 'authUserIdAtomState',
  default: 0,
});

export const accessTokenAtomState = atom({
  key: 'accessTokenAtomState',
  default: localStorage.getItem('AccessToken'),
});
