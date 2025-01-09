#정규화
-- 1. 각 테이블 생성
	-- 1) _tb 생성
	-- 2) 중복 제거(distinct) 후 생성 된 _tb에 삽입

	-- 카테고리 (category_tb)
	insert into category_tb
	select
		distinct
		0, -- AUTO_INCREMENT 열에 명시적으로 값을 삽입하면 0 또는 NULL이 삽입되더라도 MySQL은 AUTO_INCREMENT에 의해 자동으로 고유한 값(1, 2, 3, ...)을 생성
		카테고리
	from
		books;
    
	-- 저자 (author_tb)
	insert into author_tb
	select
		distinct
		0,
		저자명
	from
		books;

	-- 출판사 (publisher_tb)
	insert into publisher_tb
	select
		distinct
		0,
		출판사
	from
		books;
    
    
-- 2. 각 생성한 테이블에 있는 고유한 id 값으로 books 값 변경
	-- 1) 책 중복 확인 (group by하여 결과 카운트 확인 - 집계를 낼때 주로 사용)
	select
		도서명,
		저자명,
		isbn,
		표지url
	from
		books
	group by
		도서명,
		저자명,
		isbn,
		표지url;

    -- 2) join : 테이블 붙이기
	select
		*
	from
		books b -- 테이블에 as 생략 가능 (선택)
		left outer join category_tb ct on ct.category_name = b.카테고리
        left outer join author_tb `at` on `at`.author_name = b.저자명
        left outer join publisher_tb pt on pt.publisher_name = b.출판사;
    
	-- 3) update : 실제 테이블에 업데이트
    update
		books b
		left outer join category_tb ct on ct.category_name = b.카테고리
        left outer join author_tb `at` on `at`.author_name = b.저자명
        left outer join publisher_tb pt on pt.publisher_name = b.출판사
	set
		카테고리 = ct.category_id,
        저자명 = at.author_id,
        출판사 = pt.publisher_id;
        
        
-- id + name join : 각 아이디에 맞는 name 컬럼 추가
select
	bt.book_id,
    bt.book_name,
    bt.isbn,
    bt.author_id,
    `at`.author_id as at_author_id,
    `at`.author_name,
    bt.publisher_id,
    pt.publisher_id as pt_publisher_id,
    pt.publisher_name,
    bt.category_id,
    ct.category_id as ct_category_id,
    ct.category_name,
    bt.book_img_url
from
	book_tb bt
    left outer join author_tb `at` on `at`.author_id = bt.author_id
    left outer join category_tb ct on ct.category_id = bt.category_id
    left outer join publisher_tb pt on pt.publisher_id = bt.publisher_id
where
	-- 조건
    bt.category_id between 10 and 100;
    
select
    bt.publisher_id,
    pt.publisher_name,
    count(bt.publisher_id) as book_count
--  sum(bt.book_id) as book_sum
--  min(bt.book_id) as book_min
from
	book_tb bt
    left outer join author_tb `at` on `at`.author_id = bt.author_id
    left outer join category_tb ct on ct.category_id = bt.category_id
    left outer join publisher_tb pt on pt.publisher_id = bt.publisher_id
group by
	bt.publisher_id,
	pt.publisher_name
having
	-- where과 같은 조건절! group by 이전 조건은 where group by 이후 조건은 having
	book_count > 10
order by
	bt.publisher_id
limit 1, 10
	
## from -> where -> group by -> having -> select -> order by -> limit










