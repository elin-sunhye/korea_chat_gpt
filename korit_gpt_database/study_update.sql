# update
update
	data1_tb
set
	data2_id = 10 -- where 절 없으면 data2_id 컬ㄹㅁ 데이터 값 전체가 10으로 변경
where
	data1_id in (5, 7);