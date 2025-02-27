import { useMutation } from '@tanstack/react-query';
import { updateNicknameApi, updateProfileImgApi, updatePwApi } from '../apis/userApi';

export const useUpadteProfileImgMutation = () =>
  useMutation({
    mutationKey: ['useUpadteProfileImgMutation'],
    mutationFn: updateProfileImgApi,
    retry: 0,
  });

export const useUpdateNicknameMutation = () =>
  useMutation({
    mutationKey: ['useUpdateNicknameMutation'],
    mutationFn: updateNicknameApi,
    retry: 0,
  });

  export const useUpdatePwMutation = () =>
    useMutation({
      mutationKey: ['useUpdatePwMutation'],
      mutationFn: updatePwApi,
      retry: 0,
    });
