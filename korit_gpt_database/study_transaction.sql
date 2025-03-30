# transaction
-- @@ : 전역 변수

-- 기본적으로 모든 SQL 문이 자동으로 커밋
-- ; 즉, INSERT, UPDATE, **DELETE**와 같은 명령이 실행되면, '트랜잭션'이 즉시 커밋
-- autocommit이 ON (1): 모든 SQL 문이 실행 후 자동 커밋
-- autocommit이 OFF (0): 트랜잭션이 명시적으로 커밋(COMMIT) 또는 롤백(ROLLBACK)될 때까지 대기
select @@autocommit;
set autocommit = 0;

insert into data_b_tb
values
	(default, '777');
    
commit;
    
select * from data_b_tb;

-- transaction 사용
# start transaction;
# 	query 문
# rollback;
# savepoint 이름a;
# rollback 이름a;
# commit;
start transaction;

	insert into data_b_tb
    values
		(default, '4040');
        
	update
		data_b_tb
	set
		data_b_value = '999'
	where
		data_b_value = '777';
        
rollback;

savepoint aa; -- 실행 후 작업을 하고,
rollback to aa; -- 여기서 롤백을 하면 savepoint 실행 이후의 작업만 롤백

commit; -- commit후 rollback 불가