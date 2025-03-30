# select
select
	*
from
	student_tb;

select
	student_name,
    student_year
from
	student_tb;

# select 응용
select 10;
select 10 as num;

# 합잡합 (열 만들기)
-- 행의 갯수 통일!
-- 하위 행 이름이 달라도 최상위 이름 따라감
-- union : 중복 제거 (교집합)
select 
	10 as num,
	20 as num,
    '이름' as name
union
select
	10 as num,
	20 as num,
    '이름' as name;
    
-- union all : 중복 제거 안함
select 
	10 as num,
	20 as num,
    30 as name
union all 
select
	10 as num,
	20 as num,
    '이름' as name;
    
select
	1 as id,
    'mon' as day
union all
select
	2 as id,
    'tue' as day
union all
select
	3 as id,
    'wed' as day;
    
# 번호 매기기
-- row_number() over(partition by 그룹핑할 컬럼 order by 정렬할 컬럼) : 각 행에 연속적인 숫자를 부여
-- rank() over(partition by 그룹핑할 컬럼 order by 정렬할 컬럼) : 순위 (ex) 1,1,3,4,5,5,7)
-- dense_rank() over(partition by 그룹핑할 컬럼 order by 정렬할 컬럼) : 순위 (공동이 있어도 무시! ex) 1,1,2,3,4,5,5,6 - 1등이 2개 여도 다음 순위는 2등으로 나옴)
select
	row_number() over(order by student_name) as id,
	student_name
from
	student_tb;
    
-- union 번호 매기기
select
	row_number() over(order by name) as id,
--  row_number() over() as id, : 테이블 정렬 없이 번호 매김
	name
from
	(select
		student_name as name
	from
		student_tb
	union
	select
		instructor_name
	from
		instructor_tb
	) as name_tb;

# 정렬
-- 오름차순
select
	*
from
	student_tb
order by
    student_name;
-- 	student_name asc;
    
-- 내림차순
select
	*
from
	student_tb
order by
	student_name desc;

-- 응용
select
	*
from
	student_tb
order by
	student_year desc,
	student_name;


## 예제 1
-- course_tb, major_tb 합치고, 테이블에 있는 이름들을 내림차순으로 번호 매기기
select 
	row_number() over(order by `id` desc) as num,
    name_tb.*
from
	(select
		course_id as `id`,
		course_name as `name`
	from
		course_tb
	union
	select
		major_id,
		major_name
	from
		major_tb
    ) as name_tb;