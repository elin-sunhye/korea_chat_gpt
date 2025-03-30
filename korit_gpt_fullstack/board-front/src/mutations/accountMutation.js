import { useMutation } from '@tanstack/react-query';
import { sendVerificationEmailApi, updateEmailApi, updateNicknameApi, updateProfileImgApi, updatePwApi } from '../apis/userApi';

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

  export const useSendVerificationEmailMutation = () =>
    useMutation({
      mutationKey: ['useSendVerificationEmailMutation'],
      mutationFn: sendVerificationEmailApi,
      retry: 0,
    });

export const useUpdateEmailMutation = () =>
  useMutation({
    mutationKey: ['useUpdateEmailMutation'],
    mutationFn: updateEmailApi,
    retry: 0,
  });
