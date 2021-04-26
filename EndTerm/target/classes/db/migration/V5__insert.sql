insert into INSERT INTO users(
	id, name, pass, email)
	VALUES (1, 'Nurdaulet','123','nur@gmail.com'),
	values (2, 'John','1234','john@mail.ru');

INSERT INTO posts(
	postid, topic, text, likes, dislikes, userid)
	VALUES (1, 'First post', 'This is my first post', 100, 10, 1),
	VALUES (2, 'Second post', 'This is my second post', 50, 5, 2);

INSERT INTO comments(
	id, postid, userid, comment)
	VALUES (1, 1, 1, 'Hello'),
	VALUES (2, 1, 2, 'Hi'),
	VALUES (3, 2, 1, 'Nice'),
	VALUES (4, 2, 2, 'Great!');

INSERT INTO phones(
	id, name, price, imglink)
	VALUES (1, 'iPhone 12', 390990, 'https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/iphone-12-blue-select-2020?wid=940&hei=1112&fmt=png-alpha&qlt=80&.v=1604343704000');
	VALUES (2, 'Samsung S21', 350990, 'https://images.samsung.com/is/image/samsung/p6pim/ru/galaxy-s21/gallery/ru-galaxy-s21-ultra-5g-g988-366501-sm-g998bdbhser-360507965');
	VALUES (3, 'Xiaomi Mi 10', 359990, 'https://www.mobitron.kz/upload/iblock/d3d/d3dfb936604dfba5d65b3251fa92b987.png');