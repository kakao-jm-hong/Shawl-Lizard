create table IF NOT EXISTS member(
	id INT auto_increment primary key,
    member_id varchar(100),
    password varchar(100),
    nickname varchar(30)
);