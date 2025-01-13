# storaged procedures
-- 반복적인 데이터베이스 작업을 효율적으로 처리하고, 복잡한 SQL 로직을 캡슐화하여 코드 재사용성을 높이기 위해 사용
-- 저장 프로시저는 데이터베이스에 저장된 SQL 코드 블록으로, 호출하면 한 번에 실행

call sp_insert_book('aaa', '123', '테스트저자', '테스트카테고리', '테스트출', 'http://');


/* 
	# 예제
	course_tb(과목명)
    call sp_insert_course_registering_information_tb(*과목명, *교수명, 요일, 시작일, 종료일, *학과)
 */
 call sp_insert_course_registering_information('temp과목2', 'temp교수2', '수', '2020-12-12', '2023-09-03', 'temp학과2');