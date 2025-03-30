# join
insert into data2_tb
values
	(default, '111'),
	(default, '222'),
	(default, '333'),
	(default, '444'),
	(default, '555');
    
select * from data2_tb;

insert into data1_tb
values
	(default, 'hhh', 6),
	(default, 'iii', 7);
    
select * from data1_tb;

-- join : 풀 조인 전체 조인
-- inner join : 없는 데이터는 join 하지 않음 (조건에 맞는 데이터만 출력)
-- outer join : 없는 데이터는 null 처리 (왼쪽 데이블 데이터는 다 출력 오른쪽은 조건에 맞으면 출력 조건에 맞지 않으면 null 처리)
select
	*
from 
	data1_tb
     -- 왼쪽 테이블(data1_tb) 기준으로 오른쪽 테이블(data2_tb)을 붙여라
    left outer join data2_tb on data2_tb.data2_id = data1_tb.data2_id; -- 붙일 행 이름 = 붙여질 테이블에서 비교할 행 / 행 이름이 같으면 어느 테이블에서 가져왔는지 명시 그러나 행 이름이 달라도 테이블 명 명시하는것이 좋다