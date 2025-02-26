import { useMutation } from '@tanstack/react-query';
import { updateNicknameApi, updateProfileImgApi } from '../apis/userApi';

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
