CREATE TABLE skills (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL UNIQUE
);

CREATE TABLE developers_skills (
    developer_id INT NOT NULL,
    skill_id INT NOT NULL,
    PRIMARY KEY (developer_id, skill_id),
    FOREIGN KEY (developer_id) REFERENCES developers (id),
    FOREIGN KEY (skill_id) REFERENCES skills (id)
);