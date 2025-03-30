select
	(select
		student_name
	from
		student_tb
	where
		student_tb.student_id = course_registering_tb.student_id
	) as student_name,
	(select
		(select
			course_name
		from
			course_tb
		where
			course_tb.course_id = course_registering_information_tb.course_id
		)
	from
		course_registering_information_tb
	where
		course_registering_information_tb.course_registering_information_id = course_registering_tb.course_registering_information_id
	) as course_name,
    (select
		(select
			instructor_name
		from
			instructor_tb
		where
			instructor_tb.instructor_id = course_registering_information_tb.instructor_id
        )
	from
		course_registering_information_tb
	where
		course_registering_information_tb.course_registering_information_id = course_registering_tb.course_registering_information_id
    ) as instructor_name
from
	course_registering_tb
where
	student_id = (select student_id from student_tb where student_name = '백진우');
    
    
    
select 
	(select
		(select
			course_name
		from
			course_tb
		where
			course_tb.course_id = course_registering_information_tb.course_id)
	from
		course_registering_information_tb
	where
		course_registering_information_tb.course_registering_information_id = course_registering_tb.course_registering_information_id
	) as course_name,
    (select
		student_name
	from
		student_tb
	where
		student_tb.student_id = course_registering_tb.student_id
	) as student_name
from
	course_registering_tb;
-- where
-- 	(select
--         (select
--             (select
-- 				course_registering_information_id
-- 			from
-- 				course_registering_tb
-- 			where
-- 				course_registering_information_tb.course_registering_information_id = course_registering_tb.course_registering_information_id)
-- 		from
-- 			course_registering_information_tb
-- 		where
-- 			course_registering_information_tb.course_id = course_tb.course_id
-- 		)
-- 	from
-- 		course_tb
-- 	where
-- 		course_tb.course_name = '데이터베이스론');