CREATE TABLE t_book (
	book_id SERIAL PRIMARY KEY,
	price int NOT NULL CHECK (price > 0),
	date_prod int,
	category varchar (30) NOT NULL,
	int_stock int NOT NULL,
	autor_id int,
	FOREIGN KEY (autor_id) REFERENCES t_autor (autor_id)
);