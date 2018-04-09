CREATE TABLE t_books_in_order (
	amount int,
	order_id int REFERENCES t_order ("id"),
	book_id int REFERENCES t_book ("id")
);