# stored procedures
-- 반복적인 데이터베이스 작업을 효율적으로 처리하고, 복잡한 SQL 로직을 캡슐화하여 코드 재사용성을 높이기 위해 사용
-- 저장 프로시저는 데이터베이스에 저장된 SQL 코드 블록으로, 호출하면 한 번에 실행

call sp_insert_book('aaa', '123', '테스트저자', '테스트카테고리', '테스트출', 'http://');

/* 
	# 예제
	course_tb(과목명)
    call sp_insert_course_registering_information_tb(*과목명, *교수명, 요일, 시작일, 종료일, *학과)
 */
 call sp_insert_course_registering_information('네트워크', '김준일', '월', '2025-01-13', '2025-02-03', '정보보안');
 select
	*
from
	course_registering_information_tb crit
	left outer join course_tb ct on(ct.course_id = crit.course_id)
	left outer join instructor_tb it on(it.instructor_id = crit.instructor_id)
	left outer join major_tb mt on(mt.major_id = crit.major_id);
    
-- while-do
call sp_loop_insert_data_b(10);
select * from data_b_tb;