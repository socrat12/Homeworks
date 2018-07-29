CREATE TABLE t_books_in_order (
	amount int NOT NULL,
	order_id int,
	book_id int,
	FOREIGN KEY (order_id) REFERENCES t_order ("order_id"),
	FOREIGN KEY (book_id) REFERENCES t_book ("book_id")
);