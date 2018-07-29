CREATE TABLE t_book (
	book_id SERIAL PRIMARY KEY,
	title varchar (100) NOT NULL,
	autor_id int,
	date_prod int,
	category varchar (60) NOT NULL,
	price dec (10,3) NOT NULL CHECK (price > 0),
	int_stock int NOT NULL,
	FOREIGN KEY (autor_id) REFERENCES t_autor (autor_id)
);