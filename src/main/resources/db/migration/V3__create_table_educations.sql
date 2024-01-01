CREATE TABLE educations (
    id SERIAL PRIMARY KEY,
    course TEXT NOT NULL,
    institution TEXT NOT NULL,
    situation TEXT NOT NULL,
    developer_id INTEGER REFERENCES developers(id)
);