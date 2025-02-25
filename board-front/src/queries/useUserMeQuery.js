import { useQuery } from '@tanstack/react-query';
import { getUserMeApi } from '../apis/userApi';

export const useUserMeQuery = () =>
  useQuery({
    queryKey: 'useUserMeQuery',
    queryFn: getUserMeApi,
    staleTime: 1000 * 60 * 20, // 20분 - 데이터가 fresh한(유효?) 시간
    gcTime: 1000 * 60 * 10, // 10분 - 유효하지 않은 데이터를 지우는 시간
    retry: 0,
  });
