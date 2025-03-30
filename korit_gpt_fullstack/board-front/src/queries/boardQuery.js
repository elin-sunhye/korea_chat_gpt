import { useInfiniteQuery, useQuery } from '@tanstack/react-query';
import {
  getCategoriesApi,
  getCategoryBaordListApi,
  getSearchBoardListApi,
} from '../apis/boardApi';

export const useGetCategories = () =>
  useQuery({
    queryKey: ['useGetCategories'],
    queryFn: getCategoriesApi,
    retry: 0,
    staleTime: 1000 * 60 * 10,
    gcTime: 1000 * 60 * 5,
  });

export const useGetSearchBoardList = (params) =>
  useQuery({
    queryKey: ['useGetSearchBoardList', params],
    queryFn: async () => {
      return await getSearchBoardListApi(params);
    },
    retry: 0,
    staleTime: 1000 * 60 * 10,
    gcTime: 1000 * 60 * 5,
  });

export const useGetCategoryBaordList = (categoryName) =>
  useInfiniteQuery({
    queryKey: ['useGetCategoryBaordList', categoryName],
    queryFn: async ({ pageParam = 1 }) => {
      const params = {
        page: pageParam,
        limitCount: 15,
      };
      console.log('params', params);
      return await getCategoryBaordListApi(categoryName, params);
    },
    retry: 0,
    refetchOnWindowFocus: false,
    initialPageParam: 1, // 제일 처음 기본 페이지
    getNextPageParam: (lastPage) => {
      // lastPage : 제일 마지막에 가져온 게시글 (응답객체)
      console.log('Asd', lastPage);
      return lastPage.data.nextPage || undefined;
    },
  });
