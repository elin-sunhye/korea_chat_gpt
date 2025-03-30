import { useMutation } from '@tanstack/react-query';
import { joinApi, loginApi, sendAuthMailApi } from '../apis/authApi';

export const useJoinMutation = () =>
  useMutation({
    mutationKey: ['useJoinMutation'],
    mutationFn: joinApi,
    retry: 0,
  });

export const useLoginMutation = () =>
  useMutation({
    mutationKey: ['useLoginMutation'],
    mutationFn: loginApi,
    retry: 0,
  });

export const useSendAuthMailMutation = () =>
  useMutation({
    mutationKey: ['useSendAuthMailMutation'],
    mutationFn: sendAuthMailApi,
    retry: 0,
  });
