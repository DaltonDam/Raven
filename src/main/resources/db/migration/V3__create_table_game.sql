CREATE TABLE game (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2),
    release_date DATE,
    developer VARCHAR(255),
    publisher VARCHAR(255)
);
