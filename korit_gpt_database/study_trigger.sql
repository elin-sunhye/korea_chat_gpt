# trigger
-- ; 데이터베이스에서 특정 이벤트가 발생했을 때 자동으로 실행되는 특별한 종류의 저장 프로시저
-- 1. 자동 작업 수행
-- 삽입(INSERT), 업데이트(UPDATE), 삭제(DELETE) 작업이 실행될 때 특정 동작을 자동으로 실행
-- 2. 데이터 무결성 유지
-- 데이터 입력/수정/삭제 시 데이터의 유효성을 검증하거나 데이터 일관성을 보장
-- 3. 로그 기록
-- 데이터 변경 기록을 다른 테이블에 저장하여 감사(audit) 목적으로 사용
-- 4. 제약 조건 구현
-- 데이터베이스에서 정의하기 어려운 복잡한 비즈니스 규칙을 코드로 구현
-- 5. 데이터 복제 및 동기화
-- 데이터 변경 시 이를 다른 테이블이나 시스템에 동기화하는 작업을 수행

-- M 테이블 삭제 시 b 테이블에서 상속 받는 데이터도 자동 삭제
-- 1. 테이블 데이터 생성
insert into data_b_tb -- M
values
	(default, '111'),
	(default, '222'),
	(default, '333');

insert into data_a_tb -- S
values
	(default, 'aaa', 1),
	(default, 'bbb', 1),
	(default, 'ccc', 2),
	(default, 'ddd', 3),
	(default, 'eee', 3);
    
-- 2. data_b_tb 테이블 설정 trigger 탭에서 설정

-- 3. 조인
select
	*
from
	data_b_tb b
    left outer join data_a_tb a on(a.data_b_id = b.data_b_id);
    
-- 4. 삭제(trigger 실행)
delete
from
	data_b_tb
where
	data_b_value = '111';
    
select * from data_a_tb;
select * from data_b_tb;



-- M 테이블 데이터 삽입 시 c 테이블에서 상속 받는 데이터도 자동 삽입
-- 1. data_b_tb 테이블 설정 trigger 탭에서 설정
-- 2. 테이블 데이터 생성
insert into data_b_tb -- M
values
	(default, '555');

-- 3. 데이터 확인
select
	*
from
	data_c_tb;
    
    
-- M 테이블 데이터 삭제 시 d 테이블에서 자동 백업
-- 1. data_b_tb 테이블 설정 trigger 탭에서 설정
-- 2. 테이블 데이터 생성
delete
from
	data_b_tb
where
	data_b_value = '333';
    
select * from data_b_tb;
select * from data_d_tb;


