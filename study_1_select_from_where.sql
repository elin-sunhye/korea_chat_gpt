select
	*
from
	course_registering_information_tb
where
	instructor_id = (
					select
						instructor_id
					from
						instructor_tb
					where
						instructor_name = '이교수'
					);

select
	course_register_id,
    course_id as courseId,
    instructor_id,
    (select
		instructor_name
	from
		instructor_tb
	where
		instructor_tb.instructor_id = course_registering_information_tb.course_registering_information_id
	) as instructor_name
from
	course_registering_information_tb;
    
insert into student_tb
values
		(default, '최석현', 3,'남',1),
        (default, '백진우', 4,'남',1),
        (default, '박소율', 3,'여',2),
        (default, '정현영', 4,'여',1);
        
insert into course_registering_tb
values
		(default, 1,1),
        (default, 1,2),
        (default, 1,3),
        (default, 1,4),
        (default, 2,2),
        (default, 2,4),
        (default, 3,1),
        (default, 3,3),
        (default, 4,1),
        (default, 4,2),
        (default, 4,3),
        (default, 4,4),
        (default, 5,1),
        (default, 5,2),
        (default, 6,1),
        (default, 6,2),
        (default, 6,3);
        
select
	student_id,
    student_name,
    student_year,
    gender,
    (select
		major_name
	from
			major_tb
	where
		major_tb.major_id = student_tb.major_id
    ) as major_name
from
	student_tb;