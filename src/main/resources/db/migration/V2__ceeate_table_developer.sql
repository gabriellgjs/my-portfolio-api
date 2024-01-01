CREATE TABLE developers (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    email TEXT NOT NULL,
    github_url TEXT NOT NULL,
    linkedin_url TEXT NOT NULL,
    about_us TEXT NOT NULL,
    whatsapp_phone TEXT NOT NULL,
    curriculum TEXT,
    user_id INTEGER REFERENCES users(id)
);