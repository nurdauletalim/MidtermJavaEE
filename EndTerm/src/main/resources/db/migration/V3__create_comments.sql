create table if not exists comments(
id int primary key,
postid int,
userid int,
comment varchar(1000),
foreign key(postid) references posts(postid),
foreign key(userid) references users(id)
)