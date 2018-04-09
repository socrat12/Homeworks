CREATE TABLE t_order (
	id SERIAL PRIMARY KEY,
	order_date date NOT NULL,
	user_id int REFERENCES t_user ("id")
);