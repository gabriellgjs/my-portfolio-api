CREATE TABLE developer (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    email TEXT NOT NULL,
    githubURL TEXT NOT NULL,
    linkedinURL TEXT NOT NULL,
    aboutUs TEXT NOT NULL,
    whatsappPhone TEXT NOT NULL,
    curriculum TEXT,
    userId INTEGER REFERENCES users(id)
);