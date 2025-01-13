# row_number(), rank()에서의 partition by
-- : 해당하는 기준으로 번호 매기기 각 그룹안에서의 번호

select
	-- category_id를 기준으로 각 category_id 안에서의 author_id 번호 및 정렬
	row_number() over(partition by category_id order by author_id),
	book_tb.*
from
	book_tb
where
	book_name like '%가%';
