   
# 문자열 함수
-- concat
-- ; 전달받은 문자열을 모두 결합하여 하나의 문자열로 반환

-- locate()
-- ; 전달받은 문자열이 특정 문자열에서 처음으로 나타나는 위치 인덱스 반환alter
-- ; index는 1부터 시작!

-- left(), right()
-- ; 왼쪽에서 부터, 오른쪽에서 부터

-- replace('문자열', '특정 문자')
-- ; 해당 문자열에서 특정 문자열로 변환

-- trim() : 양 끝 공백 제거
-- leading : 앞쪽에서 특정 문자 또는 공백 제거
-- trailing: 뒷쪽에서 특정 문자 또는 공백 제거

-- format()
-- ;  숫자 타입의 데이터를 세 자리마다 쉼표(,)를 사용하는 '#,###,###.##' 형식으로 변환
-- !! 반환되는 데이터의 형식이 숫자 타입이 아닌 문자열 타입 !!

-- LPAD() : 왼쪽에 특정문자를 원하는 자리수만큼 채워서 반환
-- 사용법 : LPAD(원본문자열 , 원하는 자리수, 채울 문자열)
-- ex ) SELECT LPAD('ABC',10,'0')  FROM DUAL;
-- 결과 : 0000000ABC

-- RPAD() : 오른쪽에 특정문자를 원하는 자리수만큼 채워서 반환
-- 사용법 : RPAD(원본문자열 , 원하는 자리수, 채울 문자열)
-- ex ) SELECT RPAD('ABC',10,'0')  FROM DUAL;
-- 결과 : ABC0000000
select
	-- 대댓글 위치
	-- 0001.0004.0010.0005 -- 1410
    -- 0001.0041.0001
    lpad('123', 5, 0),
    rpad('qwer',5, 0);
    

# 수학 함수
-- abs()
-- ; 절댓값 반환

-- rand()
-- ; 0.0보다 크거나 같고 1.0보다 작은 하나의 실수를 무작위로 생성 반환


# 날짜 시간 함수
select
	year(now()),
	month(now()),
	day(now()),
    hour(now()),
    minute(now()),
    second(now());

-- dayofweek()
-- ; 전달받은 값의 일자가 해당 주에서 몇 번째 날인지를 반환
-- 1부터 7 사이의 값을 반환 (일요일 = 1, 토요일 = 7)

-- dayofmonth()
-- 전달받은 값의 일자가 해당 월에서 몇 번째 날인지를 반환
-- 0부터 31 사이의 값을 반환

-- dayofyear()
-- ; 전달받은 값의 일자가 해당 연도에서 몇 번째 날인지를 반환
-- 1부터 366 사이의 값을 반환

-- date_format()
-- 전달받은 형식에 맞춰 날짜와 시간 정보를 문자열로 반환
select
	date_format(now(), '%Y년 %M월 %D일'),
	date_format(now(), '%y년 %m월 %d일');
    
-- date_add(기준날짜, INTERVAL 1 SECOND) : 날짜, 시간 더하기
-- date_sub(기준날짜, INTERVAL 1 SECOND) : 날짜, 시간 빼기
-- dateidff(expr1 : 종료일, expr2 : 시작일) : 두 기간 사이의 일수 계산
-- timediff(expr1 : 종료 시간, expr2 : 시작 시간) : 두 기간 사이의 시간 계산
-- period_diff(P1 : 종료 년월, P2 : 시작 년월) : 두 기간 사이의 개월 수 계산
-- timestampdiff(unit - 반환 값 형식 (MONTH, YEAR, HOUR ...), datetime_expr1 - 시작일, datetime_expr2 - 종료일) : 두 기간 사이의 시간 계산

-- delete
-- ; 테이블 한 로우 삭제 (whwere 안 쓰면 테이블의 모든 데이터 삭제)
delete
from
	book_tb
where
	book_id = 1;