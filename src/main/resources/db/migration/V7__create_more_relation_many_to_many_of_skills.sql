CREATE TABLE experiences_skills (
    experience_id INT NOT NULL,
    skill_id INT NOT NULL,
    PRIMARY KEY (experience_id, skill_id),
    FOREIGN KEY (experience_id) REFERENCES experiences (id),
    FOREIGN KEY (skill_id) REFERENCES skills (id)
);

CREATE TABLE projects (
    id SERIAL PRIMARY KEY,
    title TEXT NOT NULL,
    caption TEXT NOT NULL,
    owner TEXT NOT NULL,
    description TEXT NOT NULL,
    url TEXT,
    developer_id INTEGER REFERENCES developers(id)
);


CREATE TABLE projects_skills (
    project_id INT NOT NULL,
    skill_id INT NOT NULL,
    PRIMARY KEY (project_id, skill_id),
    FOREIGN KEY (project_id) REFERENCES projects (id),
    FOREIGN KEY (skill_id) REFERENCES skills (id)
);