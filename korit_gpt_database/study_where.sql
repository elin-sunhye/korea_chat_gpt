
# where
# where 조건
select
	*
from
	student_tb
where
-- 	student_year = 3 or student_year = 4;
--  => student_year in(3,4);

--  범위
--  student_year > 2 and student_year < 5;
--  student_year >= 3 and student_year <= 4;
   	student_id between 2 and 4;
    
# where 와일드 카드(like)
-- ; 검색 시 주로 사용
-- % : 아무거나 상관없다
-- %교 / %교% / 교%
-- _ : 글자 갯수
-- _교_ / __교_ / 교_ / 교___ ...
select
	*
from
	instructor_tb
where
	instructor_name like '_교_';