import { useMutation } from '@tanstack/react-query';
import { joinApi, loginApi } from '../apis/authApi';

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
