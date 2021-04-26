create table if not exists posts (
postid int primary key,
topic varchar(50),
text varchar(1000),
likes int,
dislikes int,
userid int,
foreign key(userid) references users(id)
)