# 흐름제어
# CASE, IF, IFNULL, NULLIF

select
	-- 10 > 5 일 때, '5보다 큽니다.' 아니면 '5보다 작습니다.'
	case
		when 10 > 5 then '5보다 큽니다.'
        else '5보다 작습니다.'
	end,
    if(10 > 5, '5보다 큽니다.', '5보다 작습니다.');
    
select
	*,
    -- trim() : 양 끝 공백 제거
    -- leading : 앞쪽에서 특정 문자 또는 공백 제거
    -- trailing: 뒷쪽에서 특정 문자 또는 공백 제거
    if(trim(isbn)= '', 'O', 'X') as oAndX,
    case
		when category_id < 100 then '0 ~ 99'
        when category_id < 200 then '100 ~ 199'
        when category_id < 300 then '200 ~ 299'
		else '300 ~'
    end as scope,
    -- category_id가 null이면 '40'으로 변경
    ifnull(category_id, '40') as ifnull,
    -- category_id = 37 이면 null로 변경
   nullif(category_id, 37) as nullif
from
	book_tb;

update
	book_tb
set
	category_id = case
		when category_id % 3 = 0 then 3000
        when category_id % 2 = 0 then 2000
	end;
    
-- is, is not
select
	*
from
	book_tb
where
	category_id is null;
    
update
	book_tb
set
	-- category_id = 4000
	category_id = ifnull(category_id, 4000);
-- where
-- 	category_id is null;


-- 40번대 category_id null로 변경
update
	book_tb
set
	category_id = null
where
	category_id between 40 and 49;
    
select
	* 
from
	book_tb;