CREATE TABLE experiences (
                            id SERIAL PRIMARY KEY,
                            title TEXT NOT NULL,
                            caption TEXT NOT NULL,
                            date_start DATE NOT NULL,
                            date_end DATE,
                            developer_id INTEGER REFERENCES developers(id)
);