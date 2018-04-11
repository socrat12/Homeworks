CREATE TABLE t_books_in_order (
	amount int,
	order_id int REFERENCES t_order ("order_id"),
	book_id int REFERENCES t_book ("book_id")
);